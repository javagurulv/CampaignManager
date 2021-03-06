package lv.javaguru.campaignmanager.core.domain.builders;

import lv.javaguru.campaignmanager.core.vo.GroupTitle;
import lv.javaguru.campaignmanager.core.domain.CampaignGroup;

import java.util.Date;

public class CampaignGroupBuilder {

    private Long id;
    private String title;
    private Date updatedDate;

    private CampaignGroupBuilder() { }

    public static CampaignGroupBuilder createCampaignGroup() {
        return new CampaignGroupBuilder();
    }

    public CampaignGroup build() {
        CampaignGroup campaignGroup = new CampaignGroup();
        campaignGroup.setId(id);
        campaignGroup.setTitle(title);
        campaignGroup.setUpdatedDate(updatedDate);
        return campaignGroup;
    }

    public CampaignGroupBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public CampaignGroupBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public CampaignGroupBuilder with(GroupTitle groupTitle) {
        this.title = groupTitle.get();
        return this;
    }

    public CampaignGroupBuilder withUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
        return this;
    }

}
