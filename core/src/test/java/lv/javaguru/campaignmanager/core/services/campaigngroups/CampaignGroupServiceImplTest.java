package lv.javaguru.campaignmanager.core.services.campaigngroups;

import lv.javaguru.campaignmanager.api.vo.CampaignGroupId;
import lv.javaguru.campaignmanager.api.vo.GroupTitle;
import lv.javaguru.campaignmanager.core.database.CampaignGroupDAO;
import lv.javaguru.campaignmanager.core.domain.CampaignGroup;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static lv.javaguru.campaignmanager.core.domain.builders.CampaignGroupBuilder.createCampaignGroup;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CampaignGroupServiceImplTest {

    @Mock private CampaignGroupValidator validator;
    @Mock private CampaignGroupDAO dao;

    @InjectMocks
    private CampaignGroupService service = new CampaignGroupServiceImpl();


    private static final CampaignGroupId CAMPAIGN_GROUP_ID = new CampaignGroupId(1L);
    private static final String TITLE = "title";
    private static final GroupTitle GROUP_TITLE = new GroupTitle(TITLE);

    @Test
    public void editShouldInvokeValidate() {
        CampaignGroup campaignGroup = createCampaignGroup().build();
        doReturn(campaignGroup).when(dao).getRequired(CAMPAIGN_GROUP_ID.get());
        service.edit(CAMPAIGN_GROUP_ID, GROUP_TITLE);
        verify(validator).validateOnEdit(campaignGroup, GROUP_TITLE);
    }

    @Test
    public void editShouldUpdateGroupTitle() {
        CampaignGroup campaignGroup = createCampaignGroup().build();
        assertThat(campaignGroup.getTitle(), is(nullValue()));
        doReturn(campaignGroup).when(dao).getRequired(CAMPAIGN_GROUP_ID.get());
        service.edit(CAMPAIGN_GROUP_ID, GROUP_TITLE);
        assertThat(campaignGroup.getTitle(), is(TITLE));
    }

    @Test
    public void editShouldUpdateUpdatedDate() {
        CampaignGroup campaignGroup = createCampaignGroup().build();
        assertThat(campaignGroup.getUpdatedDate(), is(nullValue()));
        doReturn(campaignGroup).when(dao).getRequired(CAMPAIGN_GROUP_ID.get());
        service.edit(CAMPAIGN_GROUP_ID, GROUP_TITLE);
        assertThat(campaignGroup.getUpdatedDate(), is(notNullValue()));
    }

}