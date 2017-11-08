package to.ogarne.ogarneblog.web;

/**
 * Created by jedrz on 18.07.2017.
 */
public interface MarkdownParser {

    public Parseable parse(Parseable parseable);
    public Parseable cutHiddenChars(Parseable parseable);
    public String getPlainText(Parseable parseable, int limit);
    public Parseable limit(Parseable parseable);
}
