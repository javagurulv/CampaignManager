package lv.javaguru.campaignmanager.core.database;

import lv.javaguru.campaignmanager.core.domain.Campaign;

import java.util.Optional;

public interface CampaignDAO
        extends CRUDOperationDAO<Campaign, Long> {

    Optional<Campaign> findByTitle(String title);

}
