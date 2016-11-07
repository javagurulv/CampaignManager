package lv.javaguru.campaignmanager.core.commands.clients;

import lv.javaguru.campaignmanager.api.dto.ClientDTO;
import lv.javaguru.campaignmanager.core.domain.Client;
import lv.javaguru.campaignmanager.core.services.DomainCommandHandler;
import lv.javaguru.campaignmanager.core.services.clients.ClientFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class CreateClientCommandHandler
		implements DomainCommandHandler<CreateClientCommand, CreateClientResult> {

	@Autowired private ClientFactory clientFactory;
	@Autowired private ClientConverter clientConverter;


	@Override
	public CreateClientResult execute(CreateClientCommand command) {
		Client client = clientFactory.create(
				command.getLogin(),
				command.getPassword()
		);
		ClientDTO clientDTO = clientConverter.convert(client);
		return new CreateClientResult(clientDTO);
	}

	@Override
	public Class getCommandType() {
		return CreateClientCommand.class;
	}
	
}
