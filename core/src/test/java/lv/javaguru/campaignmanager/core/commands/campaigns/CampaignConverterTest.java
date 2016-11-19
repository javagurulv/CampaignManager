package lv.javaguru.campaignmanager.core.commands.campaigns;

import lv.javaguru.campaignmanager.api.dto.CampaignDTO;
import lv.javaguru.campaignmanager.core.domain.Campaign;
import lv.javaguru.campaignmanager.core.domain.CampaignState;
import org.junit.Test;

import static lv.javaguru.campaignmanager.core.domain.builders.CampaignBuilder.createCampaign;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class CampaignConverterTest {

    private CampaignConverter converter = new CampaignConverter();

    private static final Long ID = 1L;
    private static final String TITLE = "title";

    @Test
    public void shouldConvert() {
        Campaign campaign = createCampaign()
                .withId(ID)
                .withTitle(TITLE)
                .withState(CampaignState.ACTIVE)
                .build();
        CampaignDTO campaignDTO = converter.convert(campaign);
        assertThat(campaignDTO.getId(), is(ID));
        assertThat(campaignDTO.getTitle(), is(TITLE));
        assertThat(campaignDTO.getState(), is(CampaignState.ACTIVE.toString()));
        assertThat(campaignDTO.getCreatedDate(), is(notNullValue()));
    }

}
