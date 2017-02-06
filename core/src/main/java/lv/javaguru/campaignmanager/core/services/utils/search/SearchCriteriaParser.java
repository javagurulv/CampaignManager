package lv.javaguru.campaignmanager.core.services.utils.search;

import lv.javaguru.campaignmanager.core.services.utils.search.model.SearchCriteria;
import lv.javaguru.campaignmanager.core.services.utils.search.model.SearchParameters;

public interface SearchCriteriaParser {

    SearchCriteria parse(SearchParameters parameters);

}
