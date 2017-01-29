package lv.javaguru.campaignmanager.api.dto.groups;

import java.io.Serializable;

public class CreateCampaignGroupRequest implements Serializable {

    private String groupTitle;

    public String getGroupTitle() {
        return groupTitle;
    }

    public void setGroupTitle(String groupTitle) {
        this.groupTitle = groupTitle;
    }
}
