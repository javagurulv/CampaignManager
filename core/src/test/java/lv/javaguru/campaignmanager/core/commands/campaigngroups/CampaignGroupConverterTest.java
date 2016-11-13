package lv.javaguru.campaignmanager.core.commands.campaigngroups;

import lv.javaguru.campaignmanager.api.dto.CampaignGroupDTO;
import lv.javaguru.campaignmanager.core.domain.CampaignGroup;
import org.junit.Test;

import java.util.Date;

import static lv.javaguru.campaignmanager.core.domain.builders.CampaignGroupBuilder.createCampaignGroup;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class CampaignGroupConverterTest {

    private CampaignGroupConverter converter = new CampaignGroupConverter();

    @Test
    public void shouldConvertId() {
        CampaignGroup campaignGroup = createCampaignGroup().withId(1L).build();
        CampaignGroupDTO campaignGroupDTO = converter.convert(campaignGroup);
        assertThat(campaignGroupDTO.getId(), is(1L));
    }

    @Test
    public void shouldConvertTitle() {
        CampaignGroup campaignGroup = createCampaignGroup().withTitle("title").build();
        CampaignGroupDTO campaignGroupDTO = converter.convert(campaignGroup);
        assertThat(campaignGroupDTO.getTitle(), is("title"));
    }

    @Test
    public void shouldConvertCreatedDate() {
        CampaignGroup campaignGroup = createCampaignGroup().build();
        CampaignGroupDTO campaignGroupDTO = converter.convert(campaignGroup);
        assertThat(campaignGroupDTO.getCreatedDate(), is(notNullValue()));
    }

    @Test
    public void shouldConvertUpdatedDate() {
        Date updatedDate = new Date();
        CampaignGroup campaignGroup = createCampaignGroup()
                .withUpdatedDate(updatedDate).build();
        CampaignGroupDTO campaignGroupDTO = converter.convert(campaignGroup);
        assertThat(campaignGroupDTO.getUpdatedDate(), is(updatedDate));
    }

}