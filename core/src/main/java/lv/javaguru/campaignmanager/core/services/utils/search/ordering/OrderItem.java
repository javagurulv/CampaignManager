package lv.javaguru.campaignmanager.core.services.utils.search.ordering;

public class OrderItem {

    private String field;
    private OrderType orderType;

    public OrderItem(String field, OrderType orderType) {
        this.field = field;
        this.orderType = orderType;
    }

    public String getField() {
        return field;
    }

    public OrderType getOrderType() {
        return orderType;
    }
}
