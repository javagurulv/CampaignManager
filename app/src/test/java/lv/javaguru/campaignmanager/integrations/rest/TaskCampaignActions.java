package lv.javaguru.campaignmanager.integrations.rest;

import lv.javaguru.campaignmanager.api.TaskCampaignResource;
import lv.javaguru.campaignmanager.api.dto.CampaignGroupDTO;
import lv.javaguru.campaignmanager.api.dto.CreateTaskCampaignRequest;
import lv.javaguru.campaignmanager.api.dto.TaskCampaignDTO;

public class TaskCampaignActions {

    private TaskCampaignResource resource;

    public TaskCampaignActions(TaskCampaignResource resource) {
        this.resource = resource;
    }

    public TaskCampaignDTO create(CampaignGroupDTO group, String campaignTitle) {
        CreateTaskCampaignRequest request = new CreateTaskCampaignRequest();
        request.setCampaignGroupId(group.getId());
        request.setCampaignTitle(campaignTitle);
        return resource.create(request);
    }

    public TaskCampaignDTO get(Long taskCampaignId) {
        return resource.get(taskCampaignId);
    }

    public void activate(TaskCampaignDTO taskCampaign) {
        resource.activate(taskCampaign.getId());
    }

    public void deactivate(TaskCampaignDTO taskCampaign) {
        resource.deactivate(taskCampaign.getId());
    }

    public void close(TaskCampaignDTO taskCampaign) {
        resource.close(taskCampaign.getId());
    }

}
