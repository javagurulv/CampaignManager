package lv.javaguru.campaignmanager.core.domain;

import lv.javaguru.campaignmanager.core.domain.builders.CampaignBuilder;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CampaignTest {

    @Test
    public void isActive() {
        assertThat(createCampaign(CampaignState.ACTIVE).isActive(), is(true));
        assertThat(createCampaign(CampaignState.NOT_ACTIVE).isActive(), is(false));
        assertThat(createCampaign(CampaignState.CLOSED).isActive(), is(false));
    }

    @Test
    public void isNotActive() {
        assertThat(createCampaign(CampaignState.ACTIVE).isNotActive(), is(false));
        assertThat(createCampaign(CampaignState.NOT_ACTIVE).isNotActive(), is(true));
        assertThat(createCampaign(CampaignState.CLOSED).isNotActive(), is(false));
    }

    @Test
    public void isClosed() {
        assertThat(createCampaign(CampaignState.ACTIVE).isClosed(), is(false));
        assertThat(createCampaign(CampaignState.NOT_ACTIVE).isClosed(), is(false));
        assertThat(createCampaign(CampaignState.CLOSED).isClosed(), is(true));
    }

    private Campaign createCampaign(CampaignState state) {
        return CampaignBuilder.createCampaign().withState(state).build();
    }

}
