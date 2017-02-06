package lv.javaguru.campaignmanager.core.services.utils.search.model;

import java.util.ArrayList;
import java.util.List;

public class AllowedFieldsBuilder {

    private List<SearchField> fields = new ArrayList<>();

    private AllowedFieldsBuilder() { }

    public static AllowedFieldsBuilder createAllowedFields() {
        return new AllowedFieldsBuilder();
    }

    public AllowedFields build() {
        return new AllowedFields(fields);
    }

    public AllowedFieldsBuilder with(SearchField searchField) {
        fields.add(searchField);
        return this;
    }

}
