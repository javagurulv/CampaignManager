package lv.javaguru.campaignmanager.integrations.rest;

import lv.javaguru.campaignmanager.api.TaskCampaignResource;
import lv.javaguru.campaignmanager.api.dto.CreateTaskCampaignRequest;
import lv.javaguru.campaignmanager.api.dto.TaskCampaignDTO;

public class TaskCampaignActions {

    private TaskCampaignResource resource;

    public TaskCampaignActions(TaskCampaignResource resource) {
        this.resource = resource;
    }

    public TaskCampaignDTO create(Long groupId, String campaignTitle) {
        CreateTaskCampaignRequest request = new CreateTaskCampaignRequest();
        request.setCampaignGroupId(groupId);
        request.setCampaignTitle(campaignTitle);
        return resource.create(request);
    }

    public TaskCampaignDTO get(Long taskCampaignId) {
        return resource.get(taskCampaignId);
    }

}
