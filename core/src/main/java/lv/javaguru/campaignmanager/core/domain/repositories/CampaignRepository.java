package lv.javaguru.campaignmanager.core.domain.repositories;

import lv.javaguru.campaignmanager.core.domain.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface CampaignRepository
        extends JpaRepository<Campaign, Long>,
                JpaSpecificationExecutor {

    Optional<Campaign> findByTitle(String title);

}
