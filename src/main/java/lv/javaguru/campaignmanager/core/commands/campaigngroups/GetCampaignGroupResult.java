package lv.javaguru.campaignmanager.core.commands.campaigngroups;

import lv.javaguru.campaignmanager.core.commands.DomainCommandResult;
import lv.javaguru.campaignmanager.integrations.rest.dto.CampaignGroupDTO;

public class GetCampaignGroupResult implements DomainCommandResult {

    private CampaignGroupDTO campaignGroup;

    public GetCampaignGroupResult(CampaignGroupDTO campaignGroup) {
        this.campaignGroup = campaignGroup;
    }

    public CampaignGroupDTO getCampaignGroup() {
        return campaignGroup;
    }

}
