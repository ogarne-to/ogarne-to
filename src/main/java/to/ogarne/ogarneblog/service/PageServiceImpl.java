package to.ogarne.ogarneblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import to.ogarne.ogarneblog.dao.PageDao;
import to.ogarne.ogarneblog.model.Page;

import java.util.List;


@Service
public class PageServiceImpl implements PageService {

    PageDao pageDao;

    @Autowired
    public void setPageDao(PageDao daoToSet) {
        pageDao = daoToSet;
        pageDao.setClazz(Page.class);
    }

    @Override
    public List<Page> findAll() {
        return pageDao.findAll();
    }

    @Override
    public List<Page> getPagesForMenu() {
        return pageDao.getPagesForMenu();
    }

    @Override
    public List<Page> getPublishedPages() {
        return pageDao.getPublishedPages();
    }

    @Override
    public Page findById(Long id) {
        return pageDao.findById(id);
    }

    @Override
    public Page findBySlug(String slug) {
        return pageDao.findBySlug(slug);
    }

    @Override
    public void save(Page page) {
        pageDao.save(page);
    }

    @Override
    public void delete(Page page) {
        pageDao.delete(page);
    }
}
