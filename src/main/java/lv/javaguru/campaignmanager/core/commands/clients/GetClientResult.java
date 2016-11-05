package lv.javaguru.campaignmanager.core.commands.clients;

import lv.javaguru.campaignmanager.core.commands.DomainCommandResult;
import lv.javaguru.campaignmanager.integrations.rest.dto.ClientDTO;

public class GetClientResult implements DomainCommandResult {

    private ClientDTO client;

    public GetClientResult(ClientDTO client) {
        this.client = client;
    }

    public ClientDTO getClient() {
        return client;
    }

}
