package lv.javaguru.campaignmanager.core.commands.campaigns.task;

import lv.javaguru.campaignmanager.api.dto.TaskCampaignDTO;
import lv.javaguru.campaignmanager.core.DomainCommandResult;

public class GetTaskCampaignResult implements DomainCommandResult {

    private TaskCampaignDTO taskCampaign;

    public GetTaskCampaignResult(TaskCampaignDTO taskCampaign) {
        this.taskCampaign = taskCampaign;
    }

    public TaskCampaignDTO getTaskCampaign() {
        return taskCampaign;
    }
}
