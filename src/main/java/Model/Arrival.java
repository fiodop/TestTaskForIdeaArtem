package Model;

import com.fasterxml.jackson.annotation.JsonProperty;
//Json model
public class Arrival {
    @JsonProperty("no")
    private String flightNumber;
    @JsonProperty("departure")
    private long departure;
    @JsonProperty("from")
    private String from;
    @JsonProperty("to")
    private String to;
    @JsonProperty("duration")
    private long duration;

    public String getFlightNumber() {
        return flightNumber;
    }

    public long getDeparture() {
        return departure;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public long getDuration() {
        return duration;
    }
}
