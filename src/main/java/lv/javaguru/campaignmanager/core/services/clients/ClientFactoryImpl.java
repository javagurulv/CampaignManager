package lv.javaguru.campaignmanager.core.services.clients;

import lv.javaguru.campaignmanager.core.database.ClientDAO;
import lv.javaguru.campaignmanager.core.domain.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static lv.javaguru.campaignmanager.core.domain.builders.ClientBuilder.createClient;

@Component
class ClientFactoryImpl implements ClientFactory {

    @Autowired private ClientValidator clientValidator;
    @Autowired private ClientDAO clientDAO;


    @Override
    public Client create(String login, String password) {
        clientValidator.validate(login, password);
        Client client = createClient()
                .withLogin(login)
                .withPassword(password)
                .build();
        clientDAO.create(client);
        return client;
    }

}
