package lv.javaguru.campaignmanager.core.services.utils.search.model;

import lv.javaguru.campaignmanager.core.services.utils.search.converters.ValueConverter;

public class SearchField {

    private String name;
    private ValueConverter valueConverter;

    public SearchField(String name,
                       ValueConverter valueConverter) {
        this.name = name;
        this.valueConverter = valueConverter;
    }

    public String getName() {
        return name;
    }

    public boolean containName(String name) {
        return this.name.equals(name);
    }

    public ValueConverter getValueConverter() {
        return valueConverter;
    }
}
