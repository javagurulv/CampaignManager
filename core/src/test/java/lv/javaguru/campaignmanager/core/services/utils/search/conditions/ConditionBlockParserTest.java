package lv.javaguru.campaignmanager.core.services.utils.search.conditions;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import lv.javaguru.campaignmanager.core.services.utils.search.ParsingException;
import lv.javaguru.campaignmanager.core.services.utils.search.model.SearchField;
import lv.javaguru.campaignmanager.core.services.utils.search.converters.LongConverter;
import lv.javaguru.campaignmanager.core.services.utils.search.converters.StringConverter;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static lv.javaguru.campaignmanager.core.services.utils.search.model.AllowedFieldsBuilder.createAllowedFields;
import static lv.javaguru.campaignmanager.core.services.utils.search.model.SearchParametersBuilder.createSearchParameters;

public class ConditionBlockParserTest {

    private ConditionBlockParser parser = new ConditionBlockParser();

    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Test
    public void parseOneField() {
        ConditionBlock block = parser.parse(
                createSearchParameters()
                        .with(createAllowedFields()
                                .with(new SearchField("title", StringConverter.INSTANCE))
                        )
                        .withConditions("{title:eq:aaa}")
                        .build()
        );
        assertThat(block.getItems().size(), is(1));
        assertThat(block.getItems().get(0).getField(), is("title"));
        assertThat(block.getItems().get(0).getOperation(), is(ConditionType.EQ));
        assertThat(block.getItems().get(0).getValue(), is("aaa"));
    }

    @Test
    public void parseTwoFields() {
        ConditionBlock block = parser.parse(
                createSearchParameters()
                        .with(createAllowedFields()
                                .with(new SearchField("title", StringConverter.INSTANCE))
                                .with(new SearchField("id", LongConverter.INSTANCE))
                        )
                        .withConditions("{title:eq:aaa}{id:le:111}")
                        .build()
        );
        assertThat(block.getItems().size(), is(2));
        assertThat(block.getItems().get(0).getField(), is("title"));
        assertThat(block.getItems().get(0).getOperation(), is(ConditionType.EQ));
        assertThat(block.getItems().get(0).getValue(), is("aaa"));
        assertThat(block.getItems().get(1).getField(), is("id"));
        assertThat(block.getItems().get(1).getOperation(), is(ConditionType.LE));
        assertThat(block.getItems().get(1).getValue(), is("111"));
    }

    @Test
    public void shouldThrowExceptionWhenParseOneField() {
        thrown.expect(ParsingException.class);
        thrown.expectMessage("Incorrect conditions section: " + "{title:asc");
        parser.parse(
                createSearchParameters()
                        .withConditions("{title:asc")
                        .build()

        );
    }

    @Test
    public void shouldThrowExceptionWhenParseTwoFields() {
        thrown.expect(ParsingException.class);
        thrown.expectMessage("Incorrect conditions section: " + "{id");
        parser.parse(
                createSearchParameters()
                        .with(createAllowedFields()
                                .with(new SearchField("title", StringConverter.INSTANCE))
                        )
                        .withConditions("{title:le:abc}{id")
                        .build()
        );
    }

}
