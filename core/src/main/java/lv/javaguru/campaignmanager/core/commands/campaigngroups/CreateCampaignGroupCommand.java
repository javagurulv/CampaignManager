package lv.javaguru.campaignmanager.core.commands.campaigngroups;

import lv.javaguru.campaignmanager.core.vo.GroupTitle;
import lv.javaguru.campaignmanager.core.DomainCommand;

public class CreateCampaignGroupCommand
        implements DomainCommand<CreateCampaignGroupResult> {

    private GroupTitle groupTitle;

    public CreateCampaignGroupCommand(GroupTitle groupTitle) {
        this.groupTitle = groupTitle;
    }

    public GroupTitle getGroupTitle() {
        return groupTitle;
    }

}
