package lv.javaguru.campaignmanager.core.commands.campaigngroups;

import lv.javaguru.campaignmanager.api.PageRequest;
import lv.javaguru.campaignmanager.core.DomainCommand;

public class GetCampaignGroupsCommand implements DomainCommand<GetCampaignGroupsResult> {

    private PageRequest pageRequest;

    public GetCampaignGroupsCommand(PageRequest pageRequest) {
        this.pageRequest = pageRequest;
    }

    public PageRequest getPageRequest() {
        return pageRequest;
    }
}
