package Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Weather {
    @JsonProperty("time")
    private long time;
    @JsonProperty("wind")
    private long windSpeed;
    @JsonProperty("visibility")
    private long visibility;

    public long getTime() {
        return time;
    }

    public long getWindSpeed() {
        return windSpeed;
    }

    public long getVisibility() {
        return visibility;
    }
}
