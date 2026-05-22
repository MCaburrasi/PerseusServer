package classes;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Opinion {

    @Id
    @GenericGenerator(name = "native_generator", strategy = "native")
    @GeneratedValue(generator = "native_generator")
    private long id;

    @ManyToOne
    private User idUser;
    @ManyToOne
    private Article idArticle;
    private String content;
    private int likes;
    private int line;

    public Opinion(User idUser, Article idArticle, String content, int line) {
        this.idUser = idUser;
        this.idArticle = idArticle;
        this.content = content;
        this.likes = 0;
        this.line = line;
    }

    public Opinion() {

    }

    public User getIdUser() {
        return idUser;
    }

    public Article getIdArticle() {
        return idArticle;
    }

    public String getContent() {
        return content;
    }

    public int getLikes() {
        return likes;
    }

    public int getLine() {
        return line;
    }
}
