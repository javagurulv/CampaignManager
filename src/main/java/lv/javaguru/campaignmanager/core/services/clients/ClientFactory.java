package lv.javaguru.campaignmanager.core.services.clients;

import lv.javaguru.campaignmanager.core.domain.Client;

public interface ClientFactory {

    Client create(String login, String password);

}
