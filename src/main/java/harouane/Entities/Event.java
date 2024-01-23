package harouane.Entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Event {
    @Id
    @GeneratedValue
    private long id;

    @Column
    String title;
    @Column
    Date date;
    @Column
    String description;

    @Column
    @Enumerated(EnumType.STRING)
    EventType eventType;

    @Column(name="max_number_participants")
    Integer maxNumberParticipants;

    public Event() {
    }

    public Event(String title, Date date, String description, EventType eventType, Integer maxNumberParticipants) {
        this.title = title;
        this.date = date;
        this.description = description;
        this.eventType = eventType;
        this.maxNumberParticipants = maxNumberParticipants;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Event{" +
                "title='" + title + '\'' +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", eventType=" + eventType +
                ", maxNumberParticipants=" + maxNumberParticipants +
                '}';
    }
}
