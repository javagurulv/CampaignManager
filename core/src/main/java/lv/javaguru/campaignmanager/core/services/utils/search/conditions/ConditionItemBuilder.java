package lv.javaguru.campaignmanager.core.services.utils.search.conditions;

public class ConditionItemBuilder {

    private String field;
    private ConditionType operation;
    private String value;

    private ConditionItemBuilder() { }

    public static ConditionItemBuilder createConditionItem() {
        return new ConditionItemBuilder();
    }

    public ConditionItem build() {
        return new ConditionItem(field, operation, value);
    }

    public ConditionItemBuilder withField(String field) {
        this.field = field;
        return this;
    }

    public ConditionItemBuilder withOperation(ConditionType operation) {
        this.operation = operation;
        return this;
    }

    public ConditionItemBuilder withValue(String value) {
        this.value = value;
        return this;
    }

}
