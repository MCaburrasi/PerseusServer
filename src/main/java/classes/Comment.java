package classes;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Comment {
    @ManyToOne
    private int idUser;
    @ManyToOne
    private int idPost;

    private String content;

    private int likes;

    public Comment(int idUser, int idPost, String content, int likes) {
        this.idUser = idUser;
        this.idPost = idPost;
        this.content = content;
        this.likes = likes;
    }

    public int getIdUser() {
        return idUser;
    }

    public int getIdPost() {
        return idPost;
    }

    public String getContent() {
        return content;
    }

    public int getLikes() {
        return likes;
    }
}
