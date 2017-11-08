package to.ogarne.ogarneblog.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import to.ogarne.ogarneblog.model.File;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class FileDaoImpl implements FileDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<File> findAll() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<File> criteria = builder.createQuery(File.class);
        criteria.from(File.class);
        List<File> files = session.createQuery(criteria).getResultList();
        session.close();

        return files;
    }

    @Override
    public File findById(Long id) {
        Session session = sessionFactory.openSession();
        File file = session.get(File.class, id);
        session.close();
        return file;
    }

    @Override
    public void save(File file) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(file);
        session.getTransaction().commit();
        session.close();



    }

    @Override
    public void delete(File file) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(file);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<File> findAllImages() {

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<File> criteria = builder.createQuery(File.class);
        Root root = criteria.from(File.class);
        criteria.where(builder.like(root.get("contentType"), "%image%"));
        List<File> files = session.createQuery(criteria).getResultList();
        session.close();

        return files;
    }
}
