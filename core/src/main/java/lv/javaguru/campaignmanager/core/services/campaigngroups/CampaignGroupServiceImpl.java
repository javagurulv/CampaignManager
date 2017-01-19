package lv.javaguru.campaignmanager.core.services.campaigngroups;

import lv.javaguru.campaignmanager.api.vo.CampaignGroupId;
import lv.javaguru.campaignmanager.api.vo.GroupTitle;
import lv.javaguru.campaignmanager.core.database.CampaignGroupDAO;
import lv.javaguru.campaignmanager.core.domain.CampaignGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
class CampaignGroupServiceImpl implements CampaignGroupService {

    @Autowired private CampaignGroupValidator validator;
    @Autowired private CampaignGroupDAO dao;

    @Override
    public CampaignGroup get(CampaignGroupId campaignGroupId) {
        return dao.getRequired(campaignGroupId.get());
    }

    @Override
    public void edit(CampaignGroupId campaignGroupId, GroupTitle newGroupTitle) {
        CampaignGroup campaignGroup = get(campaignGroupId);
        validator.validateOnEdit(campaignGroup, newGroupTitle);
        campaignGroup.setTitle(newGroupTitle.get());
        campaignGroup.setUpdatedDate(new Date());
    }

}
