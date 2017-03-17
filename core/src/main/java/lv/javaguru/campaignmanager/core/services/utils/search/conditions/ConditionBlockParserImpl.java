package lv.javaguru.campaignmanager.core.services.utils.search.conditions;

import lv.javaguru.campaignmanager.core.services.utils.search.model.AllowedFields;
import lv.javaguru.campaignmanager.core.services.utils.search.ParsingException;
import lv.javaguru.campaignmanager.core.services.utils.search.model.SearchParameters;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static lv.javaguru.campaignmanager.core.services.utils.search.conditions.ConditionItemBuilder.createConditionItem;

class ConditionBlockParserImpl implements ConditionBlockParser {

    private static final String REGEXP = "^\\{(\\w+):(eq|ls|le|gs|ge|ne):(\\w+)\\}";

    public ConditionBlock parse(SearchParameters parameters) {
        ConditionBlock block = new ConditionBlock();
        String str = parseItem(
                parameters.getConditions(),
                block,
                parameters.getAllowedFields()
        );
        while (!str.isEmpty()) {
            str = parseItem(str, block, parameters.getAllowedFields());
        }
        return block;
    }

    private static final int FIELD_GROUP_NUMBER = 1;
    private static final int OPERATION_GROUP_NUMBER = 2;
    private static final int VALUE_GROUP_NUMBER = 3;

    private String parseItem(String str,
                             ConditionBlock block,
                             AllowedFields allowedFields) {
        Pattern pattern = Pattern.compile(REGEXP);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            String field = matcher.group(FIELD_GROUP_NUMBER);
            String operation = matcher.group(OPERATION_GROUP_NUMBER);
            String value = matcher.group(VALUE_GROUP_NUMBER);

            if (!allowedFields.contains(field)) {
                throw new ParsingException("Not allowed field: " + field);
            }

            block.addItem(createConditionItem()
                    .withField(field)
                    .withOperation(ConditionType.valueOf(operation.toUpperCase()))
                    .withValue(value)
            );

            return matcher.replaceFirst("");
        } else {
            throw new ParsingException("Incorrect conditions section: " + str);
        }
    }

}
