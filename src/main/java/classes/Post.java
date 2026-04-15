package classes;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Post {
    @Id
    private long id;

    private String textContent;

    private String image;

    @ManyToOne
    private User idAuthor;

    @ManyToOne
    private Event idEvent;

    public Post(String textContent, User idAuthor, Event idEvent) {
        this.textContent = textContent;
        this.idAuthor = idAuthor;
        this.idEvent = idEvent;
    }

    public Post() {

    }

    public long getId() {
        return id;
    }

    public String getTextContent() {
        return textContent;
    }

    public User getIdAuthor() {
        return idAuthor;
    }

    public Event getIdEvent() {
        return idEvent;
    }
}
