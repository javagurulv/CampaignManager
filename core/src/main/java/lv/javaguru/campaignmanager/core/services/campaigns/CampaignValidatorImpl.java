package lv.javaguru.campaignmanager.core.services.campaigns;

import lv.javaguru.campaignmanager.api.vo.CampaignGroupId;
import lv.javaguru.campaignmanager.api.vo.CampaignTitle;
import lv.javaguru.campaignmanager.core.domain.repositories.CampaignRepository;
import lv.javaguru.campaignmanager.core.domain.Campaign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
class CampaignValidatorImpl implements CampaignValidator {

    @Autowired private CampaignRepository campaignRepository;

    @Override
    public void validateOnCreate(CampaignGroupId campaignGroupId,
                                 CampaignTitle title) {
        checkCampaignGroupIdNotEmpty(campaignGroupId);
        checkTitleNotEmpty(title);
        checkCampaignWithSameTitle(title);
    }

    private void checkCampaignGroupIdNotEmpty(CampaignGroupId groupId) {
        if (groupId == null || groupId.isNull()) {
            throw new IllegalArgumentException(
                    "Campaign Group must be specified"
            );
        }
    }

    private void checkTitleNotEmpty(CampaignTitle title) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException(
                    "Campaign title must be specified"
            );
        }
    }

    private void checkCampaignWithSameTitle(CampaignTitle title) {
        Optional<Campaign> campaign = campaignRepository.findByTitle(title.get());
        if (campaign.isPresent()) {
            throw new IllegalArgumentException(
                    "Campaign with same title already exist"
            );
        }
    }

}
