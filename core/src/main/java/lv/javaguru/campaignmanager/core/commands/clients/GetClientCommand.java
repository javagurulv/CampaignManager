package lv.javaguru.campaignmanager.core.commands.clients;

import lv.javaguru.campaignmanager.core.DomainCommand;

public class GetClientCommand implements DomainCommand<GetClientResult> {

    private Long clientId;

    public GetClientCommand(Long clientId) {
        this.clientId = clientId;
    }

    public Long getClientId() {
        return clientId;
    }

}
