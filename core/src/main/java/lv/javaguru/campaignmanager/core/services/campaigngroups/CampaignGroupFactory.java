package lv.javaguru.campaignmanager.core.services.campaigngroups;

import lv.javaguru.campaignmanager.api.vo.GroupTitle;
import lv.javaguru.campaignmanager.core.domain.CampaignGroup;

public interface CampaignGroupFactory {

    CampaignGroup create(GroupTitle groupTitle);

}
