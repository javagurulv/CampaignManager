package lv.javaguru.campaignmanager.integrations.rest;

import lv.javaguru.campaignmanager.api.dto.CampaignGroupDTO;
import lv.javaguru.campaignmanager.api.dto.TaskCampaignDTO;
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
        String groupTitle = RandomStringUtils.random(TITLE_LENGTH);
        CampaignGroupDTO campaignGroup = campaignGroupActions.create(groupTitle);

        String campaignTitle = RandomStringUtils.random(TITLE_LENGTH);
        TaskCampaignDTO campaign = taskCampaignActions.create(
                campaignGroup.getId(), campaignTitle
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
        String groupTitle = RandomStringUtils.random(TITLE_LENGTH);
        CampaignGroupDTO campaignGroup = campaignGroupActions.create(groupTitle);

        String campaignTitle = RandomStringUtils.random(TITLE_LENGTH);
        TaskCampaignDTO campaign = taskCampaignActions.create(
                campaignGroup.getId(), campaignTitle
        );

        campaign = taskCampaignActions.get(campaign.getId());
        assertThat(campaign, is(notNullValue()));
        assertThat(campaign.getId(), is(notNullValue()));
        assertThat(campaign.getCampaign(), is(notNullValue()));
        assertThat(campaign.getCampaign().getTitle(), is(campaignTitle));
        assertThat(campaign.getCampaign().getCreatedDate(), is(notNullValue()));
        assertThat(campaign.getCreatedDate(), is(notNullValue()));
    }

}
