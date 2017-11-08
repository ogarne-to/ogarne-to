package to.ogarne.ogarneblog.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import to.ogarne.ogarneblog.service.FileService;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class ContentUtilsImpl implements ContentUtils{

    @Autowired
    FileService fileService;


    @Override
    public Parseable decodeFileIds(Parseable parseable) {

        // decode file ID from the mainImage
        String path = parseable.getMainImage();
        if (path != null && !path.isEmpty() && path.matches("\\/files\\/\\d*")) {
            Long id = Long.valueOf(path.substring(7));
            String filename = fileService.findById(id).getFilename();
            parseable.setMainImage("/files/" + filename);
        }

        // decode file ID from the body
        String[] words = parseable.getBody().split("(?=[\\(\\)])");

        String body = Stream.of(words)
                .map(word -> {
                    if (word.matches("\\(\\/files\\/\\d*")) {
                        return "(/files/" + getFileName(word);
                    } else {
                        return word;
                    }
                }).collect(Collectors.joining());

        parseable.setBody(body);



        return parseable;
    }

    @Override
    public List<String> getImagePaths(Parseable parseable) {
        List<String> paths = new ArrayList<>();
        String body = parseable.getBody();
        Pattern pattern = Pattern.compile("(/files\\/[a-zA-Z0-9//_.]*)");

        Matcher matcher = pattern.matcher(body);

        while (matcher.find()) {
            paths.add(matcher.group(0));
        }

        return paths;
    }

    private String getFileName(String path) {
        Long id = Long.valueOf(path.substring(8));
        return fileService.findById(id).getFilename();
    }
}
