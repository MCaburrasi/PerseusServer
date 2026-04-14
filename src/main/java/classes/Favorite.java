package classes;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Favorite {
    @ManyToOne
    private int idUser;
    @ManyToOne
    private String occurrenceName;
    @ManyToOne
    private String occurrenceDate;

    public Favorite(int idUser, String occurrenceName, String occurrenceDate) {
        this.idUser = idUser;
        this.occurrenceName = occurrenceName;
        this.occurrenceDate = occurrenceDate;
    }

    public int getIdUser() {
        return idUser;
    }

    public String getOccurrenceName() {
        return occurrenceName;
    }

    public String getOccurrenceDate() {
        return occurrenceDate;
    }
}
