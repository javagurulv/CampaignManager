package lv.javaguru.campaignmanager.api.dto.builders;

import lv.javaguru.campaignmanager.api.dto.campaigns.CampaignDTO;
import lv.javaguru.campaignmanager.api.dto.groups.CampaignGroupDTO;

import java.util.Date;

public class CampaignDTOBuilder {

    private Long id;
    private String title;
    private String state;
    private CampaignGroupDTO campaignGroupDTO;
    private Date createdDate;
    private Date updatedDate;

    private CampaignDTOBuilder() { }

    public static CampaignDTOBuilder createCampaignDTO() {
        return new CampaignDTOBuilder();
    }

    public CampaignDTO build() {
        CampaignDTO dto = new CampaignDTO();
        dto.setId(id);
        dto.setTitle(title);
        dto.setState(state);
        dto.setCampaignGroupDTO(campaignGroupDTO);
        dto.setCreatedDate(createdDate);
        dto.setUpdatedDate(updatedDate);
        return dto;
    }

    public CampaignDTOBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public CampaignDTOBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public CampaignDTOBuilder withState(String state) {
        this.state = state;
        return this;
    }

    public CampaignDTOBuilder with(CampaignGroupDTO campaignGroupDTO) {
        this.campaignGroupDTO = campaignGroupDTO;
        return this;
    }

    public CampaignDTOBuilder withCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public CampaignDTOBuilder withUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
        return this;
    }

}
