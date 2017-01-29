package lv.javaguru.campaignmanager.core.commands.campaigns;

import lv.javaguru.campaignmanager.api.dto.campaigns.CampaignDTO;
import lv.javaguru.campaignmanager.api.dto.groups.CampaignGroupDTO;
import lv.javaguru.campaignmanager.core.domain.Campaign;
import lv.javaguru.campaignmanager.core.domain.CampaignGroup;
import lv.javaguru.campaignmanager.core.domain.CampaignState;
import lv.javaguru.campaignmanager.core.domain.converters.CampaignConverter;
import lv.javaguru.campaignmanager.core.domain.converters.CampaignGroupConverter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static lv.javaguru.campaignmanager.core.domain.builders.CampaignBuilder.createCampaign;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class CampaignConverterTest {

    @Mock private CampaignGroupConverter groupConverter;

    @InjectMocks
    private CampaignConverter converter = new CampaignConverter();

    private static final Long ID = 1L;
    private static final String TITLE = "title";

    @Test
    public void shouldConvert() {
        CampaignGroup campaignGroup = mock(CampaignGroup.class);
        CampaignGroupDTO groupDTO = mock(CampaignGroupDTO.class);
        doReturn(groupDTO).when(groupConverter).convert(campaignGroup);

        Campaign campaign = createCampaign()
                .withId(ID)
                .withTitle(TITLE)
                .withState(CampaignState.ACTIVE)
                .with(campaignGroup)
                .build();
        CampaignDTO campaignDTO = converter.convert(campaign);
        assertThat(campaignDTO.getId(), is(ID));
        assertThat(campaignDTO.getTitle(), is(TITLE));
        assertThat(campaignDTO.getState(), is(CampaignState.ACTIVE.toString()));
        assertThat(campaignDTO.getCampaignGroupDTO(), is(sameInstance(groupDTO)));
        assertThat(campaignDTO.getCreatedDate(), is(notNullValue()));
    }

}
