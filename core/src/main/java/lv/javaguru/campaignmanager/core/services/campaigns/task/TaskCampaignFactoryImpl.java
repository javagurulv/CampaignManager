package lv.javaguru.campaignmanager.core.services.campaigns.task;

import lv.javaguru.campaignmanager.core.database.TaskCampaignDAO;
import lv.javaguru.campaignmanager.core.domain.Campaign;
import lv.javaguru.campaignmanager.core.domain.TaskCampaign;
import lv.javaguru.campaignmanager.core.services.campaigns.CampaignFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static lv.javaguru.campaignmanager.core.domain.builders.
        TaskCampaignBuilder.createTaskCampaign;

@Component
class TaskCampaignFactoryImpl implements TaskCampaignFactory {

    @Autowired private CampaignFactory campaignFactory;
    @Autowired private TaskCampaignDAO dao;

    @Override
    public TaskCampaign create(String title) {
        Campaign campaign = campaignFactory.create(title);
        TaskCampaign taskCampaign = buildTaskCampaign(campaign);
        dao.create(taskCampaign);
        return taskCampaign;
    }

    private TaskCampaign buildTaskCampaign(Campaign campaign) {
        return createTaskCampaign()
                    .withCampaign(campaign).build();
    }

}
