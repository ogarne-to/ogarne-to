package to.ogarne.ogarneblog.service;

import to.ogarne.ogarneblog.model.Page;

import java.util.List;

public interface PageService {

    List<Page> findAll();
    List<Page> getPagesForMenu();
    List<Page> getPublishedPages();
    Page findById(Long id);
    Page findBySlug(String slug);
    void save (Page page);
    void delete(Page page);
}
