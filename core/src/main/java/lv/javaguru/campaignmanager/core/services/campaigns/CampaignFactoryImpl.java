package lv.javaguru.campaignmanager.core.services.campaigns;

import lv.javaguru.campaignmanager.api.vo.CampaignGroupId;
import lv.javaguru.campaignmanager.api.vo.CampaignTitle;
import lv.javaguru.campaignmanager.core.domain.Campaign;
import lv.javaguru.campaignmanager.core.domain.CampaignGroup;
import lv.javaguru.campaignmanager.core.domain.CampaignState;
import lv.javaguru.campaignmanager.core.domain.repositories.CampaignRepository;
import lv.javaguru.campaignmanager.core.domain.repositories.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static lv.javaguru.campaignmanager.core.domain.builders.CampaignBuilder.createCampaign;

@Component
class CampaignFactoryImpl implements CampaignFactory {

    @Autowired private CampaignValidator validator;
    @Autowired private EntityRepository entityRepository;
    @Autowired private CampaignRepository campaignRepository;

    @Override
    public Campaign create(CampaignGroupId campaignGroupId,
                           CampaignTitle title) {
        validator.validateOnCreate(campaignGroupId, title);
        CampaignGroup group = entityRepository.getRequired(CampaignGroup.class, campaignGroupId.get());
        Campaign campaign = buildCampaign(group, title);
        return campaignRepository.save(campaign);
    }

    private Campaign buildCampaign(CampaignGroup group, CampaignTitle title) {
        return createCampaign()
                    .withTitle(title)
                    .with(group)
                    .withState(CampaignState.NOT_ACTIVE)
                .build();
    }

}
