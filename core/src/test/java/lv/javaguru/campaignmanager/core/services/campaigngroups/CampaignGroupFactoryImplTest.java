package lv.javaguru.campaignmanager.core.services.campaigngroups;

import lv.javaguru.campaignmanager.api.vo.GroupTitle;
import lv.javaguru.campaignmanager.core.domain.CampaignGroup;
import lv.javaguru.campaignmanager.core.domain.repositories.CampaignGroupRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CampaignGroupFactoryImplTest {

    @Mock private CampaignGroupValidator validator;
    @Mock private CampaignGroupRepository repository;

    @InjectMocks
    private CampaignGroupFactory factory = new CampaignGroupFactoryImpl();

    private static final String TITLE = "title";
    private static final GroupTitle GROUP_TITLE = new GroupTitle(TITLE);

    @Test
    public void shouldReturnCampaignGroupWithTitle() {
        when(repository.save(any(CampaignGroup.class))).then(returnsFirstArg());
        CampaignGroup campaignGroup = factory.create(GROUP_TITLE);
        assertThat(campaignGroup.getTitle(), is(TITLE));
    }

    @Test
    public void shouldValidate() {
        factory.create(GROUP_TITLE);
        verify(validator).validateOnCreate(GROUP_TITLE);
    }

    @Test
    public void shouldCreate() {
        when(repository.save(any(CampaignGroup.class))).then(returnsFirstArg());
        CampaignGroup campaignGroup = factory.create(GROUP_TITLE);
        verify(repository).save(campaignGroup);
    }

}
