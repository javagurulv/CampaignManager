package lv.javaguru.campaignmanager.core.domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CampaignStateTest {

    @Test
    public void shouldAllowNotActiveTransitions() {
        allowTransition(CampaignState.NOT_ACTIVE, CampaignState.ACTIVE);
        allowTransition(CampaignState.NOT_ACTIVE, CampaignState.CLOSED);
    }

    @Test
    public void shouldAllowActiveTransitions() {
        allowTransition(CampaignState.ACTIVE, CampaignState.NOT_ACTIVE);
        notAllowTransition(CampaignState.ACTIVE, CampaignState.CLOSED);
    }

    @Test
    public void shouldAllowClosedTransitions() {
        notAllowTransition(CampaignState.CLOSED, CampaignState.ACTIVE);
        notAllowTransition(CampaignState.CLOSED, CampaignState.NOT_ACTIVE);
    }

    private void allowTransition(CampaignState from, CampaignState to) {
        assertThat(from.isTransitionAllowed(to), is(true));
    }

    private void notAllowTransition(CampaignState from, CampaignState to) {
        assertThat(from.isTransitionAllowed(to), is(false));
    }

}
