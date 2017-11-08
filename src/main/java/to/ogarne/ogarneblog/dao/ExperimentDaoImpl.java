package to.ogarne.ogarneblog.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

public abstract class ExperimentDaoImpl<T, PK extends Serializable> implements GenericDao<T, PK> {

    private Class<T> clazz;

    @Autowired
    SessionFactory sessionFactory;


    @Override
    public List<T> findAll() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery(clazz);
        criteria.from(clazz);
        List<T> objects = session.createQuery(criteria).getResultList();
        session.close();

        return objects;
    }

    @Override
    public T findById(PK id) {
        Session session = sessionFactory.openSession();
        T object = session.get(clazz,id);
        session.close();
        return object;
    }

    @Override
    public void save(T object) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(object);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(T object) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(object);
        session.getTransaction().commit();
        session.close();
    }

    public void setClazz(Class<T> clazz) {
        this.clazz = clazz;
    }
}
