package lv.javaguru.campaignmanager.core.commands.campaigngroups;

import lv.javaguru.campaignmanager.core.commands.DomainCommand;

public class GetCampaignGroupCommand
        implements DomainCommand<GetCampaignGroupResult> {

    private Long campaigGroupId;

    public GetCampaignGroupCommand(Long campaigGroupId) {
        this.campaigGroupId = campaigGroupId;
    }

    public Long getCampaigGroupId() {
        return campaigGroupId;
    }

}
