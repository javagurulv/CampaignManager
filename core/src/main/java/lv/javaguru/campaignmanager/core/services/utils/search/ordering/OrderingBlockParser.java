package lv.javaguru.campaignmanager.core.services.utils.search.ordering;

import lv.javaguru.campaignmanager.core.services.utils.search.model.AllowedFields;
import lv.javaguru.campaignmanager.core.services.utils.search.ParsingException;
import lv.javaguru.campaignmanager.core.services.utils.search.model.SearchParameters;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static lv.javaguru.campaignmanager.core.services.utils.search.ordering.OrderItemBuilder.createOrderItem;

public class OrderingBlockParser {

    private static final String REGEXP = "^\\{(\\w+):(asc|desc)\\}";

    public OrderingBlock parse(SearchParameters parameters) {
        OrderingBlock block = new OrderingBlock();
        String str = parseItem(
                parameters.getOrdering(),
                block,
                parameters.getAllowedFields()
        );
        while (!str.isEmpty()) {
            str = parseItem(str, block, parameters.getAllowedFields());
        }
        return block;
    }

    private static final int FIELD_GROUP_NUMBER = 1;
    private static final int ORDER_TYPE_GROUP_NUMBER = 2;

    private String parseItem(String str,
                             OrderingBlock block,
                             AllowedFields allowedFields) {
        Pattern pattern = Pattern.compile(REGEXP);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            String field = matcher.group(FIELD_GROUP_NUMBER);
            String orderType = matcher.group(ORDER_TYPE_GROUP_NUMBER);

            if (!allowedFields.contains(field)) {
                throw new ParsingException("Not allowed field: " + field);
            }

            block.addItem(createOrderItem()
                    .withField(field)
                    .with(OrderType.valueOf(orderType.toUpperCase()))
            );

            return matcher.replaceFirst("");
        } else {
            throw new ParsingException("Incorrect ordering section: " + str);
        }
    }

}
