package classes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "post", schema = "perseusdatabase")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "textContent")
    private String textContent;

    @Column(name = "image", length = 150)
    private String image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAuthor")
    private User idAuthor;

    public Post(String textContent, String image, User idAuthor) {
        this.textContent = textContent;
        this.image = image;
        this.idAuthor = idAuthor;
    }

    public Post() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public User getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(User idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String toString(){
        String auth = null;
        if (idAuthor != null){
            auth = idAuthor.getName();
        }
        return id + "|" + textContent + "|" + image + "|" + auth;
    }
}