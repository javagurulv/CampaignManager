package lv.javaguru.campaignmanager.core.domain.metamodel;

import lv.javaguru.campaignmanager.core.domain.Campaign;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Campaign.class)
public class Campaign_ {

    public static volatile SingularAttribute<Campaign, Long> id;
    public static volatile SingularAttribute<Campaign, String> title;
    public static volatile SingularAttribute<Campaign, String> state;


    public static String id() {
        return id.getName();
    }

    public static String title() {
        return title.getName();
    }

    public static String state() {
        return state.getName();
    }

}
