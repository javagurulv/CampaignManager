package lv.javaguru.campaignmanager.core.services.utils.search.converters;

import lv.javaguru.campaignmanager.core.services.utils.search.ParsingException;

public class LongConverter implements ValueConverter<Long> {

    public static final LongConverter INSTANCE = new LongConverter();

    private LongConverter() { }

    @Override
    public Long convert(String str) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            throw new ParsingException("Incorrect number format " + str);
        }
    }

}
