package lv.javaguru.campaignmanager.core.services.utils.search.conditions;

public class ConditionItem {

    private String field;
    private ConditionType operation;
    private String value;

    public ConditionItem(String field,
                         ConditionType operation,
                         String value) {
        this.field = field;
        this.operation = operation;
        this.value = value;
    }

    public String getField() {
        return field;
    }

    public ConditionType getOperation() {
        return operation;
    }

    public String getValue() {
        return value;
    }
}
