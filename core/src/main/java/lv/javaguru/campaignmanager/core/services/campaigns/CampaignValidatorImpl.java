package lv.javaguru.campaignmanager.core.services.campaigns;

import lv.javaguru.campaignmanager.core.database.CampaignDAO;
import lv.javaguru.campaignmanager.core.domain.Campaign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static org.springframework.util.StringUtils.isEmpty;

@Component
class CampaignValidatorImpl implements CampaignValidator {

    @Autowired private CampaignDAO campaignDAO;

    @Override
    public void validateOnCreate(String title) {
        checkTitleNotEmpty(title);
        checkCampaignWithSameTitle(title);
    }

    private void checkTitleNotEmpty(String title) {
        if (isEmpty(title)) {
            throw new IllegalArgumentException(
                    "Campaign title must be specified"
            );
        }
    }

    private void checkCampaignWithSameTitle(String title) {
        Optional<Campaign> campaign = campaignDAO.findByTitle(title);
        if (campaign.isPresent()) {
            throw new IllegalArgumentException(
                    "Campaign with same title already exist"
            );
        }
    }

}
