package lv.javaguru.campaignmanager.integrations.rest;

import lv.javaguru.campaignmanager.api.resources.CampaignGroupResource;
import lv.javaguru.campaignmanager.api.dto.CampaignGroupDTO;
import lv.javaguru.campaignmanager.api.dto.CreateCampaignGroupRequest;
import lv.javaguru.campaignmanager.api.dto.EditCampaignGroupRequest;

public class CampaignGroupActions {

    private CampaignGroupResource resource;

    public CampaignGroupActions(CampaignGroupResource resource) {
        this.resource = resource;
    }

    public CampaignGroupDTO create(String groupTitle) {
        CreateCampaignGroupRequest request = new CreateCampaignGroupRequest();
        request.setGroupTitle(groupTitle);
        return resource.create(request);
    }

    public void edit(Long campaignGroupId, String newGroupTitle) {
        EditCampaignGroupRequest request = new EditCampaignGroupRequest();
        request.setCampaignGroupId(campaignGroupId);
        request.setNewGroupTitle(newGroupTitle);
        resource.edit(campaignGroupId, request);
    }

    public CampaignGroupDTO get(Long campaignGroupId) {
        return resource.get(campaignGroupId);
    }

}
