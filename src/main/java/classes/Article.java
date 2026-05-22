package classes;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Article {
    @Id
    @GenericGenerator(name = "native_generator", strategy = "native")
    @GeneratedValue(generator = "native_generator")
    private int id;
    private String doc;
    @ManyToOne
    private Agency idAgency;

    public Article(int id, String doc, Agency idAgency) {
        this.id = id;
        this.doc = doc;
        this.idAgency = idAgency;
    }

    public Article() {

    }
}
