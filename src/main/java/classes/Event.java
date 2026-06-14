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

import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Table(name = "event", schema = "perseusdatabase")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "title", length = 50)
    private String title;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "startDate")
    private LocalDateTime startDate;

    @Column(name = "endTime")
    private LocalDateTime endTime;

    @Column(name = "place", length = 100)
    private String place;

    @Column(name = "image", length = 150)
    private String image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAuthor")
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

    public Event() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
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

    @Override
    public String toString() {
        return id + "|" + title + "|" + description + "|" + startDate + "|" + endTime + "|" + place + "|" + image + "|" + idAuthor.getName();
    }
}