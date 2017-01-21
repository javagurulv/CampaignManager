package lv.javaguru.campaignmanager.core.domain.repositories;

import lv.javaguru.campaignmanager.core.domain.Campaign;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CampaignRepository extends CrudRepository<Campaign, Long> {

    Optional<Campaign> findByTitle(String title);

}
