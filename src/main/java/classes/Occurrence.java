package classes;

import jakarta.persistence.Entity;

import java.time.LocalDateTime;

@Entity
public class Occurrence {
    private String name;
    private LocalDateTime date;
    private String description;

    public Occurrence(String name, LocalDateTime date, String description) {
        this.name = name;
        this.date = date;
        this.description = description;
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
