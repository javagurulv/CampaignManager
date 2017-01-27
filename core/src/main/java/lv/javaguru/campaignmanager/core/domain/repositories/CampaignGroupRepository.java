package lv.javaguru.campaignmanager.core.domain.repositories;

import lv.javaguru.campaignmanager.core.domain.CampaignGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface CampaignGroupRepository
        extends JpaRepository<CampaignGroup, Long>,
                JpaSpecificationExecutor {

    Optional<CampaignGroup> findByTitle(String title);

}
