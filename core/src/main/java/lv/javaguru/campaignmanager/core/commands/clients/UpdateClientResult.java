package lv.javaguru.campaignmanager.core.commands.clients;

import lv.javaguru.campaignmanager.api.dto.ClientDTO;
import lv.javaguru.campaignmanager.core.DomainCommandResult;

public class UpdateClientResult implements DomainCommandResult {

    private ClientDTO client;

    public UpdateClientResult(ClientDTO client) {
        this.client = client;
    }

    public ClientDTO getClient() {
        return client;
    }

}
