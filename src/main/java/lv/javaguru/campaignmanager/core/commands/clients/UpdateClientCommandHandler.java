package lv.javaguru.campaignmanager.core.commands.clients;

import lv.javaguru.campaignmanager.core.domain.Client;
import lv.javaguru.campaignmanager.integrations.rest.dto.ClientDTO;
import lv.javaguru.campaignmanager.core.services.DomainCommandHandler;
import lv.javaguru.campaignmanager.core.services.clients.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class UpdateClientCommandHandler
        implements DomainCommandHandler<UpdateClientCommand, UpdateClientResult> {

    @Autowired private ClientService clientService;
    @Autowired private ClientConverter clientConverter;


    @Override
    public UpdateClientResult execute(UpdateClientCommand command) {
        Client client = clientService.update(
                command.getClientId(),
                command.getLogin(),
                command.getPassword()
        );
        ClientDTO clientDTO = clientConverter.convert(client);
        return new UpdateClientResult(clientDTO);
    }

    @Override
    public Class getCommandType() {
        return UpdateClientCommand.class;
    }

}
