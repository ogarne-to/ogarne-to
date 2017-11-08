package to.ogarne.ogarneblog.service.tools;

import to.ogarne.ogarneblog.model.File;

public interface BufferedImageThumbnailer {
    void convertToThumbnail(File file, int size);
}
