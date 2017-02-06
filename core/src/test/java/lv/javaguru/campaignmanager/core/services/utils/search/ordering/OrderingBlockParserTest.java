package lv.javaguru.campaignmanager.core.services.utils.search.ordering;

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

public class OrderingBlockParserTest {

    private OrderingBlockParser parser = new OrderingBlockParser();

    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Test
    public void parseOneField() {
        OrderingBlock block = parser.parse(
                createSearchParameters()
                        .with(createAllowedFields()
                                .with(new SearchField("title", StringConverter.INSTANCE))
                        )
                        .withOrdering("{title:asc}")
                        .build()
        );
        assertThat(block.getItems().size(), is(1));
        assertThat(block.getItems().get(0).getField(), is("title"));
        assertThat(block.getItems().get(0).getOrderType(), is(OrderType.ASC));
    }

    @Test
    public void parseTwoFields() {
        OrderingBlock block = parser.parse(
                createSearchParameters()
                        .with(createAllowedFields()
                                .with(new SearchField("title", StringConverter.INSTANCE))
                                .with(new SearchField("id", LongConverter.INSTANCE))
                        )
                        .withOrdering("{title:asc}{id:desc}")
                        .build()
        );
        assertThat(block.getItems().size(), is(2));
        assertThat(block.getItems().get(0).getField(), is("title"));
        assertThat(block.getItems().get(0).getOrderType(), is(OrderType.ASC));
        assertThat(block.getItems().get(1).getField(), is("id"));
        assertThat(block.getItems().get(1).getOrderType(), is(OrderType.DESC));
    }

    @Test
    public void shouldThrowExceptionWhenParseOneField() {
        thrown.expect(ParsingException.class);
        thrown.expectMessage("Incorrect ordering section: " + "{title:asc");
        parser.parse(
                createSearchParameters()
                        .withOrdering("{title:asc")
                        .build()
        );
    }

    @Test
    public void shouldThrowExceptionWhenParseTwoFields() {
        thrown.expect(ParsingException.class);
        thrown.expectMessage("Incorrect ordering section: " + "{id");
        parser.parse(
                createSearchParameters()
                        .with(createAllowedFields()
                                .with(new SearchField("title", StringConverter.INSTANCE))
                        )
                        .withOrdering("{title:asc}{id")
                        .build()
        );
    }

}
