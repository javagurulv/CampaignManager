package lv.javaguru.campaignmanager.core.domain.repositories;

import lv.javaguru.campaignmanager.core.domain.TaskCampaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TaskCampaignRepository
        extends JpaRepository<TaskCampaign, Long>,
                JpaSpecificationExecutor {


}
