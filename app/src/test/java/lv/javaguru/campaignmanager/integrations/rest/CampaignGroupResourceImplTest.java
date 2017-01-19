package lv.javaguru.campaignmanager.integrations.rest;

import lv.javaguru.campaignmanager.api.dto.CampaignGroupDTO;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static lv.javaguru.campaignmanager.integrations.rest.FeignExceptionMatcher.createInternalServerErrorMatcher;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

@Ignore
public class CampaignGroupResourceImplTest extends RESTResourceTest {

    private static final int TITLE_LENGTH = 20;

    @Rule
    public ExpectedException thrown = ExpectedException.none();


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
        thrown.expect(createInternalServerErrorMatcher());
        campaignGroupActions.create("");
    }

    @Test
    public void shouldFailIfCampaignWithSameTitleAlreadyExist() {
        String title = RandomStringUtils.random(TITLE_LENGTH);
        campaignGroupActions.create(title);
        thrown.expect(createInternalServerErrorMatcher());
        campaignGroupActions.create(title);
    }

    @Test
    public void shouldEditCampaignGroup() {
        String title = RandomStringUtils.random(TITLE_LENGTH);
        CampaignGroupDTO campaignGroup = campaignGroupActions.create(title);
        String newTitle = RandomStringUtils.random(TITLE_LENGTH);
        campaignGroupActions.edit(campaignGroup.getId(), newTitle);
        campaignGroup = campaignGroupActions.get(campaignGroup.getId());
        assertThat(campaignGroup.getTitle(), is(newTitle));
    }

    @Test
    public void editShouldFailIfCampaignWithSameTitleAlreadyExist() {
        String title = RandomStringUtils.random(TITLE_LENGTH);
        campaignGroupActions.create(title);
        String newTitle = RandomStringUtils.random(TITLE_LENGTH);
        CampaignGroupDTO campaignGroup = campaignGroupActions.create(newTitle);
        thrown.expect(createInternalServerErrorMatcher());
        campaignGroupActions.edit(campaignGroup.getId(), title);
    }

    @Test
    public void shouldGetCampaignGroup() {
        String title = RandomStringUtils.random(TITLE_LENGTH);
        CampaignGroupDTO campaignGroup = campaignGroupActions.create(title);
        campaignGroup = campaignGroupActions.get(campaignGroup.getId());
        assertThat(campaignGroup.getTitle(), is(title));
    }

}
