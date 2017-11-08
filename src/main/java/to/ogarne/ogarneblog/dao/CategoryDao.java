package to.ogarne.ogarneblog.dao;

import to.ogarne.ogarneblog.model.Category;

import java.util.List;

/**
 * Created by jedrz on 17.07.2017.
 */
public interface CategoryDao extends GenericDao<Category, Long> {
    void saveInBulk(List<Category> categories);
    List<Category> getCategoriesForMenu();
    Category findByName(String name);


}
