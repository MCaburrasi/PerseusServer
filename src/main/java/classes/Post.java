package classes;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Post {
    @Id
    @GenericGenerator(name = "native_generator", strategy = "native")
    @GeneratedValue(generator = "native_generator")
    private long id;

    private String textContent;

    private String image;

    /*@ManyToOne
    private User idAuthor;

    @ManyToOne
    private Event idEvent;*/

    public Post(String textContent, String image, User idAuthor, Event idEvent) {
        this.textContent = textContent;
        this.image = image;
        //this.idAuthor = idAuthor;
        //this.idEvent = idEvent;
    }

    public Post() {

    }

    public long getId() {
        return id;
    }

    public String getTextContent() {
        return textContent;
    }

    /*public User getIdAuthor() {
        return idAuthor;
    }

    public Event getIdEvent() {
        return idEvent;
    }*/

    @Override
    public String toString() {
        return id + "|" + textContent + "|" + image;
    }
}