package lv.javaguru.campaignmanager.core.commands.campaigngroups;

import lv.javaguru.campaignmanager.core.vo.CampaignGroupId;
import lv.javaguru.campaignmanager.core.DomainCommand;

public class GetCampaignGroupCommand
        implements DomainCommand<GetCampaignGroupResult> {

    private CampaignGroupId campaignGroupId;

    public GetCampaignGroupCommand(CampaignGroupId campaignGroupId) {
        this.campaignGroupId = campaignGroupId;
    }

    public CampaignGroupId getCampaignGroupId() {
        return campaignGroupId;
    }
}
