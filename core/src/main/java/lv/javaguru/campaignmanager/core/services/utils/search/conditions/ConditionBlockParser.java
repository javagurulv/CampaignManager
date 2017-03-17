package lv.javaguru.campaignmanager.core.services.utils.search.conditions;

import lv.javaguru.campaignmanager.core.services.utils.search.model.SearchParameters;

public interface ConditionBlockParser {

    ConditionBlock parse(SearchParameters parameters);

}
