package lv.javaguru.campaignmanager.core.services.campaigngroups;

import lv.javaguru.campaignmanager.core.database.CampaignGroupDAO;
import lv.javaguru.campaignmanager.core.domain.CampaignGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

import static org.springframework.util.StringUtils.isEmpty;

@Component
class CampaignGroupValidatorImpl implements CampaignGroupValidator {

    @Autowired private CampaignGroupDAO campaignGroupDAO;

    @Override
    public void validateOnCreate(String title) {
        checkTitleNotEmpty(title);
        checkCampaignGroupWithSameTitle(title);
    }

    @Override
    public void validateOnEdit(CampaignGroup campaignGroup,
                               String newTitle) {
        checkTitleNotEmpty(newTitle);
        checkCampaignGroupWithSameTitle(campaignGroup, newTitle);
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

    private void checkCampaignGroupWithSameTitle(CampaignGroup campaignGroup,
                                                 String newTitle) {
        Optional<CampaignGroup> campaignGroupOpt = campaignGroupDAO.findByTitle(newTitle);
        if (campaignGroupOpt.isPresent()) {
            CampaignGroup groupWithSameTitle = campaignGroupOpt.get();
            if (!Objects.equals(campaignGroup.getId(), groupWithSameTitle.getId())) {
                throw new IllegalArgumentException("Campaign Group with same title already exist");
            }
        }
    }

}
