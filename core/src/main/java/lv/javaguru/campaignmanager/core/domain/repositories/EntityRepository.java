package lv.javaguru.campaignmanager.core.domain.repositories;

import lv.javaguru.campaignmanager.core.domain.BaseEntity;

public interface EntityRepository {

    <E extends BaseEntity> E getRequired(Class clazz, Long id);

}
