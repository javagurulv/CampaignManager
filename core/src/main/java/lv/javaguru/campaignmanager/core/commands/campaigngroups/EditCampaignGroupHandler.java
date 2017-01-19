package lv.javaguru.campaignmanager.core.commands.campaigngroups;

import lv.javaguru.campaignmanager.core.VoidResult;
import lv.javaguru.campaignmanager.core.DomainCommandHandler;
import lv.javaguru.campaignmanager.core.services.campaigngroups.CampaignGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class EditCampaignGroupHandler
        implements DomainCommandHandler<EditCampaignGroupCommand, VoidResult> {

    @Autowired private CampaignGroupService service;

    @Override
    public VoidResult execute(EditCampaignGroupCommand command) {
        service.edit(command.getCampaignGroupId(), command.getNewGroupTitle());
        return VoidResult.INSTANCE;
    }

    @Override
    public Class getCommandType() {
        return EditCampaignGroupCommand.class;
    }

}
