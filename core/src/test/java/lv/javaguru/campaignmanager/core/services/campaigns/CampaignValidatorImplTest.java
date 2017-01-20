package lv.javaguru.campaignmanager.core.services.campaigns;

import lv.javaguru.campaignmanager.api.vo.CampaignTitle;
import lv.javaguru.campaignmanager.core.database.CampaignDAO;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Optional;

import static lv.javaguru.campaignmanager.core.domain.builders.CampaignBuilder.createCampaign;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class CampaignValidatorImplTest {

    @Mock private CampaignDAO campaignDAO;

    @InjectMocks
    private CampaignValidator validator = new CampaignValidatorImpl();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private static final String TITLE = "title";


    @Test
    public void shouldThrowExceptionWhenTitleIsNull() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Campaign title must be specified");
        validator.validateOnCreate(null);
    }

    @Test
    public void shouldThrowExceptionWhenTitleIsBlank() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Campaign title must be specified");
        validator.validateOnCreate(new CampaignTitle(""));
    }

    @Test
    public void shouldThrowExceptionWhenCampaignGroupWithSameTitleAlreadyExist() {
        doReturn(Optional.of(createCampaign().build()))
                .when(campaignDAO).findByTitle(TITLE);
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Campaign with same title already exist");
        validator.validateOnCreate(new CampaignTitle(TITLE));
    }

    @Test
    public void shouldSucceed() {
        doReturn(Optional.empty()).when(campaignDAO).findByTitle(TITLE);
        validator.validateOnCreate(new CampaignTitle(TITLE));
    }

}