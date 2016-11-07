package lv.javaguru.campaignmanager.integrations.rest;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.jaxrs.JAXRSContract;
import lv.javaguru.campaignmanager.api.CampaignGroupResource;
import org.junit.Before;
import org.junit.Ignore;

@Ignore
public abstract class RESTResourceTest {

    protected CampaignGroupActions campaignGroupActions;

    @Before
    public void init() {
        String url = "http://localhost:" + 8080;

        CampaignGroupResource campaignGroupResource = Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .contract(new JAXRSContract())
                .target(CampaignGroupResource.class, url);
        campaignGroupActions = new CampaignGroupActions(campaignGroupResource);

    }

}
