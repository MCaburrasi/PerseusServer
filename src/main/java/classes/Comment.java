package classes;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Comment {
    @ManyToOne
    @Id //Figure it out
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
