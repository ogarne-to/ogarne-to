package to.ogarne.ogarneblog.model.sitemap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "url")
public class SitemapURL {
    @XmlElement(name = "loc")
    private String location;

    @XmlElement(name = "lastmod")
    private Date lastModified;

    @XmlElement(name = "changefreq")
    private ChangeFrequency changeFrequency;

    @XmlElement(name = "priority")
    private Float priority;

    public SitemapURL()
    {
    }

    public SitemapURL(String location)
    {
        this.location = location;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public Date getLastModified()
    {
        return lastModified;
    }

    public void setLastModified(Date lastModified)
    {
        this.lastModified = lastModified;
    }

    public ChangeFrequency getChangeFrequency()
    {
        return changeFrequency;
    }

    public void setChangeFrequency(ChangeFrequency changeFrequency)
    {
        this.changeFrequency = changeFrequency;
    }

    public Float getPriority()
    {
        return priority;
    }

    public void setPriority(Float priority)
    {
        this.priority = priority;
    }
}
