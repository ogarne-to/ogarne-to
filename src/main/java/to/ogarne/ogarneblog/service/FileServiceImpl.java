package to.ogarne.ogarneblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import to.ogarne.ogarneblog.dao.FileDao;
import to.ogarne.ogarneblog.dao.StorageDao;
import to.ogarne.ogarneblog.model.File;
import to.ogarne.ogarneblog.service.tools.BufferedImageThumbnailer;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    FileDao fileDao;

    @Autowired
    StorageDao storageDao;

    @Autowired
    BufferedImageThumbnailer thumbnailer;

    @Override
    public File findById(Long id) {
        return fileDao.findById(id);
    }

    @Override
    public List<File> findAllImages() {
        return fileDao.findAllImages();
    }

    @Override
    public Resource getThumbnail(Long id) {
        return null;
    }

    @Override
    public Resource loadAsResource(String name) {
        return storageDao.loadAsResource(name);
    }



    @Override
    public void save(File file) {

        try {
            // Create filename
            String filename = String.valueOf(new Date().getTime()) + "_" + StringUtils.cleanPath(file.getFilename());


            file.setFilename(filename);
            storageDao.store(file);
            fileDao.save(file);


            if (file.getContentType().contains("image")) {
                thumbnailer.convertToThumbnail(file, 250);
                String name = ("thumb_" + file.getFilename());
                file.setFilename(name);
                storageDao.store(file);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void delete(File file) {
        try {
            storageDao.delete(file.getFilename());
            storageDao.delete("thumb_" + file.getFilename());
            fileDao.delete(file);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
