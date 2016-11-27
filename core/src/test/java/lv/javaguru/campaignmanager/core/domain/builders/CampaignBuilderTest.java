package lv.javaguru.campaignmanager.core.domain.builders;

import lv.javaguru.campaignmanager.core.domain.Campaign;
import lv.javaguru.campaignmanager.core.domain.CampaignState;
import org.junit.Test;

import static lv.javaguru.campaignmanager.core.domain.builders.CampaignBuilder.createCampaign;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CampaignBuilderTest {

    private static final Long ID = 1L;
    private static final String TITLE = "title";

    @Test
    public void shouldBuildCampaignWithId() {
        Campaign campaign = createCampaign().withId(ID).build();
        assertThat(campaign.getId(), is(ID));
    }

    @Test
    public void shouldBuildCampaignWithTitle() {
        Campaign campaign = createCampaign().withTitle(TITLE).build();
        assertThat(campaign.getTitle(), is(TITLE));
    }

    @Test
    public void shouldBuildCampaignWithState() {
        Campaign campaign = createCampaign()
                .withState(CampaignState.ACTIVE).build();
        assertThat(campaign.getState(), is(CampaignState.ACTIVE));
    }

}
