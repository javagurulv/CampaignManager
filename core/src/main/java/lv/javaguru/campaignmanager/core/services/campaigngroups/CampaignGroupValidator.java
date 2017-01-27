package lv.javaguru.campaignmanager.core.services.campaigngroups;

import lv.javaguru.campaignmanager.core.vo.GroupTitle;
import lv.javaguru.campaignmanager.core.domain.CampaignGroup;

interface CampaignGroupValidator {

    void validateOnCreate(GroupTitle groupTitle);

    void validateOnEdit(CampaignGroup campaignGroup,
                        GroupTitle newGroupTitle);

}
