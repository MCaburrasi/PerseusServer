package classes;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Entity
@IdClass(FavoriteId.class)
public class Favorite implements Serializable {
    @Id
    @ManyToOne
    private User idUser;
    @Id
    private String occurrenceName;
    @Id
    private String occurrenceDate;

    public Favorite(User idUser, String occurrenceName, String occurrenceDate) {
        this.idUser = idUser;
        this.occurrenceName = occurrenceName;
        this.occurrenceDate = occurrenceDate;
    }

    public Favorite() {

    }

    public User getIdUser() {
        return idUser;
    }

    public String getOccurrenceName() {
        return occurrenceName;
    }

    public String getOccurrenceDate() {
        return occurrenceDate;
    }
}

