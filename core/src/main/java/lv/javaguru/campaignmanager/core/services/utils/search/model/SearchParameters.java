package lv.javaguru.campaignmanager.core.services.utils.search.model;

public class SearchParameters {

    private AllowedFields allowedFields;

    private String conditions;
    private String ordering;
    private String paging;

    public SearchParameters(AllowedFields allowedFields,
                            String conditions,
                            String ordering,
                            String paging) {
        this.allowedFields = allowedFields;
        this.conditions = conditions;
        this.ordering = ordering;
        this.paging = paging;
    }

    public AllowedFields getAllowedFields() {
        return allowedFields;
    }

    public boolean containsConditions() {
        return conditions != null && !"".equals(conditions);
    }

    public String getConditions() {
        return conditions;
    }

    public boolean containsOrdering() {
        return ordering != null && !"".equals(ordering);
    }

    public String getOrdering() {
        return ordering;
    }

    public boolean containsPaging() {
        return paging != null && !"".equals(paging);
    }

    public String getPaging() {
        return paging;
    }

}
