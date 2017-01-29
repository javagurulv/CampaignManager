package lv.javaguru.campaignmanager.api.dto.builders;

import lv.javaguru.campaignmanager.api.dto.campaigns.CampaignDTO;
import lv.javaguru.campaignmanager.api.dto.campaigns.task.TaskCampaignDTO;

import java.util.Date;

public class TaskCampaignDTOBuilder {

    private Long id;
    private CampaignDTO campaign;
    private Date createdDate;
    private Date updatedDate;


    private TaskCampaignDTOBuilder() { }

    public static TaskCampaignDTOBuilder createTaskCampaignDTO() {
        return new TaskCampaignDTOBuilder();
    }

    public TaskCampaignDTO build() {
        TaskCampaignDTO dto = new TaskCampaignDTO();
        dto.setId(id);
        dto.setCampaign(campaign);
        dto.setCreatedDate(createdDate);
        dto.setUpdatedDate(updatedDate);
        return dto;
    }

    public TaskCampaignDTOBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public TaskCampaignDTOBuilder withCampaign(CampaignDTO campaign) {
        this.campaign = campaign;
        return this;
    }

    public TaskCampaignDTOBuilder withCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public TaskCampaignDTOBuilder withUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
        return this;
    }

}
