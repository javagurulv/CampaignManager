package lv.javaguru.campaignmanager.core.database;

import lv.javaguru.campaignmanager.core.domain.Client;
import org.springframework.stereotype.Component;

@Component
class ClientDAOImpl extends CRUDOperationDAOImpl<Client, Long> implements ClientDAO {

}
