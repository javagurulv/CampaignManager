package lv.javaguru.campaignmanager.core.services.campaigngroups;

import lv.javaguru.campaignmanager.core.domain.CampaignGroup;
import org.springframework.stereotype.Component;

@Component
public interface CampaignGroupService {

    CampaignGroup get(Long campaignGroupId);

}
