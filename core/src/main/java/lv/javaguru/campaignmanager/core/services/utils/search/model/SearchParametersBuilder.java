package lv.javaguru.campaignmanager.core.services.utils.search.model;

public class SearchParametersBuilder {

    private AllowedFields allowedFields;

    private String conditions;
    private String ordering;
    private String paging;

    private SearchParametersBuilder() { }


    public static SearchParametersBuilder createSearchParameters() {
        return new SearchParametersBuilder();
    }

    public SearchParameters build() {
        return new SearchParameters(allowedFields, conditions, ordering, paging);
    }

    public SearchParametersBuilder with(AllowedFields allowedFields) {
        this.allowedFields = allowedFields;
        return this;
    }

    public SearchParametersBuilder with(AllowedFieldsBuilder allowedFieldsBuilder) {
        this.allowedFields = allowedFieldsBuilder.build();
        return this;
    }

    public SearchParametersBuilder withConditions(String conditions) {
        this.conditions = conditions;
        return this;
    }

    public SearchParametersBuilder withOrdering(String ordering) {
        this.ordering = ordering;
        return this;
    }

    public SearchParametersBuilder withPaging(String paging) {
        this.paging = paging;
        return this;
    }

}
