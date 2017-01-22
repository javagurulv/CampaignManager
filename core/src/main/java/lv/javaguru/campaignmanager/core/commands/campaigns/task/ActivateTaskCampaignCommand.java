package lv.javaguru.campaignmanager.core.commands.campaigns.task;

import lv.javaguru.campaignmanager.api.vo.TaskCampaignId;
import lv.javaguru.campaignmanager.core.DomainCommand;
import lv.javaguru.campaignmanager.core.VoidResult;

public class ActivateTaskCampaignCommand implements DomainCommand<VoidResult> {

    private TaskCampaignId taskCampaignId;

    public ActivateTaskCampaignCommand(TaskCampaignId taskCampaignId) {
        this.taskCampaignId = taskCampaignId;
    }

    public TaskCampaignId getTaskCampaignId() {
        return taskCampaignId;
    }
}
