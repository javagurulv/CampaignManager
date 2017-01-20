package lv.javaguru.campaignmanager.core.commands.campaigns.task;

import lv.javaguru.campaignmanager.api.vo.TaskCampaignId;
import lv.javaguru.campaignmanager.core.DomainCommand;

public class GetTaskCampaignCommand
        implements DomainCommand<GetTaskCampaignResult> {

    private TaskCampaignId taskCampaignId;

    public GetTaskCampaignCommand(TaskCampaignId taskCampaignId) {
        this.taskCampaignId = taskCampaignId;
    }

    public TaskCampaignId getTaskCampaignId() {
        return taskCampaignId;
    }

}
