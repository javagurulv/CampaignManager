package lv.javaguru.campaignmanager.integrations.rest.campaigngroups;

import feign.FeignException;
import lv.javaguru.campaignmanager.integrations.rest.RESTResourceTest;
import lv.javaguru.campaignmanager.integrations.rest.dto.CampaignGroupDTO;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Test;

import static lv.javaguru.campaignmanager.integrations.rest.dto.builders.CampaignGroupDTOBuilder.createCampaignGroupDTO;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class CampaignGroupResourceImplTest extends RESTResourceTest {

    @Test
    public void shouldCreateCampaignGroup() {
        String title = RandomStringUtils.random(20);
        CampaignGroupDTO campaignGroup = createCampaignGroup(title);
        assertThat(campaignGroup, is(notNullValue()));
        assertThat(campaignGroup.getId(), is(notNullValue()));
        assertThat(campaignGroup.getTitle(), is(title));
        assertThat(campaignGroup.getCreatedDate(), is(notNullValue()));
    }

    @Test
    public void shouldFailIfTitleNotProvided() {
        try {
            createCampaignGroup("");
        } catch (FeignException e) {
            assertThat(e.status(), is(500));
        }
    }

    @Test
    public void shouldFailIfCampaignWithSameTitleAlreadyExist() {
        String title = RandomStringUtils.random(20);
        createCampaignGroup(title);
        try {
            createCampaignGroup(title);
        } catch (FeignException e) {
            assertThat(e.status(), is(500));
        }
    }


    private CampaignGroupDTO createCampaignGroup(String title) {
        return campaignGroupResource.create(
                createCampaignGroupDTO().withTitle(title).build()
        );
    }

}
