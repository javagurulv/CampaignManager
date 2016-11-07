package lv.javaguru.campaignmanager.core.commands.clients;

import lv.javaguru.campaignmanager.api.dto.ClientDTO;
import lv.javaguru.campaignmanager.core.domain.Client;
import org.springframework.stereotype.Component;

import static lv.javaguru.campaignmanager.api.dto.builders.ClientDTOBuilder.createClientDTO;

@Component
class ClientConverter {

    ClientDTO convert(Client client) {
        return createClientDTO()
                .withId(client.getId())
                .withLogin(client.getLogin())
                .withPassword(client.getPassword()).build();
    }

}
