package lv.javaguru.campaignmanager.core.services.utils.search;

import lv.javaguru.campaignmanager.core.services.utils.search.converters.StringConverter;
import lv.javaguru.campaignmanager.core.services.utils.search.model.SearchCriteria;
import lv.javaguru.campaignmanager.core.services.utils.search.model.SearchField;
import lv.javaguru.campaignmanager.core.services.utils.search.model.SearchParameters;
import lv.javaguru.campaignmanager.core.services.utils.search.paging.PagingBlock;
import lv.javaguru.campaignmanager.core.services.utils.search.paging.PagingBlockParser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static lv.javaguru.campaignmanager.core.services.utils.search.model.AllowedFieldsBuilder.createAllowedFields;
import static lv.javaguru.campaignmanager.core.services.utils.search.model.SearchParametersBuilder.createSearchParameters;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class SearchCriteriaParserImplTest {

    @Mock private PagingBlockParser pagingBlockParser;

    @InjectMocks
    private SearchCriteriaParser parser = new SearchCriteriaParserImpl();


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
        SearchParameters parameters = createSearchParameters()
                .withPaging("{page:1}{page_size:1}").build();
        PagingBlock pagingBlock = mock(PagingBlock.class);
        doReturn(pagingBlock).when(pagingBlockParser).parse(parameters);

        SearchCriteria searchCriteria = parser.parse(parameters);

        assertThat(searchCriteria.containsConditions(), is(false));
        assertThat(searchCriteria.containsOrdering(), is(false));
        assertThat(searchCriteria.containsPaging(), is(true));
        assertThat(searchCriteria.getPaging(), is(sameInstance(pagingBlock)));
    }

}
