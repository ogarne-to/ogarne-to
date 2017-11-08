package to.ogarne.ogarneblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import to.ogarne.ogarneblog.dao.PostDao;
import to.ogarne.ogarneblog.model.Post;
import to.ogarne.ogarneblog.web.MarkdownParser;

import java.util.List;

/**
 * Created by jedrz on 17.07.2017.
 */

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostDao postDao;

    @Autowired
    MarkdownParser markdownParser;

    @Override
    public List<Post> findAll() {
        return postDao.findAll();
    }


    @Override
    public List<Post> findLastXPublishedPosts(int numberOfPosts) {
        return postDao.findLastXPublishedPosts(numberOfPosts);
    }


    public List<Post> findLastXPublishedPosts(Pageable pageable) {
        return postDao.findLastXPublishedPosts(pageable);
    }

    @Override
    public List<Post> findPostsInCategory(Pageable pageable, Long categoryId) {
        return postDao.findPostsFromCategory(pageable, categoryId);
    }

    @Override
    public Long getCount(boolean published, Long categoryId) {

        return postDao.getCount(published, categoryId);
    }

    @Override
    public Post findById(Long id) {
        return postDao.findById(id);
    }

    @Override
    public Post findBySlug(String slug) {
        return postDao.findBySlug(slug);
    }

    @Override
    public void save(Post post) {

        postDao.save(post);

    }

    public Long saveWithId(Post post) {
        return postDao.saveWithId(post);
    }

    @Override
    public void delete(Post post) {
        postDao.delete(post);
    }

    @Override
    public Long exists(String slug) {
        try {
            return postDao.findBySlug(slug).getId();
        } catch (Exception e) {
            e.printStackTrace();
            return -1L;
        }
    }


}
