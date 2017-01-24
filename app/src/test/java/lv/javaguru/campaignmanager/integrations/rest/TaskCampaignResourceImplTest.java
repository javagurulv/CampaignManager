package lv.javaguru.campaignmanager.integrations.rest;

import lv.javaguru.campaignmanager.api.dto.CampaignGroupDTO;
import lv.javaguru.campaignmanager.api.dto.TaskCampaignDTO;
import lv.javaguru.campaignmanager.core.domain.CampaignState;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

@Ignore
public class TaskCampaignResourceImplTest extends RESTResourceTest {

    private static final int TITLE_LENGTH = 20;

    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Test
    public void shouldCreateTaskCampaign() {
        CampaignGroupDTO campaignGroup = createGroup();

        String campaignTitle = RandomStringUtils.random(TITLE_LENGTH);
        TaskCampaignDTO campaign = taskCampaignActions.create(
                campaignGroup, campaignTitle
        );

        assertThat(campaign, is(notNullValue()));
        assertThat(campaign.getId(), is(notNullValue()));
        assertThat(campaign.getCampaign(), is(notNullValue()));
        assertThat(campaign.getCampaign().getTitle(), is(campaignTitle));
        assertThat(campaign.getCampaign().getCreatedDate(), is(notNullValue()));
        assertThat(campaign.getCreatedDate(), is(notNullValue()));
    }

    @Test
    public void shouldGetTaskCampaign() {
        CampaignGroupDTO campaignGroup = createGroup();

        String campaignTitle = RandomStringUtils.random(TITLE_LENGTH);
        TaskCampaignDTO campaign = taskCampaignActions.create(
                campaignGroup, campaignTitle
        );

        campaign = taskCampaignActions.get(campaign.getId());
        assertThat(campaign, is(notNullValue()));
        assertThat(campaign.getId(), is(notNullValue()));
        assertThat(campaign.getCampaign(), is(notNullValue()));
        assertThat(campaign.getCampaign().getTitle(), is(campaignTitle));
        assertThat(campaign.getCampaign().getState(), is(CampaignState.NOT_ACTIVE.toString()));
        assertThat(campaign.getCampaign().getCreatedDate(), is(notNullValue()));
        assertThat(campaign.getCreatedDate(), is(notNullValue()));
    }

    @Test
    public void shouldActivateTaskCampaign() {
        CampaignGroupDTO group = createGroup();
        TaskCampaignDTO campaign = createCampaign(group);
        assertThat(campaign.getCampaign().getState(), is(CampaignState.NOT_ACTIVE.toString()));
        activateTaskCampaign(campaign);
        campaign = getTaskCampaign(campaign.getId());
        assertThat(campaign.getCampaign().getState(), is(CampaignState.ACTIVE.toString()));
    }

    @Test
    public void shouldDeactivateTaskCampaign() {
        CampaignGroupDTO group = createGroup();
        TaskCampaignDTO campaign = createCampaign(group);
        activateTaskCampaign(campaign);
        deactivateTaskCampaign(campaign);
        campaign = getTaskCampaign(campaign.getId());
        assertThat(campaign.getCampaign().getState(), is(CampaignState.NOT_ACTIVE.toString()));
    }

}
