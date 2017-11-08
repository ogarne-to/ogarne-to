package to.ogarne.ogarneblog.model;

import to.ogarne.ogarneblog.web.Parseable;
import to.ogarne.ogarneblog.web.validation.NotChildIfInTheMenu;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@NotChildIfInTheMenu
public class Page implements Parseable {


    @Id
    @Column(name = "page_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    @Size(min = 3, max = 300, message = "The size should be between 3 and 300")
    private String title;

    @Column(unique = true)
    @NotNull
    @Pattern(regexp = "^[A-Za-z0-9\\-]*$")
    private String slug;

    @Column
    private String mainImage;

    @Column
    private String caption;

    @Column
    @NotNull
    @Size(min = 3, max = 300)
    private String description;

    @Column(columnDefinition = "text")
    @NotNull
    @Size(min = 3)
    private String body;

    @Column(unique = true)
    private Long menuPosition;

    @Column
    private boolean published;

    @Column
    private Date dateModified = new Date();

    @ManyToOne
    private Page parent;

    @Transient
    private List<String> imagePaths;

    @OneToMany(mappedBy = "parent")
    private Set<Page> childern = new HashSet<>();

    @Transient
    private boolean active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getMenuPosition() {
        return menuPosition;
    }

    public void setMenuPosition(Long menuPosition) {
        this.menuPosition = menuPosition;
    }

    public Page getParent() {
        return parent;
    }

    public void setParent(Page parent) {
        this.parent = parent;
    }

    public Set<Page> getChildern() {
        return childern;
    }

    public void setChildern(Set<Page> childern) {
        this.childern = childern;
    }

    public List<String> getImagePaths() {
        return imagePaths;
    }

    public void setImagePaths(List<String> imagePaths) {
        this.imagePaths = imagePaths;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    @Override
    public String getMainImage() {
        return mainImage;
    }

    @Override
    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public Page() {
    }


    public Page(String title, String slug, String description, String body) {
        this.title = title;
        this.slug = slug;
        this.description = description;
        this.body = body;
    }
}
