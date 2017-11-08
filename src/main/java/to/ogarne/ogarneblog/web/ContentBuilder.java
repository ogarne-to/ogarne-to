package to.ogarne.ogarneblog.web;

import com.vladsch.flexmark.ast.Node;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;


public class ContentBuilder {

    String content = "";

    public ContentBuilder(String content) {
        this.content = content;
    }

    public ContentBuilder limit(int limit) {

        if (content.length() >= limit) {
            content = content.substring(0, limit) + " (...)";
        }
        return this;
    }

    public ContentBuilder parse() {
        Parser parser = Parser.builder().build();
        Node document = parser.parse(this.content);
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        this.content = renderer.render(document);
        return this;
    }

    public PostContent build() {
        return new PostContent(this);
    }

}
