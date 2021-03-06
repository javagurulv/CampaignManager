package lv.javaguru.campaignmanager.core.commands.campaigngroups;

import lv.javaguru.campaignmanager.api.dto.groups.CampaignGroupDTO;
import lv.javaguru.campaignmanager.core.DomainCommandResult;

public class CreateCampaignGroupResult implements DomainCommandResult {

    private CampaignGroupDTO campaignGroup;

    public CreateCampaignGroupResult(CampaignGroupDTO campaignGroup) {
        this.campaignGroup = campaignGroup;
    }

    public CampaignGroupDTO getCampaignGroup() {
        return campaignGroup;
    }

}
