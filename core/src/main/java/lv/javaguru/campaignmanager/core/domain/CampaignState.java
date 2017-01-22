package lv.javaguru.campaignmanager.core.domain;

import static com.google.common.collect.Lists.newArrayList;

public enum CampaignState {

    NOT_ACTIVE {
        @Override
        public boolean isTransitionAllowed(CampaignState newState) {
            return newArrayList(CampaignState.ACTIVE, CampaignState.CLOSED).contains(newState);
        }
    },

    ACTIVE {
        @Override
        public boolean isTransitionAllowed(CampaignState newState) {
            return newArrayList(CampaignState.NOT_ACTIVE).contains(newState);
        }
    },

    CLOSED {
        @Override
        public boolean isTransitionAllowed(CampaignState newState) {
            return false;
        }
    };

    public abstract boolean isTransitionAllowed(CampaignState newState);

}
