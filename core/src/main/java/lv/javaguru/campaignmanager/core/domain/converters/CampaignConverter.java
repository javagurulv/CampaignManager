package lv.javaguru.campaignmanager.core.domain.converters;

import lv.javaguru.campaignmanager.api.dto.campaigns.CampaignDTO;
import lv.javaguru.campaignmanager.core.domain.Campaign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static lv.javaguru.campaignmanager.api.dto.builders.CampaignDTOBuilder.createCampaignDTO;

@Component
public class CampaignConverter {

    @Autowired private CampaignGroupConverter groupConverter;

    public CampaignDTO convert(Campaign campaign) {
        return createCampaignDTO()
                .withId(campaign.getId())
                .withTitle(campaign.getTitle())
                .withState(campaign.getState().toString())
                .with(groupConverter.convert(campaign.getCampaignGroup()))
                .withCreatedDate(campaign.getCreatedDate())
                .withUpdatedDate(campaign.getUpdatedDate())
                .build();
    }

}
