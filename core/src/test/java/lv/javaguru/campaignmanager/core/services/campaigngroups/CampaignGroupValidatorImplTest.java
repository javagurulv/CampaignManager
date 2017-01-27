package lv.javaguru.campaignmanager.core.services.campaigngroups;

import lv.javaguru.campaignmanager.core.vo.GroupTitle;
import lv.javaguru.campaignmanager.core.domain.repositories.CampaignGroupRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Optional;

import static lv.javaguru.campaignmanager.core.domain.builders.CampaignGroupBuilder.createCampaignGroup;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class CampaignGroupValidatorImplTest {

    @Mock private CampaignGroupRepository campaignGroupRepository;

    @InjectMocks
    private CampaignGroupValidator validator = new CampaignGroupValidatorImpl();

    @Rule public ExpectedException thrown = ExpectedException.none();

    private static final String TITLE = "title";

    @Test
    public void shouldThrowExceptionWhenTitleIsNull() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Campaign Group title must be specified");
        validator.validateOnCreate(null);
    }

    @Test
    public void shouldThrowExceptionWhenTitleIsBlank() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Campaign Group title must be specified");
        validator.validateOnCreate(new GroupTitle(""));
    }

    @Test
    public void shouldThrowExceptionWhenCampaignGroupWithSameTitleAlreadyExist() {
        doReturn(Optional.of(createCampaignGroup().build()))
                .when(campaignGroupRepository).findByTitle(TITLE);
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Campaign Group with same title already exist");
        validator.validateOnCreate(new GroupTitle(TITLE));
    }

    @Test
    public void shouldSucceed() {
        doReturn(Optional.empty()).when(campaignGroupRepository).findByTitle(TITLE);
        validator.validateOnCreate(new GroupTitle(TITLE));
    }

}
