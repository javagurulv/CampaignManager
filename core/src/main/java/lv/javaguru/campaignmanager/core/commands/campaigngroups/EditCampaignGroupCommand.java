package lv.javaguru.campaignmanager.core.commands.campaigngroups;

import lv.javaguru.campaignmanager.api.vo.GroupTitle;
import lv.javaguru.campaignmanager.core.DomainCommand;
import lv.javaguru.campaignmanager.core.VoidResult;

public class EditCampaignGroupCommand implements DomainCommand<VoidResult> {

    private Long campaignGroupId;
    private GroupTitle newGroupTitle;

    public EditCampaignGroupCommand(Long campaignGroupId,
                                    GroupTitle newGroupTitle) {
        this.campaignGroupId = campaignGroupId;
        this.newGroupTitle = newGroupTitle;
    }

    public Long getCampaignGroupId() {
        return campaignGroupId;
    }

    public GroupTitle getNewGroupTitle() {
        return newGroupTitle;
    }
}
