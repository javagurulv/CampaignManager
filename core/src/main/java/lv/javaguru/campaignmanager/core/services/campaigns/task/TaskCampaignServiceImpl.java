package lv.javaguru.campaignmanager.core.services.campaigns.task;

import lv.javaguru.campaignmanager.api.vo.TaskCampaignId;
import lv.javaguru.campaignmanager.core.domain.TaskCampaign;
import lv.javaguru.campaignmanager.core.domain.repositories.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskCampaignServiceImpl implements TaskCampaignService {

    @Autowired private EntityRepository entityRepository;

    @Override
    public TaskCampaign get(TaskCampaignId taskCampaignId) {
        return entityRepository.getRequired(TaskCampaign.class, taskCampaignId.get());
    }

}
