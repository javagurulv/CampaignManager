package lv.javaguru.campaignmanager.core.services.campaigngroups;

import lv.javaguru.campaignmanager.core.database.CampaignGroupDAO;
import lv.javaguru.campaignmanager.core.domain.CampaignGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class CampaignGroupServiceImpl implements CampaignGroupService {

    @Autowired private CampaignGroupValidator validator;
    @Autowired private CampaignGroupDAO dao;

    @Override
    public CampaignGroup get(Long campaignGroupId) {
        return dao.getRequired(campaignGroupId);
    }

    @Override
    public void edit(Long campaignGroupId, String newTitle) {
        CampaignGroup campaignGroup = get(campaignGroupId);
        validator.validateOnEdit(campaignGroup, newTitle);
        campaignGroup.setTitle(newTitle);
    }

}
