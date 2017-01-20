package lv.javaguru.campaignmanager.core.services.campaigns.task;

import lv.javaguru.campaignmanager.api.vo.TaskCampaignId;
import lv.javaguru.campaignmanager.core.database.TaskCampaignDAO;
import lv.javaguru.campaignmanager.core.domain.TaskCampaign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskCampaignServiceImpl implements TaskCampaignService {

    @Autowired private TaskCampaignDAO dao;

    @Override
    public TaskCampaign get(TaskCampaignId taskCampaignId) {
        return dao.getRequired(taskCampaignId.get());
    }

}
