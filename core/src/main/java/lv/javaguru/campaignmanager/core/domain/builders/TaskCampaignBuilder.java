package lv.javaguru.campaignmanager.core.domain.builders;

import lv.javaguru.campaignmanager.core.domain.Campaign;
import lv.javaguru.campaignmanager.core.domain.TaskCampaign;

public class TaskCampaignBuilder {

    private Long id;
    private Campaign campaign;


    private TaskCampaignBuilder() { }

    public static TaskCampaignBuilder createTaskCampaign() {
        return new TaskCampaignBuilder();
    }

    public TaskCampaign build() {
        TaskCampaign taskCampaign = new TaskCampaign();
        taskCampaign.setId(id);
        taskCampaign.setCampaign(campaign);
        return taskCampaign;
    }

    public TaskCampaignBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public TaskCampaignBuilder withCampaign(Campaign campaign) {
        this.campaign = campaign;
        return this;
    }

    public TaskCampaignBuilder withCampaign(CampaignBuilder campaignBuilder) {
        this.campaign = campaignBuilder.build();
        return this;
    }

}
