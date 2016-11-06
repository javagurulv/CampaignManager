package lv.javaguru.campaignmanager.integrations.rest.dto.builders;

import lv.javaguru.campaignmanager.integrations.rest.dto.CampaignGroupDTO;

import java.util.Date;

public class CampaignGroupDTOBuilder {

    private Long id;
    private String title;
    private Date createdDate;

    private CampaignGroupDTOBuilder() {}

    public static CampaignGroupDTOBuilder createCampaignGroupDTO() {
        return new CampaignGroupDTOBuilder();
    }

    public CampaignGroupDTO build() {
        CampaignGroupDTO dto = new CampaignGroupDTO();
        dto.setId(id);
        dto.setTitle(title);
        dto.setCreatedDate(createdDate);
        return dto;
    }

    public CampaignGroupDTOBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public CampaignGroupDTOBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public CampaignGroupDTOBuilder withCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

}