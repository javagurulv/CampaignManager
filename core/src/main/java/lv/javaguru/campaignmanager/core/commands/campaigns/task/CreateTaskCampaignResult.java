package lv.javaguru.campaignmanager.core.commands.campaigns.task;

import lv.javaguru.campaignmanager.api.dto.campaigns.task.TaskCampaignDTO;
import lv.javaguru.campaignmanager.core.DomainCommandResult;

public class CreateTaskCampaignResult implements DomainCommandResult {

    private TaskCampaignDTO taskCampaign;

    public CreateTaskCampaignResult(TaskCampaignDTO taskCampaign) {
        this.taskCampaign = taskCampaign;
    }

    public TaskCampaignDTO getTaskCampaign() {
        return taskCampaign;
    }

}
