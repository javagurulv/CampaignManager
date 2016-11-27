package lv.javaguru.campaignmanager.core.services.campaigns;

import lv.javaguru.campaignmanager.core.database.CampaignDAO;
import lv.javaguru.campaignmanager.core.domain.Campaign;
import lv.javaguru.campaignmanager.core.domain.CampaignState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static lv.javaguru.campaignmanager.core.domain.builders.
        CampaignBuilder.createCampaign;

@Component
class CampaignFactoryImpl implements CampaignFactory {

    @Autowired private CampaignValidator validator;
    @Autowired private CampaignDAO dao;

    @Override
    public Campaign create(String title) {
        validator.validateOnCreate(title);
        Campaign campaign = buildCampaign(title);
        dao.create(campaign);
        return campaign;
    }

    private Campaign buildCampaign(String title) {
        return createCampaign()
                    .withTitle(title)
                    .withState(CampaignState.NOT_ACTIVE)
                .build();
    }

}
