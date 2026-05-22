package classes;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Comment {
    @Id
    @GenericGenerator(name = "native_generator", strategy = "native")
    @GeneratedValue(generator = "native_generator")
    private long id;
    @ManyToOne //Figure it out
    private User idUser;
    @ManyToOne
    private Post idPost;

    private String content;

    private int likes;

    public Comment(User idUser, Post idPost, String content) {
        this.idUser = idUser;
        this.idPost = idPost;
        this.content = content;
        this.likes = 0;
    }

    public Comment() {

    }

    public User getIdUser() {
        return idUser;
    }

    public Post getIdPost() {
        return idPost;
    }

    public String getContent() {
        return content;
    }

    public int getLikes() {
        return likes;
    }
}