package to.ogarne.ogarneblog.web;

import java.util.List;

public interface ContentUtils {

    Parseable decodeFileIds(Parseable parseable);
    List<String> getImagePaths(Parseable post);

}
