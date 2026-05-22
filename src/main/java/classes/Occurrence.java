package classes;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

import java.time.LocalDateTime;

@Entity
@IdClass(OccurrenceId.class)
public class Occurrence {
    @Id
    private String name;
    @Id
    private LocalDateTime date;
    private String description;

    public Occurrence(String name, LocalDateTime date, String description) {
        this.name = name;
        this.date = date;
        this.description = description;
    }

    public Occurrence() {

    }

    public String getName() {
        return name;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }
}

