package classes;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "User")
public class User {
    @Id
    private int id;

    private String name;
    private String password;
    private String mail;
    private String pfp;
    private String banner;
    private String text;

    public User(int id, String name, String password, String mail, String pfp, String banner, String text) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.mail = mail;
        this.pfp = pfp;
        this.banner = banner;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getMail() {
        return mail;
    }

    public String getPfp() {
        return pfp;
    }

    public String getBanner() {
        return banner;
    }

    public String getText() {
        return text;
    }
}
