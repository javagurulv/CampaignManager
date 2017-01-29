package lv.javaguru.campaignmanager.api.dto.campaigns.task;

import java.io.Serializable;

public class CreateTaskCampaignRequest implements Serializable {

    private Long campaignGroupId;
    private String campaignTitle;


    public Long getCampaignGroupId() {
        return campaignGroupId;
    }

    public void setCampaignGroupId(Long campaignGroupId) {
        this.campaignGroupId = campaignGroupId;
    }

    public String getCampaignTitle() {
        return campaignTitle;
    }

    public void setCampaignTitle(String campaignTitle) {
        this.campaignTitle = campaignTitle;
    }
}
