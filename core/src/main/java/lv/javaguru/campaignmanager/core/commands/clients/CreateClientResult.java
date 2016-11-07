package lv.javaguru.campaignmanager.core.commands.clients;

import lv.javaguru.campaignmanager.api.dto.ClientDTO;
import lv.javaguru.campaignmanager.core.commands.DomainCommandResult;

public class CreateClientResult implements DomainCommandResult {

	private ClientDTO client;

	public CreateClientResult(ClientDTO client) {
		this.client = client;
	}

	public ClientDTO getClient() {
		return client;
	}

}
