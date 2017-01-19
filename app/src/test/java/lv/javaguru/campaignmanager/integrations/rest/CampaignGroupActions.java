package lv.javaguru.campaignmanager.integrations.rest;

import lv.javaguru.campaignmanager.api.CampaignGroupResource;
import lv.javaguru.campaignmanager.api.dto.CampaignGroupDTO;

import static lv.javaguru.campaignmanager.api.dto.builders.CampaignGroupDTOBuilder.createCampaignGroupDTO;

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

    public void edit(Long campaignGroupId, String newGroupTitle) {
        resource.edit(campaignGroupId, newGroupTitle);
    }

    public CampaignGroupDTO get(Long campaignGroupId) {
        return resource.get(campaignGroupId);
    }

}
