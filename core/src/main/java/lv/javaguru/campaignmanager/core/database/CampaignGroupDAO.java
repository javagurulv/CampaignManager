package lv.javaguru.campaignmanager.core.database;

import lv.javaguru.campaignmanager.core.domain.CampaignGroup;

import java.util.Optional;

public interface CampaignGroupDAO
        extends CRUDOperationDAO<CampaignGroup, Long>{

    Optional<CampaignGroup> findByTitle(String title);

}
