package to.ogarne.ogarneblog.service;

import to.ogarne.ogarneblog.model.Category;

import java.util.List;

/**
 * Created by jedrz on 17.07.2017.
 */


public interface CategoryService {

    List<Category> findAll();
    List<Category> getCategoriesForMenu();
    Category findById(Long id);
    Category findByName(String name);
    void save (Category category);
    void saveInBulk(List<Category> categories);
    void delete(Category category);


}
