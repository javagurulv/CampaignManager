package lv.javaguru.campaignmanager.core.services.campaigns.task;

import lv.javaguru.campaignmanager.core.domain.TaskCampaign;

public interface TaskCampaignFactory {

    TaskCampaign create(String title);

}
