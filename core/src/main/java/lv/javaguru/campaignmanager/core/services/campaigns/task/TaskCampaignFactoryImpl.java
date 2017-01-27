package lv.javaguru.campaignmanager.core.services.campaigns.task;

import lv.javaguru.campaignmanager.core.vo.CampaignGroupId;
import lv.javaguru.campaignmanager.core.vo.CampaignTitle;
import lv.javaguru.campaignmanager.core.domain.repositories.TaskCampaignRepository;
import lv.javaguru.campaignmanager.core.domain.Campaign;
import lv.javaguru.campaignmanager.core.domain.TaskCampaign;
import lv.javaguru.campaignmanager.core.services.campaigns.CampaignFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static lv.javaguru.campaignmanager.core.domain.builders.TaskCampaignBuilder.createTaskCampaign;

@Component
class TaskCampaignFactoryImpl implements TaskCampaignFactory {

    @Autowired private CampaignFactory campaignFactory;
    @Autowired private TaskCampaignRepository repository;

    @Override
    public TaskCampaign create(CampaignGroupId campaignGroupId, CampaignTitle title) {
        Campaign campaign = campaignFactory.create(campaignGroupId, title);
        TaskCampaign taskCampaign = buildTaskCampaign(campaign);
        return repository.save(taskCampaign);
    }

    private TaskCampaign buildTaskCampaign(Campaign campaign) {
        return createTaskCampaign()
                    .withId(campaign.getId())
                    .withCampaign(campaign).build();
    }

}
