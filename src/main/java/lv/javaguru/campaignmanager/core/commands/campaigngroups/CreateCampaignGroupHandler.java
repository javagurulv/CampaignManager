package lv.javaguru.campaignmanager.core.commands.campaigngroups;

import lv.javaguru.campaignmanager.core.domain.CampaignGroup;
import lv.javaguru.campaignmanager.core.services.DomainCommandHandler;
import lv.javaguru.campaignmanager.core.services.campaigngroups.CampaignGroupFactory;
import lv.javaguru.campaignmanager.integrations.rest.dto.CampaignGroupDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class CreateCampaignGroupHandler
        implements DomainCommandHandler<CreateCampaignGroupCommand, CreateCampaignGroupResult> {

    @Autowired private CampaignGroupFactory factory;
    @Autowired private CampaignGroupConverter converter;

    @Override
    public CreateCampaignGroupResult execute(CreateCampaignGroupCommand command) {
        CampaignGroup campaignGroup = factory.create(command.getTitle());
        CampaignGroupDTO campaignGroupDTO = converter.convert(campaignGroup);
        return new CreateCampaignGroupResult(campaignGroupDTO);
    }

    @Override
    public Class getCommandType() {
        return CreateCampaignGroupCommand.class;
    }

}
