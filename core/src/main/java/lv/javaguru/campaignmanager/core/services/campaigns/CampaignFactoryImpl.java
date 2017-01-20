package lv.javaguru.campaignmanager.core.services.campaigns;

import lv.javaguru.campaignmanager.api.vo.CampaignGroupId;
import lv.javaguru.campaignmanager.api.vo.CampaignTitle;
import lv.javaguru.campaignmanager.core.database.CampaignDAO;
import lv.javaguru.campaignmanager.core.database.CampaignGroupDAO;
import lv.javaguru.campaignmanager.core.domain.Campaign;
import lv.javaguru.campaignmanager.core.domain.CampaignGroup;
import lv.javaguru.campaignmanager.core.domain.CampaignState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static lv.javaguru.campaignmanager.core.domain.builders.CampaignBuilder.createCampaign;

@Component
class CampaignFactoryImpl implements CampaignFactory {

    @Autowired private CampaignValidator validator;
    @Autowired private CampaignGroupDAO campaignGroupDAO;
    @Autowired private CampaignDAO campaignDAO;

    @Override
    public Campaign create(CampaignGroupId campaignGroupId,
                           CampaignTitle title) {
        validator.validateOnCreate(campaignGroupId, title);
        CampaignGroup group = campaignGroupDAO.getRequired(campaignGroupId.get());
        Campaign campaign = buildCampaign(group, title);
        campaignDAO.create(campaign);
        return campaign;
    }

    private Campaign buildCampaign(CampaignGroup group, CampaignTitle title) {
        return createCampaign()
                    .withTitle(title)
                    .with(group)
                    .withState(CampaignState.NOT_ACTIVE)
                .build();
    }

}
