package lv.javaguru.campaignmanager.core.services.utils.search.paging;

import lv.javaguru.campaignmanager.core.services.utils.search.model.SearchParameters;

public interface PagingBlockParser {

    PagingBlock parse(SearchParameters parameters);

}
