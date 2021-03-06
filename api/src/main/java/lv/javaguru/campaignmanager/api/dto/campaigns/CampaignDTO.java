package lv.javaguru.campaignmanager.api.dto.campaigns;

import lv.javaguru.campaignmanager.api.dto.groups.CampaignGroupDTO;

import java.io.Serializable;
import java.util.Date;

public class CampaignDTO implements Serializable {

    private Long id;
    private String title;
    private String state;
    private CampaignGroupDTO campaignGroupDTO;
    private Date createdDate;
    private Date updatedDate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public CampaignGroupDTO getCampaignGroupDTO() {
        return campaignGroupDTO;
    }

    public void setCampaignGroupDTO(CampaignGroupDTO campaignGroupDTO) {
        this.campaignGroupDTO = campaignGroupDTO;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

}
