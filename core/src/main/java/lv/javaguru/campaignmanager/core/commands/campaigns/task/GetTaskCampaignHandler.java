package lv.javaguru.campaignmanager.core.commands.campaigns.task;

import lv.javaguru.campaignmanager.api.dto.TaskCampaignDTO;
import lv.javaguru.campaignmanager.core.DomainCommandHandler;
import lv.javaguru.campaignmanager.core.domain.TaskCampaign;
import lv.javaguru.campaignmanager.core.services.campaigns.task.TaskCampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class GetTaskCampaignHandler
        implements DomainCommandHandler<GetTaskCampaignCommand, GetTaskCampaignResult> {

    @Autowired private TaskCampaignService service;
    @Autowired private TaskCampaignConverter converter;

    @Override
    public GetTaskCampaignResult execute(GetTaskCampaignCommand command) {
        TaskCampaign taskCampaign = service.get(command.getTaskCampaignId());
        TaskCampaignDTO taskCampaignDTO = converter.convert(taskCampaign);
        return new GetTaskCampaignResult(taskCampaignDTO);
    }

    @Override
    public Class getCommandType() {
        return GetTaskCampaignCommand.class;
    }

}
