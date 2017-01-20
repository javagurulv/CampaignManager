package lv.javaguru.campaignmanager.core.services.campaigns;

import lv.javaguru.campaignmanager.api.vo.CampaignTitle;
import lv.javaguru.campaignmanager.core.domain.Campaign;

public interface CampaignFactory {

    Campaign create(CampaignTitle title);

}
