package lv.javaguru.campaignmanager.api.dto.groups;

import java.io.Serializable;

public class EditCampaignGroupRequest implements Serializable {

    private Long campaignGroupId;
    private String newGroupTitle;

    public Long getCampaignGroupId() {
        return campaignGroupId;
    }

    public void setCampaignGroupId(Long campaignGroupId) {
        this.campaignGroupId = campaignGroupId;
    }

    public String getNewGroupTitle() {
        return newGroupTitle;
    }

    public void setNewGroupTitle(String newGroupTitle) {
        this.newGroupTitle = newGroupTitle;
    }
}
