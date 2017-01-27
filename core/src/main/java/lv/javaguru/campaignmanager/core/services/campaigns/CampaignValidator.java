package lv.javaguru.campaignmanager.core.services.campaigns;

import lv.javaguru.campaignmanager.core.vo.CampaignGroupId;
import lv.javaguru.campaignmanager.core.vo.CampaignTitle;

interface CampaignValidator {

    void validateOnCreate(CampaignGroupId campaignGroupId,
                          CampaignTitle title);

}
