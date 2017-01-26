package lv.javaguru.campaignmanager.core.commands.campaigns.task;

import lv.javaguru.campaignmanager.core.DomainCommandHandler;
import lv.javaguru.campaignmanager.core.VoidResult;
import lv.javaguru.campaignmanager.core.services.campaigns.task.TaskCampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class CloseTaskCampaignHandler
        implements DomainCommandHandler<CloseTaskCampaignCommand, VoidResult> {

    @Autowired private TaskCampaignService taskCampaignService;

    @Override
    public VoidResult execute(CloseTaskCampaignCommand command) {
        taskCampaignService.close(command.getTaskCampaignId());
        return VoidResult.INSTANCE;
    }

    @Override
    public Class getCommandType() {
        return CloseTaskCampaignCommand.class;
    }

}
