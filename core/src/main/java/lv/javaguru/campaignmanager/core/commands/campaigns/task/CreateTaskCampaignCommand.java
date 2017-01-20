package lv.javaguru.campaignmanager.core.commands.campaigns.task;

import lv.javaguru.campaignmanager.api.vo.CampaignGroupId;
import lv.javaguru.campaignmanager.api.vo.CampaignTitle;
import lv.javaguru.campaignmanager.core.DomainCommand;

public class CreateTaskCampaignCommand
        implements DomainCommand<CreateTaskCampaignResult> {

    private CampaignGroupId campaignGroupId;
    private CampaignTitle title;

    public CreateTaskCampaignCommand(CampaignGroupId campaignGroupId,
                                     CampaignTitle title) {
        this.campaignGroupId = campaignGroupId;
        this.title = title;
    }

    public CampaignGroupId getCampaignGroupId() {
        return campaignGroupId;
    }

    public CampaignTitle getTitle() {
        return title;
    }

}
