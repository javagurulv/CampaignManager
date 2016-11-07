package lv.javaguru.campaignmanager.core.commands.campaigngroups;

import lv.javaguru.campaignmanager.core.commands.DomainCommand;
import lv.javaguru.campaignmanager.core.commands.VoidResult;

public class EditCampaignGroupCommand implements DomainCommand<VoidResult> {

    private Long campaignGroupId;
    private String title;

    public EditCampaignGroupCommand(Long campaignGroupId,
                                    String title) {
        this.campaignGroupId = campaignGroupId;
        this.title = title;
    }

    public Long getCampaignGroupId() {
        return campaignGroupId;
    }

    public String getTitle() {
        return title;
    }

}
