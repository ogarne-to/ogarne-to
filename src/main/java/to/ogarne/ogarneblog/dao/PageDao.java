package to.ogarne.ogarneblog.dao;

import to.ogarne.ogarneblog.model.Page;

import java.util.List;

public interface PageDao extends ExperimentDao<Page, Long> {
    List<Page> getPagesForMenu();
    List<Page> getPublishedPages();
    Page findBySlug(String slug);
}
