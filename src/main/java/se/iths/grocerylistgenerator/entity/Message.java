package se.iths.grocerylistgenerator.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

public class Message implements Serializable {

    private UUID id;
    private String message;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime localDateTime;

    public Message(UUID id, String message, LocalDateTime localDateTime) {
        this.id = id;
        this.message = message;
        this.localDateTime = localDateTime;
    }

    public Message() {
    }

    public UUID getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", localDateTime=" + localDateTime +
                '}';
    }
}
