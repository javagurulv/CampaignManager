package lv.javaguru.campaignmanager.core.domain.builders;

import lv.javaguru.campaignmanager.core.domain.Campaign;
import lv.javaguru.campaignmanager.core.domain.CampaignState;

public class CampaignBuilder {

    private Long id;
    private String title;
    private CampaignState state;


    private CampaignBuilder() { }

    public static CampaignBuilder createCampaign() {
        return new CampaignBuilder();
    }

    public Campaign build() {
        Campaign campaign = new Campaign();
        campaign.setId(id);
        campaign.setTitle(title);
        campaign.setState(state);
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

    public CampaignBuilder withState(CampaignState state) {
        this.state = state;
        return this;
    }

}
