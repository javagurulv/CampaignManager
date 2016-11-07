package lv.javaguru.campaignmanager.config;

import lv.javaguru.campaignmanager.integrations.rest.CampaignGroupResourceImpl;
import lv.javaguru.campaignmanager.integrations.rest.ClientResourceImpl;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(ClientResourceImpl.class);
        register(CampaignGroupResourceImpl.class);
    }

}
