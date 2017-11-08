package to.ogarne.ogarneblog.service;

import org.springframework.data.domain.Pageable;
import to.ogarne.ogarneblog.model.Post;

import java.util.List;

/**
 * Created by jedrz on 17.07.2017.
 */
public interface PostService {

    List<Post> findAll();
    List<Post> findLastXPublishedPosts(int numberOfPosts);
    List<Post> findLastXPublishedPosts(Pageable pageable);
    List<Post> findPostsInCategory(Pageable pageable, Long categoryId);
    Long getCount(boolean published, Long categoryId);
    Post findById(Long id);
    Post findBySlug(String slug);
    void save (Post post);
    Long saveWithId(Post post);
    void delete(Post post);
    Long exists(String slug);
}
