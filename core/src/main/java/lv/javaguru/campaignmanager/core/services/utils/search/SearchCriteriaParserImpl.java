package lv.javaguru.campaignmanager.core.services.utils.search;

import lv.javaguru.campaignmanager.core.services.utils.search.conditions.ConditionBlock;
import lv.javaguru.campaignmanager.core.services.utils.search.conditions.ConditionBlockParser;
import lv.javaguru.campaignmanager.core.services.utils.search.model.SearchCriteria;
import lv.javaguru.campaignmanager.core.services.utils.search.model.SearchParameters;
import lv.javaguru.campaignmanager.core.services.utils.search.ordering.OrderingBlock;
import lv.javaguru.campaignmanager.core.services.utils.search.ordering.OrderingBlockParser;
import lv.javaguru.campaignmanager.core.services.utils.search.paging.PagingBlock;
import lv.javaguru.campaignmanager.core.services.utils.search.paging.PagingBlockParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
class SearchCriteriaParserImpl implements SearchCriteriaParser {

    private ConditionBlockParser conditionsParser = new ConditionBlockParser();
    private OrderingBlockParser orderingParser = new OrderingBlockParser();
    @Autowired private PagingBlockParser pagingParser;

    @Override
    public SearchCriteria parse(SearchParameters parameters) {
        ConditionBlock conditionBlock = null;
        OrderingBlock orderingBlock = null;
        PagingBlock pagingBlock = null;

        if (parameters.containsConditions()) {
            conditionBlock = conditionsParser.parse(parameters);
        }
        if (parameters.containsOrdering()) {
            orderingBlock = orderingParser.parse(parameters);
        }
        if (parameters.containsPaging()) {
            pagingBlock = pagingParser.parse(parameters);
        }

        return new SearchCriteria(conditionBlock, orderingBlock, pagingBlock);
    }

}
