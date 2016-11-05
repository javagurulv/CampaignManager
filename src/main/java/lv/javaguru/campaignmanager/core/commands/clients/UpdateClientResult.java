package lv.javaguru.campaignmanager.core.commands.clients;

import lv.javaguru.campaignmanager.core.commands.DomainCommandResult;
import lv.javaguru.campaignmanager.integrations.rest.dto.ClientDTO;

public class UpdateClientResult implements DomainCommandResult {

    private ClientDTO client;

    public UpdateClientResult(ClientDTO client) {
        this.client = client;
    }

    public ClientDTO getClient() {
        return client;
    }

}
