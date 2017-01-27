package lv.javaguru.campaignmanager.core.domain.builders;

import lv.javaguru.campaignmanager.core.vo.CampaignTitle;
import lv.javaguru.campaignmanager.core.domain.Campaign;
import lv.javaguru.campaignmanager.core.domain.CampaignGroup;
import lv.javaguru.campaignmanager.core.domain.CampaignState;


public class CampaignBuilder {

    private Long id;
    private String title;
    private CampaignState state;
    private CampaignGroup campaignGroup;


    private CampaignBuilder() { }

    public static CampaignBuilder createCampaign() {
        return new CampaignBuilder();
    }

    public Campaign build() {
        Campaign campaign = new Campaign();
        campaign.setId(id);
        campaign.setTitle(title);
        campaign.setState(state);
        campaign.setCampaignGroup(campaignGroup);
        return campaign;
    }

    public CampaignBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public CampaignBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public CampaignBuilder withTitle(CampaignTitle campaignTitle) {
        this.title = campaignTitle.get();
        return this;
    }

    public CampaignBuilder withState(CampaignState state) {
        this.state = state;
        return this;
    }

    public CampaignBuilder with(CampaignGroup campaignGroup) {
        this.campaignGroup = campaignGroup;
        return this;
    }

    public CampaignBuilder with(CampaignGroupBuilder campaignGroupBuilder) {
        this.campaignGroup = campaignGroupBuilder.build();
        return this;
    }

}
