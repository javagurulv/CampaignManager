package lv.javaguru.campaignmanager.core.services.utils.search.converters;

import lv.javaguru.campaignmanager.core.services.utils.search.ParsingException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements ValueConverter<Date> {

    public static final DateConverter INSTANCE = new DateConverter();

    private DateConverter() { }


    private static final String DATE_FORMAT = "dd-MM-yyyy";

    @Override
    public Date convert(String str) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
            return formatter.parse(str);
        } catch (ParseException e) {
            throw new ParsingException("Incorrect date format " + str);
        }
    }

}
