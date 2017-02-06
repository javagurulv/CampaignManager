package lv.javaguru.campaignmanager.core.services.utils.search.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AllowedFields {

    private List<SearchField> fields = new ArrayList<>();

    public AllowedFields(List<SearchField> fields) {
        this.fields = fields;
    }

    public boolean contains(String fieldName) {
        return fields.stream()
                .anyMatch(f -> f.containName(fieldName));
    }

    public Optional<SearchField> getByName(String fieldName) {
        return fields.stream()
                .filter(f -> f.containName(fieldName))
                .findAny();
    }

}
