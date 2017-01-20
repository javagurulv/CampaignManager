package lv.javaguru.campaignmanager.core.services.campaigns;

import lv.javaguru.campaignmanager.api.vo.CampaignGroupId;
import lv.javaguru.campaignmanager.api.vo.CampaignTitle;

interface CampaignValidator {

    void validateOnCreate(CampaignGroupId campaignGroupId,
                          CampaignTitle title);

}
