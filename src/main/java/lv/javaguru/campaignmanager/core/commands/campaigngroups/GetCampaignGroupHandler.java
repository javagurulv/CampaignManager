package lv.javaguru.campaignmanager.core.commands.campaigngroups;

import lv.javaguru.campaignmanager.core.domain.CampaignGroup;
import lv.javaguru.campaignmanager.core.services.DomainCommandHandler;
import lv.javaguru.campaignmanager.core.services.campaigngroups.CampaignGroupService;
import lv.javaguru.campaignmanager.integrations.rest.dto.CampaignGroupDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetCampaignGroupHandler
        implements DomainCommandHandler<GetCampaignGroupCommand, GetCampaignGroupResult> {

    @Autowired private CampaignGroupService service;
    @Autowired private CampaignGroupConverter converter;

    @Override
    public GetCampaignGroupResult execute(GetCampaignGroupCommand command) {
        CampaignGroup campaignGroup = service.get(command.getCampaigGroupId());
        CampaignGroupDTO campaignGroupDTO = converter.convert(campaignGroup);
        return new GetCampaignGroupResult(campaignGroupDTO);
    }

    @Override
    public Class getCommandType() {
        return GetCampaignGroupCommand.class;
    }

}