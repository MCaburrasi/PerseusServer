package classes;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity
public class Event {
    private int id;
    private String title;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endTime;
    private String place;
    private String image;
    @ManyToOne
    private int idAuthor;

    public Event(int id, String title, String description, LocalDateTime startDate, LocalDateTime endTime, String place, String image, int idAuthor) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endTime = endTime;
        this.place = place;
        this.image = image;
        this.idAuthor = idAuthor;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public String getPlace() {
        return place;
    }

    public String getImage() {
        return image;
    }

    public int getIdAuthor() {
        return idAuthor;
    }
}
