package lv.javaguru.campaignmanager.core.database.clients;

import lv.javaguru.campaignmanager.core.database.ClientDAO;
import lv.javaguru.campaignmanager.core.domain.Client;
import org.springframework.stereotype.Component;

@Component
class ClientDAOImpl extends CRUDOperationDAOImpl<Client, Long> implements ClientDAO {

}
