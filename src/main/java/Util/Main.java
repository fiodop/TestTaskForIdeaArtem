package Util;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        FlightStatus status = new FlightStatus();
        ArrayList<String> flightsData = status.statusChecker();

        for (int i = 0; i < flightsData.size(); i++){
            System.out.println(flightsData.get(i));
        }
    }
}
