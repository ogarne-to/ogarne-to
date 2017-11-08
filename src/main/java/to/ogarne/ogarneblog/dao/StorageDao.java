package to.ogarne.ogarneblog.dao;

import org.springframework.core.io.Resource;
import to.ogarne.ogarneblog.model.File;

import java.io.IOException;
import java.nio.file.Path;

public interface StorageDao {


    void init();

    void store(File file) throws IOException;

    // Stream<Path> loadAll();

    Path load(String filename);

    Resource loadAsResource(String filename);

    void delete(String filename) throws IOException;


}
