package classes;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Post {
    private int id;

    private String textContent;

    @ManyToOne
    private int idAuthor;

    @ManyToOne
    private int idEvent;

    public Post(int id, String textContent, int idAuthor, int idEvent) {
        this.id = id;
        this.textContent = textContent;
        this.idAuthor = idAuthor;
        this.idEvent = idEvent;
    }

    public int getId() {
        return id;
    }

    public String getTextContent() {
        return textContent;
    }

    public int getIdAuthor() {
        return idAuthor;
    }

    public int getIdEvent() {
        return idEvent;
    }
}
