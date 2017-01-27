package lv.javaguru.campaignmanager.core.vo;

public class CampaignGroupId {

    private Long groupId;

    public CampaignGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long get() {
        return groupId;
    }

    public boolean isNull() {
        return groupId == null;
    }
}
