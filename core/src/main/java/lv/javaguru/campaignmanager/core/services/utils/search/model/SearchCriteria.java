package lv.javaguru.campaignmanager.core.services.utils.search.model;

import lv.javaguru.campaignmanager.core.services.utils.search.conditions.ConditionBlock;
import lv.javaguru.campaignmanager.core.services.utils.search.ordering.OrderingBlock;
import lv.javaguru.campaignmanager.core.services.utils.search.paging.PagingBlock;

public class SearchCriteria {

    private ConditionBlock conditions;
    private OrderingBlock ordering;
    private PagingBlock paging;

    public SearchCriteria(ConditionBlock conditions,
                          OrderingBlock ordering,
                          PagingBlock paging) {
        this.conditions = conditions;
        this.ordering = ordering;
        this.paging = paging;
    }

    public boolean containsConditions() {
        return getConditions() != null;
    }

    public ConditionBlock getConditions() {
        return conditions;
    }

    public boolean containsOrdering() {
        return getOrdering() != null;
    }

    public OrderingBlock getOrdering() {
        return ordering;
    }

    public boolean containsPaging() {
        return getPaging() != null;
    }

    public PagingBlock getPaging() {
        return paging;
    }

}
