package lv.javaguru.campaignmanager.core.commands.campaigngroups;

import lv.javaguru.campaignmanager.core.commands.DomainCommand;

public class CreateCampaignGroupCommand
        implements DomainCommand<CreateCampaignGroupResult> {

    private String title;

    public CreateCampaignGroupCommand(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
