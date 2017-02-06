package lv.javaguru.campaignmanager.core.services.utils.search.converters;

import lv.javaguru.campaignmanager.core.services.utils.search.ParsingException;

public class IntegerConverter implements ValueConverter<Integer> {

    public static final IntegerConverter INSTANCE = new IntegerConverter();

    private IntegerConverter() { }

    @Override
    public Integer convert(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new ParsingException("Incorrect number format " + str);
        }
    }

}
