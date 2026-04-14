package classes;

import jakarta.persistence.ManyToOne;

public class Article {
    private int id;
    private String doc;
    @ManyToOne
    private String idAgency;
}
