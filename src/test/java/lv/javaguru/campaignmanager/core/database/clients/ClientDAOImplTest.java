package lv.javaguru.campaignmanager.core.database.clients;

import lv.javaguru.campaignmanager.core.domain.Client;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import static lv.javaguru.campaignmanager.core.domain.builders.ClientBuilder.createClient;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class ClientDAOImplTest extends DatabaseHibernateTest {

    @Test
    @Transactional
    public void testCreateClient() {
        Client client = createClient()
                .withLogin("login")
                .withPassword("password").build();
        assertThat(client.getId(), is(nullValue()));
        clientDAO.create(client);
        assertThat(client.getId(), is(notNullValue()));
    }

    @Test
    @Transactional
    public void testGetClientById() {
        Client client = createClient()
                .withLogin("login")
                .withPassword("password").build();
        clientDAO.create(client);
        Client clientFromDb = clientDAO.getRequired(client.getId());
        assertThat(clientFromDb, is(notNullValue()));
    }

}