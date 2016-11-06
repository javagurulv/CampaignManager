package lv.javaguru.campaignmanager.integrations.rest;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.jaxrs.JAXRSContract;
import lv.javaguru.campaignmanager.config.Application;
import lv.javaguru.campaignmanager.integrations.rest.api.CampaignGroupResource;
import lv.javaguru.campaignmanager.integrations.rest.api.ClientResource;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@WebIntegrationTest(randomPort = true)
@SpringApplicationConfiguration(classes = {Application.class})
public class RESTResourceTest {

    @Value("${local.server.port}")
    private int port;

    protected ClientResource clientResource;
    protected CampaignGroupResource campaignGroupResource;


    @Before
    public void init() {
        String url = "http://localhost:" + port;

        clientResource = Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .contract(new JAXRSContract())
                .target(ClientResource.class, url);

        campaignGroupResource = Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .contract(new JAXRSContract())
                .target(CampaignGroupResource.class, url);

    }

}
