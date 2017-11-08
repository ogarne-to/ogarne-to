package to.ogarne.ogarneblog.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Repository;
import to.ogarne.ogarneblog.model.File;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@Repository
public class StorageDaoImpl implements StorageDao {


    @Value("${storage.upload.root}")
    private Path rootLocation;


    @Override
    public void store(File file) throws IOException {

        // Calculates filename of the file (date in millis + original file name);
        String filename = file.getFilename();

            if (file.isEmpty()) {
                throw new StorageException("Failed to store empty file " + filename);
            }
            if (filename.contains("..")) {
                // This is a security check
                throw new StorageException(
                        "Cannot store file with relative path outside current directory "
                                + filename);
            }


            Path targetPath = this.rootLocation.resolve(filename);

            // Throws IOException
        byte[] ba = file.getBytes();
        ByteArrayInputStream bais = new ByteArrayInputStream(ba);
            Files.copy(file.getInputStream(), targetPath,
                    StandardCopyOption.REPLACE_EXISTING);

    }

    // @Override
    // public Stream<Path> loadAll() {
    //     try {
    //         return Files.walk(this.rootLocation, 1)
    //                 .filter(path -> !path.equals(this.rootLocation))
    //                 .map(path -> this.rootLocation.relativize(path));
    //     }
    //     catch (IOException e) {
    //         throw new StorageException("Failed to read stored files", e);
    //     }
    //
    // }

    @Override
    public Path load(String filename) {
        return rootLocation.resolve(filename);
    }

    @Override
    public Resource loadAsResource(String filename) {
        try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            }
            else {
                throw new StorageFileNotFoundException(
                        "Could not read file: " + filename);

            }
        }
        catch (MalformedURLException e) {
            throw new StorageFileNotFoundException("Could not read file: " + filename, e);
        }
    }

    @Override
    public void delete(String filename) throws IOException {
        try {
            Files.delete(load(filename));
        } catch (IOException e) {
            throw new IOException("Could not read file: " + filename, e);
        }
    }

    @Override
    public void init() {
        try {
            Files.createDirectories(rootLocation);
        }
        catch (IOException e) {
            throw new StorageException("Could not initialize storage", e);
        }
    }


}
