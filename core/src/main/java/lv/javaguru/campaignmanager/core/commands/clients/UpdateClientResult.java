package lv.javaguru.campaignmanager.core.commands.clients;

import lv.javaguru.campaignmanager.api.dto.ClientDTO;
import lv.javaguru.campaignmanager.core.commands.DomainCommandResult;

public class UpdateClientResult implements DomainCommandResult {

    private ClientDTO client;

    public UpdateClientResult(ClientDTO client) {
        this.client = client;
    }

    public ClientDTO getClient() {
        return client;
    }

}
