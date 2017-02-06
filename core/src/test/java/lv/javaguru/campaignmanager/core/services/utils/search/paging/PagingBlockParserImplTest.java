package lv.javaguru.campaignmanager.core.services.utils.search.paging;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import lv.javaguru.campaignmanager.core.services.utils.search.ParsingException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static lv.javaguru.campaignmanager.core.services.utils.search.model.SearchParametersBuilder.createSearchParameters;

public class PagingBlockParserImplTest {

    private PagingBlockParserImpl parser = new PagingBlockParserImpl();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void parseSuccess() {
        PagingBlock block = parser.parse(
                createSearchParameters()
                        .withPaging("{page:1}{page_size:1}")
                        .build()
        );
        assertThat(block.getPage(), is(1));
        assertThat(block.getPageSize(), is(1));
    }

    @Test
    public void parseFail() {
        thrown.expect(ParsingException.class);
        thrown.expectMessage("Incorrect paging section: " + "{page:1}");
        parser.parse(
                createSearchParameters()
                        .withPaging("{page:1}")
                        .build()
        );
    }

}
