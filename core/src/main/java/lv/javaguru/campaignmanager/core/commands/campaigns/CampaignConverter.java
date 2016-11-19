package lv.javaguru.campaignmanager.core.commands.campaigns;

import lv.javaguru.campaignmanager.api.dto.CampaignDTO;
import lv.javaguru.campaignmanager.core.domain.Campaign;
import org.springframework.stereotype.Component;

import static lv.javaguru.campaignmanager.api.dto.builders.CampaignDTOBuilder.createCampaignDTO;

@Component
public class CampaignConverter {

    public CampaignDTO convert(Campaign campaign) {
        return createCampaignDTO()
                .withId(campaign.getId())
                .withTitle(campaign.getTitle())
                .withState(campaign.getState().toString())
                .withCreatedDate(campaign.getCreatedDate())
                .withUpdatedDate(campaign.getUpdatedDate())
                .build();
    }

}
