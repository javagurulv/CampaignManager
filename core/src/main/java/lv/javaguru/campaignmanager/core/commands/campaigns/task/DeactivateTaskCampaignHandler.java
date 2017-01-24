package lv.javaguru.campaignmanager.core.commands.campaigns.task;

import lv.javaguru.campaignmanager.core.DomainCommandHandler;
import lv.javaguru.campaignmanager.core.VoidResult;
import lv.javaguru.campaignmanager.core.services.campaigns.task.TaskCampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class DeactivateTaskCampaignHandler
        implements DomainCommandHandler<DeactivateTaskCampaignCommand, VoidResult> {

    @Autowired
    private TaskCampaignService taskCampaignService;

    @Override
    public VoidResult execute(DeactivateTaskCampaignCommand command) {
        taskCampaignService.deactivate(command.getTaskCampaignId());
        return VoidResult.INSTANCE;
    }

    @Override
    public Class getCommandType() {
        return DeactivateTaskCampaignCommand.class;
    }

}
