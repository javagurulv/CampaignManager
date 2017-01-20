package lv.javaguru.campaignmanager.core.services.campaigns;

import lv.javaguru.campaignmanager.api.vo.CampaignTitle;
import lv.javaguru.campaignmanager.core.database.CampaignDAO;
import lv.javaguru.campaignmanager.core.domain.Campaign;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CampaignFactoryImplTest {

    @Mock private CampaignValidator validator;
    @Mock private CampaignDAO dao;

    @InjectMocks
    private CampaignFactory factory = new CampaignFactoryImpl();

    private final static String TITLE = "title";
    private final static CampaignTitle CAMPAIGN_TITLE = new CampaignTitle(TITLE);

    @Test
    public void shouldReturnCampaignWithTitle() {
        Campaign campaign = factory.create(CAMPAIGN_TITLE);
        assertThat(campaign.getTitle(), is(TITLE));
    }

    @Test
    public void shouldReturnCampaignInNotActiveState() {
        Campaign campaign = factory.create(CAMPAIGN_TITLE);
        assertThat(campaign.isNotActive(), is(true));
    }

    @Test
    public void shouldValidate() {
        factory.create(CAMPAIGN_TITLE);
        verify(validator).validateOnCreate(CAMPAIGN_TITLE);
    }

    @Test
    public void shouldCreate() {
        Campaign campaign = factory.create(CAMPAIGN_TITLE);
        verify(dao).create(campaign);
    }

}