package lv.javaguru.campaignmanager.integrations.rest.dto;

import java.io.Serializable;
import java.util.Date;

public class CampaignGroupDTO implements Serializable {

    private Long id;
    private String title;
    private Date createdDate;


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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

}
