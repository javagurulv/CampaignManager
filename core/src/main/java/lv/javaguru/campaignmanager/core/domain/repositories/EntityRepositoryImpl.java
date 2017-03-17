package lv.javaguru.campaignmanager.core.domain.repositories;

import lv.javaguru.campaignmanager.core.domain.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

@Component
class EntityRepositoryImpl implements EntityRepository {

    @Autowired private EntityManager entityManager;


    @Override
    public <E extends BaseEntity> E getRequired(Class clazz, Long id) {
        E entity = (E) entityManager.find(clazz, id);
        if (entity == null) {
            throw new IllegalArgumentException(
                    "Entity with id = " + id + " not exist!"
            );
        }
        return entity;
    }

}
