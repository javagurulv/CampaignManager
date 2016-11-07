package lv.javaguru.campaignmanager.core.services.clients;

import lv.javaguru.campaignmanager.core.domain.Client;


public interface ClientService {

    Client update(Long clientId,
                  String newLogin,
                  String newPassword);

    Client get(Long clientId);

}
