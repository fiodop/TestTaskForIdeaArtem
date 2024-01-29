package Util;

import java.util.HashMap;

public class TimeZoneConverter {
    public long changeTimeZone(String cityFrom, String cityTo, long arrivalTimeWithouthZoneChanging){
        HashMap<String, Integer> timeZones = new HashMap<>();
        timeZones.put("moscow", 3);
        timeZones.put("novosibirsk", 7);
        timeZones.put("omsk", 6);
        long GMTTime = 0;

        GMTTime =arrivalTimeWithouthZoneChanging - timeZones.get(cityFrom);
        long zoneChangedTime = GMTTime + timeZones.get(cityTo);

        if (zoneChangedTime > 24){
            zoneChangedTime %= 24;
        }
        if (zoneChangedTime < 0){
            zoneChangedTime +=24;
        }
        return zoneChangedTime;
    }
}
