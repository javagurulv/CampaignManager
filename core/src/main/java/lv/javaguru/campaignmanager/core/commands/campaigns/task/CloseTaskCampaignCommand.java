package lv.javaguru.campaignmanager.core.commands.campaigns.task;

import lv.javaguru.campaignmanager.api.vo.TaskCampaignId;
import lv.javaguru.campaignmanager.core.DomainCommand;
import lv.javaguru.campaignmanager.core.VoidResult;

public class CloseTaskCampaignCommand implements DomainCommand<VoidResult> {

    private TaskCampaignId taskCampaignId;

    public CloseTaskCampaignCommand(TaskCampaignId taskCampaignId) {
        this.taskCampaignId = taskCampaignId;
    }

    public TaskCampaignId getTaskCampaignId() {
        return taskCampaignId;
    }
}
