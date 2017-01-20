package lv.javaguru.campaignmanager.core.services.campaigns;

import lv.javaguru.campaignmanager.api.vo.CampaignGroupId;
import lv.javaguru.campaignmanager.api.vo.CampaignTitle;
import lv.javaguru.campaignmanager.core.database.CampaignDAO;
import lv.javaguru.campaignmanager.core.database.CampaignGroupDAO;
import lv.javaguru.campaignmanager.core.domain.Campaign;
import lv.javaguru.campaignmanager.core.domain.CampaignGroup;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.sameInstance;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CampaignFactoryImplTest {

    @Mock private CampaignValidator validator;
    @Mock private CampaignGroupDAO campaignGroupDAO;
    @Mock private CampaignDAO campaignDAO;

    @InjectMocks
    private CampaignFactory factory = new CampaignFactoryImpl();

    private final static Long GROUP_ID = 1L;
    private final static String TITLE = "title";
    private final static CampaignTitle CAMPAIGN_TITLE = new CampaignTitle(TITLE);
    private final static CampaignGroupId CAMPAIGN_GROUP_ID = new CampaignGroupId(GROUP_ID);

    @Test
    public void shouldReturnCampaignWithTitle() {
        Campaign campaign = factory.create(CAMPAIGN_GROUP_ID, CAMPAIGN_TITLE);
        assertThat(campaign.getTitle(), is(TITLE));
    }

    @Test
    public void shouldReturnCampaignWithGroupState() {
        CampaignGroup campaignGroup = mock(CampaignGroup.class);
        doReturn(campaignGroup).when(campaignGroupDAO).getRequired(CAMPAIGN_GROUP_ID.get());
        Campaign campaign = factory.create(CAMPAIGN_GROUP_ID, CAMPAIGN_TITLE);
        assertThat(campaign.hasGroup(), is(true));
        assertThat(campaign.getCampaignGroup(), is(sameInstance(campaignGroup)));
    }

    @Test
    public void shouldReturnCampaignInNotActiveState() {
        Campaign campaign = factory.create(CAMPAIGN_GROUP_ID, CAMPAIGN_TITLE);
        assertThat(campaign.isNotActive(), is(true));
    }

    @Test
    public void shouldValidate() {
        factory.create(CAMPAIGN_GROUP_ID, CAMPAIGN_TITLE);
        verify(validator).validateOnCreate(CAMPAIGN_GROUP_ID, CAMPAIGN_TITLE);
    }

    @Test
    public void shouldCreate() {
        Campaign campaign = factory.create(CAMPAIGN_GROUP_ID, CAMPAIGN_TITLE);
        verify(campaignDAO).create(campaign);
    }

}
