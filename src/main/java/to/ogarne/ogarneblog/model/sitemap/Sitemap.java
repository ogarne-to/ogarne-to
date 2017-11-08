package to.ogarne.ogarneblog.model.sitemap;

import javax.xml.bind.annotation.*;
import java.util.LinkedList;
import java.util.List;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "urlset")
public class Sitemap {
    @XmlElements({@XmlElement(name = "url")})
    private final List<SitemapURL> elements;

    public Sitemap() {
        this(new LinkedList<>());
    }

    public Sitemap(final List<SitemapURL> elements) {
        this.elements = elements;
    }

    public Sitemap addSitemapURL(final SitemapURL element) {
        elements.add(element);
        return this;
    }

    public List<SitemapURL> getUrlSet() {
        return elements;
    }
}
