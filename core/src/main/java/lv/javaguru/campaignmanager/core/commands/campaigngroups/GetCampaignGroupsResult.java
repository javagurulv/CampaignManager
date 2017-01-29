package lv.javaguru.campaignmanager.core.commands.campaigngroups;

import lv.javaguru.campaignmanager.api.dto.groups.CampaignGroupDTO;
import lv.javaguru.campaignmanager.core.DomainCommandResult;

import java.util.List;

public class GetCampaignGroupsResult implements DomainCommandResult {

    private List<CampaignGroupDTO> campaignGroups;

    public GetCampaignGroupsResult(List<CampaignGroupDTO> campaignGroups) {
        this.campaignGroups = campaignGroups;
    }

    public List<CampaignGroupDTO> getCampaignGroups() {
        return campaignGroups;
    }
}
