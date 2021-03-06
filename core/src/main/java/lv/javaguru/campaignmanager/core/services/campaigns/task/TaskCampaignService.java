package lv.javaguru.campaignmanager.core.services.campaigns.task;

import lv.javaguru.campaignmanager.core.vo.TaskCampaignId;
import lv.javaguru.campaignmanager.core.domain.TaskCampaign;

public interface TaskCampaignService {

    TaskCampaign get(TaskCampaignId taskCampaignId);

    void activate(TaskCampaignId taskCampaignId);

    void deactivate(TaskCampaignId taskCampaignId);

    void close(TaskCampaignId taskCampaignId);

}
