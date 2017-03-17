package lv.javaguru.campaignmanager.core.services.utils.search.ordering;

import lv.javaguru.campaignmanager.core.services.utils.search.model.SearchParameters;

public interface OrderingBlockParser {

    OrderingBlock parse(SearchParameters parameters);

}
