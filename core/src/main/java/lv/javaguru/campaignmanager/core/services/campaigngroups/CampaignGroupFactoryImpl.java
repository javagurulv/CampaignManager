package lv.javaguru.campaignmanager.core.services.campaigngroups;

import lv.javaguru.campaignmanager.api.vo.GroupTitle;
import lv.javaguru.campaignmanager.core.domain.repositories.CampaignGroupRepository;
import lv.javaguru.campaignmanager.core.domain.CampaignGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static lv.javaguru.campaignmanager.core.domain.builders.
        CampaignGroupBuilder.createCampaignGroup;

@Component
class CampaignGroupFactoryImpl implements CampaignGroupFactory {

    @Autowired private CampaignGroupValidator validator;
    @Autowired private CampaignGroupRepository repository;

    @Override
    public CampaignGroup create(GroupTitle groupTitle) {
        validator.validateOnCreate(groupTitle);
        CampaignGroup campaignGroup = buildCampaignGroup(groupTitle);
        return repository.save(campaignGroup);
    }

    private CampaignGroup buildCampaignGroup(GroupTitle groupTitle) {
        return createCampaignGroup().with(groupTitle).build();
    }

}
