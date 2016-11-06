package lv.javaguru.campaignmanager.core.services.campaigngroups;

import lv.javaguru.campaignmanager.core.domain.CampaignGroup;

public interface CampaignGroupService {

    CampaignGroup get(Long campaignGroupId);

    void edit(Long campaignGroupId, String newTitle);

}
