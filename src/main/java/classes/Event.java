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

    @Override
    public String toString() {
        return id + "|" + title + "|" + description + "|" + startDate + "|" + endTime + "|" + place + "|" + image + "|" + idAuthor.getName();
    }
}