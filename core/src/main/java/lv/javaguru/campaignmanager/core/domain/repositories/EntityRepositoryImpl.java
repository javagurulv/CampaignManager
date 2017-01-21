package lv.javaguru.campaignmanager.core.domain.repositories;

import lv.javaguru.campaignmanager.core.domain.BaseEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class EntityRepositoryImpl implements EntityRepository {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public <E extends BaseEntity> E getRequired(Class clazz, Long id) {
        E entity = (E) getCurrentSession().get(clazz, id);
        if (entity == null) {
            throw new IllegalArgumentException(
                    "Entity with id = " + id + " not exist!"
            );
        }
        return entity;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

}
