package lv.javaguru.campaignmanager.core.services.campaigngroups;

import lv.javaguru.campaignmanager.core.database.CampaignGroupDAO;
import lv.javaguru.campaignmanager.core.domain.CampaignGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static org.apache.commons.lang.StringUtils.isEmpty;

@Component
class CampaignGroupValidatorImpl implements CampaignGroupValidator {

    @Autowired private CampaignGroupDAO campaignGroupDAO;

    @Override
    public void validate(String title) {
        validateTitle(title);
    }

    private void validateTitle(String title) {
        checkTitleNotEmpty(title);
        checkCampaignGroupWithSameTitle(title);
    }

    private void checkTitleNotEmpty(String title) {
        if (isEmpty(title)) {
            throw new IllegalArgumentException("Campaign Group title must be specified");
        }
    }

    private void checkCampaignGroupWithSameTitle(String title) {
        Optional<CampaignGroup> campaignGroup = campaignGroupDAO.findByTitle(title);
        if (campaignGroup.isPresent()) {
            throw new IllegalArgumentException("Campaign Group with same title already exist");
        }
    }

}
