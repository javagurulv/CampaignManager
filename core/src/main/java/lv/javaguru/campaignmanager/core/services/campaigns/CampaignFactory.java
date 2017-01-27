package lv.javaguru.campaignmanager.core.services.campaigns;

import lv.javaguru.campaignmanager.core.vo.CampaignGroupId;
import lv.javaguru.campaignmanager.core.vo.CampaignTitle;
import lv.javaguru.campaignmanager.core.domain.Campaign;

public interface CampaignFactory {

    Campaign create(CampaignGroupId campaignGroupId, CampaignTitle title);

}
