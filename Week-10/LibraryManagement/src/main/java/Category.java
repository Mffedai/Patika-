import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", columnDefinition = "serial")
    private long id;

    @Column(name = "category_name", nullable = false)
    private String name;

    @Column(name = "category_definition", nullable = false)
    private String definiton;

    @ManyToMany(mappedBy = "categoryList")
    private List<Books> booksList;

    public Category(){
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDefiniton() {
        return definiton;
    }

    public void setDefiniton(String definiton) {
        this.definiton = definiton;
    }

    public List<Books> getBooksList() {
        return booksList;
    }

    public void setBooksList(List<Books> booksList) {
        this.booksList = booksList;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", definiton='" + definiton + '\'' +
                '}';
    }
}
