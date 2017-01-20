package lv.javaguru.campaignmanager.core.domain.metamodel;

import lv.javaguru.campaignmanager.core.domain.CampaignGroup;
import lv.javaguru.campaignmanager.core.domain.TaskCampaign;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CampaignGroup.class)
public class TaskCampaignAttributes {

    public static volatile SingularAttribute<TaskCampaign, Long> id;
    public static volatile SingularAttribute<TaskCampaign, String> campaign;

    public static String id() {
        return id.getName();
    }

    public static String campaign() {
        return campaign.getName();
    }

}
