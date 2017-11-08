package to.ogarne.ogarneblog.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import to.ogarne.ogarneblog.model.Post;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by jedrz on 17.07.2017.
 */

@Repository
public class PostDaoImpl implements PostDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Post> findAll() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Post> criteria = builder.createQuery(Post.class);
        criteria.from(Post.class);
        List<Post> posts = session.createQuery(criteria).getResultList();
        session.close();

        return posts;
    }

    @Override
    public List<Post> findLastXPublishedPosts(int numberOfPosts) {

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Post> criteria = builder.createQuery(Post.class);
        Root<Post> root =  criteria.from(Post.class);

        // order descending by date
        criteria.where(builder.equal(root.get("published"), true));
        criteria.orderBy(builder.desc(root.get("dateCreated")));

        List<Post> posts = session.createQuery(criteria)
                // limit number of returned posts to @param numberOfPosts
                .setMaxResults(numberOfPosts)
                .getResultList();
        session.close();

        return posts;
    }

    public List<Post> findLastXPublishedPosts(Pageable pageable) {


        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Post> criteria = builder.createQuery(Post.class);
        Root<Post> root =  criteria.from(Post.class);

        // order descending by date
        criteria.where(builder.equal(root.get("published"), true));
        criteria.orderBy(builder.desc(root.get("dateCreated")));

        List<Post> posts = session.createQuery(criteria)
                // limit number of returned posts to @param numberOfPosts
                .setFirstResult(pageable.getOffset())
                .setMaxResults(pageable.getPageSize())
                .getResultList();
        session.close();

        return posts;
    }

    @Override
    public List<Post> findPostsFromCategory(Pageable pageable, Long categoryId) {

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Post> criteria = builder.createQuery(Post.class);
        Root<Post> root =  criteria.from(Post.class);

        // order descending by date
        criteria.where(
                builder.and(
                        builder.equal(root.get("category"), categoryId),
                        builder.isTrue(root.get("published"))
                )
        );
        criteria.orderBy(builder.desc(root.get("dateCreated")));

        List<Post> posts = session.createQuery(criteria)
                // limit number of returned posts to @param numberOfPosts
                .setFirstResult(pageable.getOffset())
                .setMaxResults(pageable.getPageSize())
                .getResultList();
        session.close();

        return posts;
    }


    @Override
    public Post findBySlug(String slug) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Post> criteria = builder.createQuery(Post.class);
        Root<Post> root = criteria.from(Post.class);
        criteria.select(root);
        criteria.where(builder.equal(root.get("slug"), slug));
        Post post = session.createQuery(criteria).getSingleResult();
        session.close();
        return post;
    }

    @Override
    public Long getCount(boolean published, Long categoryId) {

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder= session.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<Post> root = criteria.from(Post.class);
        criteria.select(builder.count(root));
        if (published) {
            criteria.where(builder.isTrue(root.get("published")));
        }

        if (categoryId != null) {
            criteria.where(builder.equal(root.get("category"), categoryId));
        }

        long count = session.createQuery(criteria).getSingleResult();
        session.close();
        return count;

    }


    @Override
    public Post findById(Long id) {
        Session session = sessionFactory.openSession();
        Post post = session.get(Post.class,id);
        session.close();
        return post;
    }

    @Override
    public void save(Post post) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(post);

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Long saveWithId(Post post) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(post);
        session.getTransaction().commit();
        session.close();
        return post.getId();
    }

    @Override
    public void delete(Post post) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(post);
        session.getTransaction().commit();
        session.close();
    }
}
