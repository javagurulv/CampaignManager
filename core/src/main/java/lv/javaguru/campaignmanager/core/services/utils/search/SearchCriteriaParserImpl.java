package lv.javaguru.campaignmanager.core.services.utils.search;

import lv.javaguru.campaignmanager.core.services.utils.search.conditions.ConditionBlockParser;
import lv.javaguru.campaignmanager.core.services.utils.search.model.SearchCriteria;
import lv.javaguru.campaignmanager.core.services.utils.search.model.SearchCriteriaBuilder;
import lv.javaguru.campaignmanager.core.services.utils.search.model.SearchParameters;
import lv.javaguru.campaignmanager.core.services.utils.search.ordering.OrderingBlockParser;
import lv.javaguru.campaignmanager.core.services.utils.search.paging.PagingBlockParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static lv.javaguru.campaignmanager.core.services.utils.search.model.SearchCriteriaBuilder.createSearchCriteria;


@Component
class SearchCriteriaParserImpl implements SearchCriteriaParser {

    private ConditionBlockParser conditionsParser = new ConditionBlockParser();
    private OrderingBlockParser orderingParser = new OrderingBlockParser();
    @Autowired private PagingBlockParser pagingParser;

    @Override
    public SearchCriteria parse(SearchParameters parameters) {
        SearchCriteriaBuilder builder = createSearchCriteria();

        if (parameters.containsConditions()) {
            builder.with(conditionsParser.parse(parameters));
        }
        if (parameters.containsOrdering()) {
            builder.with(orderingParser.parse(parameters));
        }
        if (parameters.containsPaging()) {
            builder.with(pagingParser.parse(parameters));
        }

        return builder.build();
    }

}
