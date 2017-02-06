package lv.javaguru.campaignmanager.core.services.utils.search.ordering;

public class OrderItemBuilder {

    private String field;
    private OrderType orderType;

    private OrderItemBuilder() { }

    public static OrderItemBuilder createOrderItem() {
        return new OrderItemBuilder();
    }

    public OrderItem build() {
        return new OrderItem(field, orderType);
    }

    public OrderItemBuilder withField(String field) {
        this.field = field;
        return this;
    }

    public OrderItemBuilder with(OrderType orderType) {
        this.orderType = orderType;
        return this;
    }

}
