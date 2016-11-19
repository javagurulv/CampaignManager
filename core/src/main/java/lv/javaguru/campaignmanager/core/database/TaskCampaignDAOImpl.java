package lv.javaguru.campaignmanager.core.database;

import lv.javaguru.campaignmanager.core.domain.TaskCampaign;
import org.springframework.stereotype.Component;

@Component
class TaskCampaignDAOImpl
        extends CRUDOperationDAOImpl<TaskCampaign, Long>
        implements TaskCampaignDAO {


}
