package lv.javaguru.campaignmanager.core.domain.builders;

import lv.javaguru.campaignmanager.core.domain.CampaignGroup;
import org.junit.Test;

import static lv.javaguru.campaignmanager.core.domain.builders.CampaignGroupBuilder.createCampaignGroup;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CampaignGroupBuilderTest {

    private static final Long ID = 1L;
    private static final String TITLE = "title";

    @Test
    public void shouldBuildCampaignGroupWithId() {
        CampaignGroup group = createCampaignGroup().withId(ID).build();
        assertThat(group.getId(), is(ID));
    }

    @Test
    public void shouldBuildCampaignGroupWithTitle() {
        CampaignGroup group = createCampaignGroup().withTitle(TITLE).build();
        assertThat(group.getTitle(), is(TITLE));
    }

}
