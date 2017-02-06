package lv.javaguru.campaignmanager.core.services.utils.search.ordering;

import java.util.ArrayList;
import java.util.List;

public class OrderingBlock {

    private List<OrderItem> items = new ArrayList<>();

    public void addItem(OrderItem orderItem) {
        items.add(orderItem);
    }

    public void addItem(OrderItemBuilder orderItemBuilder) {
        items.add(orderItemBuilder.build());
    }

    public List<OrderItem> getItems() {
        return items;
    }
}
