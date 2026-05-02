package classes;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Article {
    @Id
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
