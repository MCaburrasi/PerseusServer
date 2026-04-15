package classes;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity
public class Event {
    @Id
    private long id;
    private String title;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endTime;
    private String place;
    private String image;
    @ManyToOne
    private User idAuthor;

    public Event(String title, String description, LocalDateTime startDate, LocalDateTime endTime, String place, String image, User idAuthor) {
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endTime = endTime;
        this.place = place;
        this.image = image;
        this.idAuthor = idAuthor;
    }

    public Event() {}

    public long getId() {
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

    public User getIdAuthor() {
        return idAuthor;
    }
}
