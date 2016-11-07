package lv.javaguru.campaignmanager.core.services.campaigngroups;

import lv.javaguru.campaignmanager.core.database.CampaignGroupDAO;
import lv.javaguru.campaignmanager.core.domain.CampaignGroup;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CampaignGroupFactoryImplTest {

    @Mock private CampaignGroupValidator validator;
    @Mock private CampaignGroupDAO dao;

    @InjectMocks
    private CampaignGroupFactory factory = new CampaignGroupFactoryImpl();

    private static final String TITLE = "title";

    @Test
    public void shouldReturnCampaignGroupWithTitle() {
        CampaignGroup campaignGroup = factory.create(TITLE);
        assertThat(campaignGroup.getTitle(), is(TITLE));
    }

    @Test
    public void shouldValidate() {
        factory.create(TITLE);
        verify(validator).validateOnCreate(TITLE);
    }

    @Test
    public void shouldCreate() {
        CampaignGroup campaignGroup = factory.create(TITLE);
        verify(dao).create(campaignGroup);
    }

}
