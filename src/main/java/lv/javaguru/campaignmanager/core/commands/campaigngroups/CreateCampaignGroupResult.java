package lv.javaguru.campaignmanager.core.commands.campaigngroups;

import lv.javaguru.campaignmanager.core.commands.DomainCommandResult;
import lv.javaguru.campaignmanager.integrations.rest.dto.CampaignGroupDTO;

public class CreateCampaignGroupResult implements DomainCommandResult {

    private CampaignGroupDTO campaignGroup;

    public CreateCampaignGroupResult(CampaignGroupDTO campaignGroup) {
        this.campaignGroup = campaignGroup;
    }

    public CampaignGroupDTO getCampaignGroup() {
        return campaignGroup;
    }

}
