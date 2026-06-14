package classes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "user", schema = "perseusdatabase")
public class User {
    @Id
    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "password", length = 50)
    private String password;

    @Column(name = "pfp", length = 150)
    private String pfp;

    @Column(name = "banner", length = 150)
    private String banner;

    @Lob
    @Column(name = "bio")
    private String bio;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
        this.bio = "No bio yet! Click on this text to set your bio!";
    }

    public User() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPfp() {
        return pfp;
    }

    public void setPfp(String pfp) {
        this.pfp = pfp;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @Override
    public String toString() {
        return name + "|" + password + "|" + pfp + "|" + banner + "|" + bio;
    }
}