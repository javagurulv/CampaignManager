package lv.javaguru.campaignmanager.core.services.campaigns.task;

import lv.javaguru.campaignmanager.api.vo.TaskCampaignId;
import lv.javaguru.campaignmanager.core.domain.CampaignState;
import lv.javaguru.campaignmanager.core.domain.TaskCampaign;
import lv.javaguru.campaignmanager.core.domain.repositories.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.google.common.base.Preconditions.checkState;

@Component
public class TaskCampaignServiceImpl implements TaskCampaignService {

    @Autowired private EntityRepository entityRepository;

    @Override
    public TaskCampaign get(TaskCampaignId taskCampaignId) {
        return entityRepository.getRequired(TaskCampaign.class, taskCampaignId.get());
    }

    @Override
    public void activate(TaskCampaignId taskCampaignId) {
        TaskCampaign taskCampaign = get(taskCampaignId);

        checkState(taskCampaign.getCampaign() != null, "Campaign must be defined");
        checkState(taskCampaign.getCampaign().hasGroup(), "Campaign Group must be defined");
        checkState(taskCampaign.getCampaign().getState().isTransitionAllowed(CampaignState.ACTIVE), "State Transition to ACTIVE not allowed");

        taskCampaign.getCampaign().activate();
    }

}
