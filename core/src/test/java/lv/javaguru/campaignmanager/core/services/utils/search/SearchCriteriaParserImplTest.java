package lv.javaguru.campaignmanager.core.services.utils.search;

import lv.javaguru.campaignmanager.core.services.utils.search.model.SearchCriteria;
import lv.javaguru.campaignmanager.core.services.utils.search.model.SearchField;
import org.junit.Test;
import lv.javaguru.campaignmanager.core.services.utils.search.converters.StringConverter;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static lv.javaguru.campaignmanager.core.services.utils.search.model.AllowedFieldsBuilder.createAllowedFields;
import static lv.javaguru.campaignmanager.core.services.utils.search.model.SearchParametersBuilder.createSearchParameters;

public class SearchCriteriaParserImplTest {

    private SearchCriteriaParserImpl parser = new SearchCriteriaParserImpl();


    @Test
    public void parseConditionsBlock() {
        SearchCriteria searchCriteria = parser.parse(
                createSearchParameters()
                        .with(createAllowedFields()
                                .with(new SearchField("title", StringConverter.INSTANCE))
                        )
                        .withConditions("{title:eq:aaa}")
                    .build()
        );
        assertThat(searchCriteria.containsConditions(), is(true));
        assertThat(searchCriteria.containsOrdering(), is(false));
        assertThat(searchCriteria.containsPaging(), is(false));
    }

    @Test
    public void parseOrderingBlock() {
        SearchCriteria searchCriteria = parser.parse(
                createSearchParameters()
                        .with(createAllowedFields()
                                .with(new SearchField("title", StringConverter.INSTANCE))
                        )
                        .withOrdering("{title:asc}")
                        .build()
        );
        assertThat(searchCriteria.containsConditions(), is(false));
        assertThat(searchCriteria.containsOrdering(), is(true));
        assertThat(searchCriteria.containsPaging(), is(false));
    }

    @Test
    public void parsePagingBlock() {
        SearchCriteria searchCriteria = parser.parse(
                createSearchParameters()
                        .withPaging("{page:1}{page_size:1}")
                        .build()
        );
        assertThat(searchCriteria.containsConditions(), is(false));
        assertThat(searchCriteria.containsOrdering(), is(false));
        assertThat(searchCriteria.containsPaging(), is(true));
    }

}
