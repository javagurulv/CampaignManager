package lv.javaguru.campaignmanager.api.dto;

import java.io.Serializable;
import java.util.Date;

public class TaskCampaignDTO implements Serializable {

    private Long id;
    private CampaignDTO campaign;
    private Date createdDate;
    private Date updatedDate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CampaignDTO getCampaign() {
        return campaign;
    }

    public void setCampaign(CampaignDTO campaign) {
        this.campaign = campaign;
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
