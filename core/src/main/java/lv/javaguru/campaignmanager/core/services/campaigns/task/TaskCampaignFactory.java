package lv.javaguru.campaignmanager.core.services.campaigns.task;

import lv.javaguru.campaignmanager.api.vo.CampaignGroupId;
import lv.javaguru.campaignmanager.api.vo.CampaignTitle;
import lv.javaguru.campaignmanager.core.domain.TaskCampaign;

public interface TaskCampaignFactory {

    TaskCampaign create(CampaignGroupId campaignGroupId,
                        CampaignTitle title);

}
