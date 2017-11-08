package to.ogarne.ogarneblog.dao;

import org.springframework.data.domain.Pageable;
import to.ogarne.ogarneblog.model.Post;

import java.util.List;

/**
 * Created by jedrz on 17.07.2017.
 */
public interface PostDao extends GenericDao<Post,Long> {
    List<Post> findLastXPublishedPosts(int numberOfPosts);
    List<Post> findLastXPublishedPosts(Pageable pageable);
    List<Post> findPostsFromCategory(Pageable pageable, Long categoryId );
    Post findBySlug(String slug);
    Long getCount(boolean published, Long categoryId);
    Long saveWithId(Post post);

}
