package lv.javaguru.campaignmanager.core.domain.builders;

import lv.javaguru.campaignmanager.core.domain.CampaignGroup;

public class CampaignGroupBuilder {

    private Long id;
    private String title;

    private CampaignGroupBuilder() {}

    public static CampaignGroupBuilder createCampaignGroup() {
        return new CampaignGroupBuilder();
    }

    public CampaignGroup build() {
        CampaignGroup campaignGroup = new CampaignGroup();
        campaignGroup.setId(id);
        campaignGroup.setTitle(title);
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

}
