package lv.javaguru.campaignmanager.core.services.campaigns;

import lv.javaguru.campaignmanager.core.vo.CampaignGroupId;
import lv.javaguru.campaignmanager.core.vo.CampaignTitle;
import lv.javaguru.campaignmanager.core.domain.repositories.CampaignRepository;
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

    @Mock private CampaignRepository campaignRepository;

    @InjectMocks
    private CampaignValidator validator = new CampaignValidatorImpl();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private static final String TITLE = "title";
    private static final Long GROUP_ID = 1L;


    @Test
    public void shouldThrowExceptionWhenGroupIsNull() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Campaign Group must be specified");
        validator.validateOnCreate(null, new CampaignTitle(TITLE));
    }

    @Test
    public void shouldThrowExceptionWhenGroupIdIsNull() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Campaign Group must be specified");
        validator.validateOnCreate(new CampaignGroupId(null), new CampaignTitle(TITLE));
    }

    @Test
    public void shouldThrowExceptionWhenTitleIsNull() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Campaign title must be specified");
        validator.validateOnCreate(new CampaignGroupId(GROUP_ID), null);
    }

    @Test
    public void shouldThrowExceptionWhenTitleIsBlank() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Campaign title must be specified");
        validator.validateOnCreate(
                new CampaignGroupId(GROUP_ID),
                new CampaignTitle("")
        );
    }

    @Test
    public void shouldThrowExceptionWhenCampaignGroupWithSameTitleAlreadyExist() {
        doReturn(Optional.of(createCampaign().build()))
                .when(campaignRepository).findByTitle(TITLE);
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Campaign with same title already exist");
        validator.validateOnCreate(
                new CampaignGroupId(GROUP_ID),
                new CampaignTitle(TITLE)
        );
    }

    @Test
    public void shouldSucceed() {
        doReturn(Optional.empty()).when(campaignRepository).findByTitle(TITLE);
        validator.validateOnCreate(
                new CampaignGroupId(GROUP_ID),
                new CampaignTitle(TITLE)
        );
    }

}
