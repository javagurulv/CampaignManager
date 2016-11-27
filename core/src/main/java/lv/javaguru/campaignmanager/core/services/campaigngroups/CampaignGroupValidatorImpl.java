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
            throw new IllegalArgumentException(
                    "Campaign Group title must be specified"
            );
        }
    }

    private void checkCampaignGroupWithSameTitle(String title) {
        Optional<CampaignGroup> group = campaignGroupDAO.findByTitle(title);
        if (group.isPresent()) {
            throw new IllegalArgumentException(
                    "Campaign Group with same title already exist"
            );
        }
    }

    private void checkCampaignGroupWithSameTitle(CampaignGroup campaignGroup,
                                                 String newTitle) {
        Optional<CampaignGroup> group = campaignGroupDAO.findByTitle(newTitle);
        if (group.isPresent()) {
            CampaignGroup groupWithSameTitle = group.get();
            boolean isSameGroup = isSame(campaignGroup, groupWithSameTitle);
            if (!isSameGroup) {
                throw new IllegalArgumentException(
                        "Campaign Group with same title already exist"
                );
            }
        }
    }

    private boolean isSame(CampaignGroup group1, CampaignGroup group2) {
        return Objects.equals(group1.getId(), group2.getId());
    }

}
