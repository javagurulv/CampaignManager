package lv.javaguru.campaignmanager.core.domain.repositories;

import lv.javaguru.campaignmanager.core.domain.CampaignGroup;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CampaignGroupRepository extends CrudRepository<CampaignGroup, Long> {

    Optional<CampaignGroup> findByTitle(String title);

}
