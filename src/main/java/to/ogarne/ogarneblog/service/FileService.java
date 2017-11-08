package to.ogarne.ogarneblog.service;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import to.ogarne.ogarneblog.model.File;

import java.util.List;

@Service
public interface FileService {


    File findById(Long id);

    List<File> findAllImages();

    Resource getThumbnail(Long id);

    Resource loadAsResource(String name);

    void save(File file);

    void delete(File file);
}
