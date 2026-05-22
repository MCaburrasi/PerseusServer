package classes;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "User")
public class User {
    @Id
    @GenericGenerator(name = "native_generator", strategy = "native")
    @GeneratedValue(generator = "native_generator")
    private int id;

    private String name;
    private String password;
    private String pfp;
    private String banner;
    private String bio;

    public User(String name, String password, String mail) {
        this.name = name;
        this.password = password;
    }

    public User() {

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

    public String getPfp() {
        return pfp;
    }

    public String getBanner() {
        return banner;
    }

    public String getBio() {
        return bio;
    }
}
