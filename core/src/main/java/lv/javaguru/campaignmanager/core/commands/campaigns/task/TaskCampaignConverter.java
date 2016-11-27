package lv.javaguru.campaignmanager.core.commands.campaigns.task;

import lv.javaguru.campaignmanager.api.dto.TaskCampaignDTO;
import lv.javaguru.campaignmanager.core.commands.campaigns.CampaignConverter;
import lv.javaguru.campaignmanager.core.domain.TaskCampaign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static lv.javaguru.campaignmanager.api.dto.builders.TaskCampaignDTOBuilder.createTaskCampaignDTO;

@Component
class TaskCampaignConverter {

    @Autowired private CampaignConverter campaignConverter;

    TaskCampaignDTO convert(TaskCampaign taskCampaign) {
        return createTaskCampaignDTO()
                .withId(taskCampaign.getId())
                .withCampaign(
                        campaignConverter.convert(taskCampaign.getCampaign())
                )
                .withCreatedDate(taskCampaign.getCreatedDate())
                .withUpdatedDate(taskCampaign.getUpdatedDate())
                .build();
    }

}
