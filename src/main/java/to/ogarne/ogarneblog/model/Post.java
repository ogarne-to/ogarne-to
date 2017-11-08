package to.ogarne.ogarneblog.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
import to.ogarne.ogarneblog.web.Parseable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * Created by jedrz on 16.07.2017.
 */

@Entity
public class Post implements Parseable {


    @Id
    @Column(name = "post_id")
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

    @Transient
    private List<String> imagePaths;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    private User author;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;

    @CreationTimestamp
    @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
    private Date dateCreated;

    @UpdateTimestamp
    private Date dateModified = new Date();

    @Column
    private boolean published;




    public Post() {
    }

    public Post(String title, String body, User author, Category category) {
        this.title = title;
        this.body = body;
        this.author = author;
        this.category = category;

    }

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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }


    public List<String> getImagePaths() {
        return imagePaths;
    }

    public void setImagePaths(List<String> imagePaths) {
        this.imagePaths = imagePaths;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title = '" + title + '\'' +
                ", author = " + author.getFullName() +
                ", category = " + category.getDisplayName() +
                ", dateCreated = " + dateCreated +
                ", dateModified = " + dateModified +
                ", published = " + published +
                '}';
    }

    public Post(String title, String slug, String description, String body, User author, Category category, Date dateCreated, boolean published) {
        this.title = title;
        this.slug = slug;
        this.description = description;
        this.body = body;
        this.author = author;
        this.category = category;
        this.dateCreated = dateCreated;
        this.published = published;
    }
}
