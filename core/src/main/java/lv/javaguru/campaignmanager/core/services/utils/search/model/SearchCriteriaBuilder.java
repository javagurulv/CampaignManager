package lv.javaguru.campaignmanager.core.services.utils.search.model;

import lv.javaguru.campaignmanager.core.services.utils.search.conditions.ConditionBlock;
import lv.javaguru.campaignmanager.core.services.utils.search.ordering.OrderingBlock;
import lv.javaguru.campaignmanager.core.services.utils.search.paging.PagingBlock;

public class SearchCriteriaBuilder {

    private ConditionBlock conditions;
    private OrderingBlock ordering;
    private PagingBlock paging;

    private SearchCriteriaBuilder() {

    }

    public static SearchCriteriaBuilder createSearchCriteria() {
        return new SearchCriteriaBuilder();
    }

    public SearchCriteria build() {
        return new SearchCriteria(conditions, ordering, paging);
    }

    public SearchCriteriaBuilder with(ConditionBlock conditions) {
        this.conditions = conditions;
        return this;
    }

    public SearchCriteriaBuilder with(PagingBlock paging) {
        this.paging = paging;
        return this;
    }

    public SearchCriteriaBuilder with(OrderingBlock ordering) {
        this.ordering = ordering;
        return this;
    }

}
