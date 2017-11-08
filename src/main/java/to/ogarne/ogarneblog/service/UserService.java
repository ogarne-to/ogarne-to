package to.ogarne.ogarneblog.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import to.ogarne.ogarneblog.model.User;

import java.util.List;

/**
 * Created by jedrz on 17.07.2017.
 */
public interface UserService extends UserDetailsService {

    List<User> findAll();
    User findById(Long id);
    void save (User user);
    void delete(User user);
    User findByUsername(String username);
}
