package lv.javaguru.campaignmanager.core.services.utils.search.converters;

public class StringConverter implements ValueConverter<String> {

    public static final StringConverter INSTANCE = new StringConverter();

    private StringConverter() { }

    @Override
    public String convert(String str) {
        return str;
    }

}
