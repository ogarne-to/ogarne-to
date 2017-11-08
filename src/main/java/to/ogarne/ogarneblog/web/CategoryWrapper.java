package to.ogarne.ogarneblog.web;

import to.ogarne.ogarneblog.model.Category;

import java.util.List;

public class CategoryWrapper {

    private List<Category> categories;

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
