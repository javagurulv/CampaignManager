package lv.javaguru.campaignmanager.core.commands.clients;

import lv.javaguru.campaignmanager.core.domain.Client;
import lv.javaguru.campaignmanager.integrations.rest.dto.ClientDTO;
import org.springframework.stereotype.Component;

import static lv.javaguru.campaignmanager.integrations.rest.dto.builders.ClientDTOBuilder.createClientDTO;

@Component
class ClientConverter {

    ClientDTO convert(Client client) {
        return createClientDTO()
                .withId(client.getId())
                .withLogin(client.getLogin())
                .withPassword(client.getPassword()).build();
    }

}
