package lv.javaguru.campaignmanager.core.services.campaigngroups;

import lv.javaguru.campaignmanager.core.domain.CampaignGroup;

interface CampaignGroupValidator {

    void validateOnCreate(String title);

    void validateOnEdit(CampaignGroup campaignGroup,
                        String newTitle);

}
