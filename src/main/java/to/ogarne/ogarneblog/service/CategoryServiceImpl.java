package to.ogarne.ogarneblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import to.ogarne.ogarneblog.dao.CategoryDao;
import to.ogarne.ogarneblog.model.Category;

import java.util.List;

/**
 * Created by jedrz on 17.07.2017.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryDao categoryDao;

    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public List<Category> getCategoriesForMenu() {
        return categoryDao.getCategoriesForMenu();
    }

    @Override
    public Category findById(Long id) {
        return categoryDao.findById(id);
    }

    @Override
    public Category findByName(String name) {
        return categoryDao.findByName(name);
    }

    @Override
    public void save(Category category) {
        categoryDao.save(category);
    }

    @Override
    public void saveInBulk(List<Category> categories) {
        categoryDao.saveInBulk(categories);
    }

    @Override
    public void delete(Category category) {

        if (category.getPosts().size() > 0) {
            throw new CategoryNotEmptyException();
        }
        categoryDao.delete(category);
    }
}
