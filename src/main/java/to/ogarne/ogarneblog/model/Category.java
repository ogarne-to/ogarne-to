package to.ogarne.ogarneblog.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * Created by jedrz on 17.07.2017.
 */
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    @Pattern(regexp = "^[A-Za-z0-9\\-]*$", message = "W ścieżce użyto niewłaściwych znaków. Dozwolone tylko a-z oraz myślnik")
    @Size(min = 2, max = 30)
    private String name;

    @Column(unique = true)
    @NotNull
    @Size(min = 2, max = 30)
    private String displayName;

    @Column(unique = true)
    private Long positionInMenu;

    @Column
    @OneToMany(mappedBy = "category")
    private Set<Post> posts;



    public Category() {
    }


    public Category(String name, String displayName) {
        this.name = name;
        this.displayName = displayName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Long getPositionInMenu() {
        return positionInMenu;
    }

    public void setPositionInMenu(Long positionInMenu) {
        this.positionInMenu = positionInMenu;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", posts=" + posts +
                '}';
    }
}
