package lv.javaguru.campaignmanager.core.services.utils.search.conditions;

import java.util.ArrayList;
import java.util.List;

public class ConditionBlock {

    private List<ConditionItem> items = new ArrayList<>();

    public void addItem(ConditionItem conditionItem) {
        items.add(conditionItem);
    }

    public void addItem(ConditionItemBuilder conditionItemBuilder) {
        items.add(conditionItemBuilder.build());
    }

    public List<ConditionItem> getItems() {
        return items;
    }

}
