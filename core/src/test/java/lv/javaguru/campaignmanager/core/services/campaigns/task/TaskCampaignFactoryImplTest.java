package lv.javaguru.campaignmanager.core.services.campaigns.task;

import lv.javaguru.campaignmanager.api.vo.CampaignGroupId;
import lv.javaguru.campaignmanager.api.vo.CampaignTitle;
import lv.javaguru.campaignmanager.core.database.TaskCampaignDAO;
import lv.javaguru.campaignmanager.core.domain.Campaign;
import lv.javaguru.campaignmanager.core.domain.TaskCampaign;
import lv.javaguru.campaignmanager.core.services.campaigns.CampaignFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static lv.javaguru.campaignmanager.core.domain.builders.CampaignBuilder.createCampaign;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.sameInstance;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TaskCampaignFactoryImplTest {

    @Mock private CampaignFactory campaignFactory;
    @Mock private TaskCampaignDAO dao;

    @InjectMocks
    private TaskCampaignFactory factory = new TaskCampaignFactoryImpl();

    private final static Long GROUP_ID = 1L;
    private final static String TITLE = "title";
    private final static CampaignTitle CAMPAIGN_TITLE = new CampaignTitle(TITLE);
    private final static CampaignGroupId CAMPAIGN_GROUP_ID = new CampaignGroupId(GROUP_ID);

    @Test
    public void shouldCreateCampaign() {
        factory.create(CAMPAIGN_GROUP_ID, CAMPAIGN_TITLE);
        verify(campaignFactory).create(CAMPAIGN_GROUP_ID, CAMPAIGN_TITLE);
    }

    @Test
    public void shouldCreate() {
        TaskCampaign taskCampaign = factory.create(CAMPAIGN_GROUP_ID, CAMPAIGN_TITLE);
        verify(dao).create(taskCampaign);
    }

    @Test
    public void shouldReturnTaskCampaign() {
        Campaign campaign = createCampaign().build();
        doReturn(campaign).when(campaignFactory).create(CAMPAIGN_GROUP_ID, CAMPAIGN_TITLE);
        TaskCampaign taskCampaign = factory.create(CAMPAIGN_GROUP_ID, CAMPAIGN_TITLE);
        assertThat(taskCampaign.getCampaign(), is(sameInstance(campaign)));
    }

}
