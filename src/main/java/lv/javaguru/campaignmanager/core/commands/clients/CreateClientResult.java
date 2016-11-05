package lv.javaguru.campaignmanager.core.commands.clients;

import lv.javaguru.campaignmanager.core.commands.DomainCommandResult;
import lv.javaguru.campaignmanager.integrations.rest.dto.ClientDTO;

public class CreateClientResult implements DomainCommandResult {

	private ClientDTO client;

	public CreateClientResult(ClientDTO client) {
		this.client = client;
	}

	public ClientDTO getClient() {
		return client;
	}

}
