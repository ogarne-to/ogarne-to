package to.ogarne.ogarneblog.service.tools;

import org.springframework.stereotype.Service;
import to.ogarne.ogarneblog.model.File;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.ByteArrayOutputStream;

/**
 * Uses the built-in JDK tooling for resizing an image.
 *
 * @author Jon Brisbin, modified by Jędrzej K.
 */


@Service
class BufferedImageThumbnailerImpl implements BufferedImageThumbnailer{

    private static final ImageObserver DUMMY_OBSERVER = (img, infoflags, x, y, width, height) -> true;

    @Override
    public void convertToThumbnail(File file, int maxLongSide) {
        try {


            String format = file.getContentType().substring(6);


            BufferedImage imgIn = ImageIO.read(file.getInputStream());

            double scale;
            if (imgIn.getWidth() >= imgIn.getHeight()) {
                // horizontal or square image
                scale = Math.min(maxLongSide, imgIn.getWidth()) / (double) imgIn.getWidth();
            } else {
                // vertical image
                scale = Math.min(maxLongSide, imgIn.getHeight()) / (double) imgIn.getHeight();
            }

            BufferedImage thumbnailOut = new BufferedImage((int) (scale * imgIn.getWidth()),
                    (int) (scale * imgIn.getHeight()),
                    imgIn.getType());
            Graphics2D g = thumbnailOut.createGraphics();

            AffineTransform transform = AffineTransform.getScaleInstance(scale, scale);
            g.drawImage(imgIn, transform, DUMMY_OBSERVER);



            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(thumbnailOut, format, baos);
            baos.flush();
            file.setBytes(baos.toByteArray());


        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }

}
