package lv.javaguru.campaignmanager.integrations.rest;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.jaxrs.JAXRSContract;
import lv.javaguru.campaignmanager.api.CampaignGroupResource;
import lv.javaguru.campaignmanager.api.TaskCampaignResource;
import lv.javaguru.campaignmanager.api.dto.CampaignGroupDTO;
import lv.javaguru.campaignmanager.api.dto.TaskCampaignDTO;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Before;
import org.junit.Ignore;

@Ignore
public abstract class RESTResourceTest {

    protected CampaignGroupActions campaignGroupActions;
    protected TaskCampaignActions taskCampaignActions;

    @Before
    public void init() {
        String url = "http://localhost:" + 8080;

        CampaignGroupResource campaignGroupResource = Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .contract(new JAXRSContract())
                .target(CampaignGroupResource.class, url);
        campaignGroupActions = new CampaignGroupActions(campaignGroupResource);

        TaskCampaignResource taskCampaignResource = Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .contract(new JAXRSContract())
                .target(TaskCampaignResource.class, url);
        taskCampaignActions = new TaskCampaignActions(taskCampaignResource);
    }

    private static final int TITLE_LENGTH = 20;


    protected CampaignGroupDTO createGroup() {
        String groupTitle = RandomStringUtils.random(TITLE_LENGTH);
        return campaignGroupActions.create(groupTitle);
    }

    protected TaskCampaignDTO createCampaign(CampaignGroupDTO campaignGroup) {
        String campaignTitle = RandomStringUtils.random(TITLE_LENGTH);
        return taskCampaignActions.create(
                campaignGroup, campaignTitle
        );
    }

    protected void activateTaskCampaign(TaskCampaignDTO taskCampaign) {
        taskCampaignActions.activate(taskCampaign);
    }

    protected void deactivateTaskCampaign(TaskCampaignDTO taskCampaign) {
        taskCampaignActions.deactivate(taskCampaign);
    }

    protected TaskCampaignDTO getTaskCampaign(Long taskCampaignId) {
        return taskCampaignActions.get(taskCampaignId);
    }

}
