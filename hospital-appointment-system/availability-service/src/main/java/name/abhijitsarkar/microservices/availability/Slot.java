package name.abhijitsarkar.microservices.availability;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

public class Slot {
    private final int id;
    private final LocalDateTime startDateTime;
    private final LocalDateTime endDateTime;
    private final String doctorId;

    private Slot(Slot other) {
	this(other.id, other.startDateTime, other.endDateTime, other.doctorId);
    }

    private Slot(int id, LocalDateTime startDateTime,
	    LocalDateTime endDateTime, String doctorId) {
	this.id = id;
	this.startDateTime = startDateTime;
	this.endDateTime = endDateTime;
	this.doctorId = doctorId;
    }

    public static Slot from(Slot s) {
	return new Slot(s);
    }

    @JsonCreator
    public static Slot of(
	    @JsonProperty("id") int id,
	    @JsonProperty("startDateTime") @JsonSerialize(using = LocalDateTimeSerializer.class) @JsonDeserialize(using = LocalDateTimeDeserializer.class) LocalDateTime startDateTime,
	    @JsonProperty("endDateTime") @JsonSerialize(using = LocalDateTimeSerializer.class) @JsonDeserialize(using = LocalDateTimeDeserializer.class) LocalDateTime endDateTime,
	    @JsonProperty("doctorId") String doctorId) {
	return new Slot(id, startDateTime, endDateTime, doctorId);
    }

    public int getId() {
	return id;
    }

    public LocalDateTime getStartDateTime() {
	return startDateTime;
    }

    public LocalDateTime getEndDateTime() {
	return endDateTime;
    }

    public String getDoctorId() {
	return doctorId;
    }

    @Override
    public String toString() {
	return "Slot [startDateTime="
		+ ISO_LOCAL_DATE_TIME.format(startDateTime) + ", endDateTime="
		+ ISO_LOCAL_DATE_TIME.format(endDateTime) + ", doctorId="
		+ doctorId + "]";
    }
}
