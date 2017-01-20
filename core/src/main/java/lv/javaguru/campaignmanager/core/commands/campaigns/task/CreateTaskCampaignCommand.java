package lv.javaguru.campaignmanager.core.commands.campaigns.task;

import lv.javaguru.campaignmanager.api.vo.CampaignTitle;
import lv.javaguru.campaignmanager.core.DomainCommand;

public class CreateTaskCampaignCommand
        implements DomainCommand<CreateTaskCampaignResult> {

    private CampaignTitle title;

    public CreateTaskCampaignCommand(CampaignTitle title) {
        this.title = title;
    }

    public CampaignTitle getTitle() {
        return title;
    }

}
