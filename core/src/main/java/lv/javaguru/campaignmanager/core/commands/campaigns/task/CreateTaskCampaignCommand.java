package lv.javaguru.campaignmanager.core.commands.campaigns.task;

import lv.javaguru.campaignmanager.core.DomainCommand;

public class CreateTaskCampaignCommand
        implements DomainCommand<CreateTaskCampaignResult> {

    private String title;

    public CreateTaskCampaignCommand(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
