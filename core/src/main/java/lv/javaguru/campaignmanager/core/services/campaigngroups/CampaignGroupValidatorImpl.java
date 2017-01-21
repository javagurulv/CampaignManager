package lv.javaguru.campaignmanager.core.services.campaigngroups;

import lv.javaguru.campaignmanager.api.vo.GroupTitle;
import lv.javaguru.campaignmanager.core.domain.repositories.CampaignGroupRepository;
import lv.javaguru.campaignmanager.core.domain.CampaignGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
class CampaignGroupValidatorImpl implements CampaignGroupValidator {

    @Autowired private CampaignGroupRepository campaignGroupRepository;

    @Override
    public void validateOnCreate(GroupTitle groupTitle) {
        checkTitleNotEmpty(groupTitle);
        checkCampaignGroupWithSameTitle(groupTitle);
    }

    @Override
    public void validateOnEdit(CampaignGroup campaignGroup,
                               GroupTitle newGroupTitle) {
        checkTitleNotEmpty(newGroupTitle);
        checkCampaignGroupWithSameTitle(campaignGroup, newGroupTitle);
    }

    private void checkTitleNotEmpty(GroupTitle groupTitle) {
        if (groupTitle == null || groupTitle.isEmpty()) {
            throw new IllegalArgumentException(
                    "Campaign Group title must be specified"
            );
        }
    }

    private void checkCampaignGroupWithSameTitle(GroupTitle groupTitle) {
        Optional<CampaignGroup> group = campaignGroupRepository.findByTitle(groupTitle.get());
        if (group.isPresent()) {
            throw new IllegalArgumentException(
                    "Campaign Group with same title already exist"
            );
        }
    }

    private void checkCampaignGroupWithSameTitle(CampaignGroup campaignGroup,
                                                 GroupTitle newGroupTitle) {
        Optional<CampaignGroup> group = campaignGroupRepository.findByTitle(newGroupTitle.get());
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
