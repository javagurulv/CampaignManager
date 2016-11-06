package lv.javaguru.campaignmanager.integrations.rest.campaigngroups;

import lv.javaguru.campaignmanager.integrations.rest.api.CampaignGroupResource;
import lv.javaguru.campaignmanager.integrations.rest.dto.CampaignGroupDTO;

import static lv.javaguru.campaignmanager.integrations.rest.dto.builders.CampaignGroupDTOBuilder.createCampaignGroupDTO;

public class CampaignGroupActions {

    private CampaignGroupResource resource;

    public CampaignGroupActions(CampaignGroupResource resource) {
        this.resource = resource;
    }

    public CampaignGroupDTO create(String title) {
        return resource.create(
                createCampaignGroupDTO().withTitle(title).build()
        );
    }

    public CampaignGroupDTO get(Long campaignGroupId) {
        return resource.get(campaignGroupId);
    }

}
