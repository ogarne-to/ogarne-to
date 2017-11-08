package to.ogarne.ogarneblog.dao;

import to.ogarne.ogarneblog.model.File;

import java.util.List;

public interface FileDao extends GenericDao<File,Long> {
    public List<File> findAllImages();
}
