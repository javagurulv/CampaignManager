package lv.javaguru.campaignmanager.core.domain.converters;

import lv.javaguru.campaignmanager.api.dto.CampaignGroupDTO;
import lv.javaguru.campaignmanager.core.domain.CampaignGroup;
import org.springframework.stereotype.Component;

import static lv.javaguru.campaignmanager.api.dto.builders.CampaignGroupDTOBuilder.createCampaignGroupDTO;

@Component
public class CampaignGroupConverter {

    public CampaignGroupDTO convert(CampaignGroup campaignGroup) {
        return createCampaignGroupDTO()
                .withId(campaignGroup.getId())
                .withTitle(campaignGroup.getTitle())
                .withCreatedDate(campaignGroup.getCreatedDate())
                .withUpdatedDate(campaignGroup.getUpdatedDate())
                .build();
    }

}
