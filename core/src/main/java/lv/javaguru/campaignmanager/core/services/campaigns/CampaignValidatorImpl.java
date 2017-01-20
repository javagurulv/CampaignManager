package lv.javaguru.campaignmanager.core.services.campaigns;

import lv.javaguru.campaignmanager.api.vo.CampaignTitle;
import lv.javaguru.campaignmanager.core.database.CampaignDAO;
import lv.javaguru.campaignmanager.core.domain.Campaign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
class CampaignValidatorImpl implements CampaignValidator {

    @Autowired private CampaignDAO campaignDAO;

    @Override
    public void validateOnCreate(CampaignTitle title) {
        checkTitleNotEmpty(title);
        checkCampaignWithSameTitle(title);
    }

    private void checkTitleNotEmpty(CampaignTitle title) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException(
                    "Campaign title must be specified"
            );
        }
    }

    private void checkCampaignWithSameTitle(CampaignTitle title) {
        Optional<Campaign> campaign = campaignDAO.findByTitle(title.get());
        if (campaign.isPresent()) {
            throw new IllegalArgumentException(
                    "Campaign with same title already exist"
            );
        }
    }

}
