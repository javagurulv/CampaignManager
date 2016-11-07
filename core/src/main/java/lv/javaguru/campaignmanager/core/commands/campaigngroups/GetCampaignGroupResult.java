package lv.javaguru.campaignmanager.core.commands.campaigngroups;

import lv.javaguru.campaignmanager.api.dto.CampaignGroupDTO;
import lv.javaguru.campaignmanager.core.commands.DomainCommandResult;

public class GetCampaignGroupResult implements DomainCommandResult {

    private CampaignGroupDTO campaignGroup;

    public GetCampaignGroupResult(CampaignGroupDTO campaignGroup) {
        this.campaignGroup = campaignGroup;
    }

    public CampaignGroupDTO getCampaignGroup() {
        return campaignGroup;
    }

}
