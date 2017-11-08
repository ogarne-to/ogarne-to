package to.ogarne.ogarneblog.dao;

import to.ogarne.ogarneblog.model.User;

/**
 * Created by jedrz on 17.07.2017.
 */
public interface UserDao extends GenericDao<User, Long> {
    User findByUsername(String username);
}
