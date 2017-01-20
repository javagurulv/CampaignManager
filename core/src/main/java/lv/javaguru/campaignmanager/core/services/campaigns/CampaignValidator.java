package lv.javaguru.campaignmanager.core.services.campaigns;

import lv.javaguru.campaignmanager.api.vo.CampaignTitle;

interface CampaignValidator {

    void validateOnCreate(CampaignTitle title);

}
