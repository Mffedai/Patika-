import jakarta.persistence.*;

import java.awt.*;
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
    private List<Book> bookList;

    public Category(){
    }
}
