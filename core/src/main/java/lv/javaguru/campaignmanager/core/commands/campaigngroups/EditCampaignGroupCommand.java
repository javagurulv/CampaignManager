package lv.javaguru.campaignmanager.core.commands.campaigngroups;

import lv.javaguru.campaignmanager.core.vo.CampaignGroupId;
import lv.javaguru.campaignmanager.core.vo.GroupTitle;
import lv.javaguru.campaignmanager.core.DomainCommand;
import lv.javaguru.campaignmanager.core.VoidResult;

public class EditCampaignGroupCommand implements DomainCommand<VoidResult> {

    private CampaignGroupId campaignGroupId;
    private GroupTitle newGroupTitle;

    public EditCampaignGroupCommand(CampaignGroupId campaignGroupId,
                                    GroupTitle newGroupTitle) {
        this.campaignGroupId = campaignGroupId;
        this.newGroupTitle = newGroupTitle;
    }

    public CampaignGroupId getCampaignGroupId() {
        return campaignGroupId;
    }

    public GroupTitle getNewGroupTitle() {
        return newGroupTitle;
    }
}
