package lv.javaguru.campaignmanager.core.services.campaigngroups;

import lv.javaguru.campaignmanager.core.vo.CampaignGroupId;
import lv.javaguru.campaignmanager.core.vo.GroupTitle;
import lv.javaguru.campaignmanager.core.domain.CampaignGroup;

public interface CampaignGroupService {

    CampaignGroup get(CampaignGroupId campaignGroupId);

    void edit(CampaignGroupId campaignGroupId, GroupTitle newGroupTitle);

}
