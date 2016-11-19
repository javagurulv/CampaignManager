package lv.javaguru.campaignmanager.core.commands.campaigns.task;

import lv.javaguru.campaignmanager.api.dto.TaskCampaignDTO;
import lv.javaguru.campaignmanager.core.DomainCommandHandler;
import lv.javaguru.campaignmanager.core.domain.TaskCampaign;
import lv.javaguru.campaignmanager.core.services.campaigns.task.TaskCampaignFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class CreateTaskCampaignHandler
        implements DomainCommandHandler<CreateTaskCampaignCommand, CreateTaskCampaignResult> {

    @Autowired private TaskCampaignFactory factory;
    @Autowired private TaskCampaignConverter converter;

    @Override
    public CreateTaskCampaignResult execute(CreateTaskCampaignCommand command) {
        TaskCampaign taskCampaign = factory.create(command.getTitle());
        TaskCampaignDTO taskCampaignDTO = converter.convert(taskCampaign);
        return new CreateTaskCampaignResult(taskCampaignDTO);
    }

    @Override
    public Class getCommandType() {
        return CreateTaskCampaignCommand.class;
    }

}
