package lv.javaguru.campaignmanager.core.services.campaigngroups;

import lv.javaguru.campaignmanager.core.database.CampaignGroupDAO;
import lv.javaguru.campaignmanager.core.domain.CampaignGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static lv.javaguru.campaignmanager.core.domain.builders.CampaignGroupBuilder.createCampaignGroup;

@Component
class CampaignGroupFactoryImpl implements CampaignGroupFactory {

    @Autowired private CampaignGroupValidator validator;
    @Autowired private CampaignGroupDAO dao;

    @Override
    public CampaignGroup create(String title) {
        validator.validate(title);
        CampaignGroup campaignGroup = createCampaignGroup()
                .withTitle(title).build();
        dao.create(campaignGroup);
        return campaignGroup;
    }

}