package lv.javaguru.campaignmanager.integrations.rest;

import feign.FeignException;
import lv.javaguru.campaignmanager.api.dto.CampaignGroupDTO;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Ignore;
import org.junit.Test;

import javax.ws.rs.core.Response;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

@Ignore
public class CampaignGroupResourceImplTest extends RESTResourceTest {

    private static final int TITLE_LENGTH = 20;

    @Test
    public void shouldCreateCampaignGroup() {
        String title = RandomStringUtils.random(TITLE_LENGTH);
        CampaignGroupDTO campaignGroup = campaignGroupActions.create(title);
        assertThat(campaignGroup, is(notNullValue()));
        assertThat(campaignGroup.getId(), is(notNullValue()));
        assertThat(campaignGroup.getTitle(), is(title));
        assertThat(campaignGroup.getCreatedDate(), is(notNullValue()));
    }

    @Test
    public void shouldFailIfTitleNotProvided() {
        try {
            campaignGroupActions.create("");
        } catch (FeignException e) {
            assertThat(e.status(), is(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()));
        }
    }

    @Test
    public void shouldFailIfCampaignWithSameTitleAlreadyExist() {
        String title = RandomStringUtils.random(TITLE_LENGTH);
        campaignGroupActions.create(title);
        try {
            campaignGroupActions.create(title);
        } catch (FeignException e) {
            assertThat(e.status(), is(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()));
        }
    }

}
