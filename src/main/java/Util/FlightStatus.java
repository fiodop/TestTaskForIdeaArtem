package Util;

import Model.Json;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;

public class FlightStatus {
    public ArrayList<String> statusChecker(){
        ArrayList<String> flights = new ArrayList<>();
        // Opening JSON file
        String filePath = "./resources/flights_and_forecast.json";
        ObjectMapper objectMapper = new ObjectMapper();

        try{
            //Reading JSON file
            Json json = objectMapper.readValue(new File(filePath), Json.class);
            for (int i = 0; i < json.flights.size(); i++){
                //Getting data from flights_and_forecast.json
                String status = "Отменен";
                String flightNumber = json.flights.get(i).getFlightNumber();
                String from = json.flights.get(i).getFrom();
                String to = json.flights.get(i).getTo();
                long departure = json.flights.get(i).getDeparture();

                //Calculating arrival time with time zones
                long arrivalTimeWithouthZoneChanging = departure + json.flights.get(i).getDuration();
                TimeZoneConverter timeZoneConverter = new TimeZoneConverter();
                long arrivalTime = timeZoneConverter.changeTimeZone(from, to, arrivalTimeWithouthZoneChanging);

                long departureWindSpeed = json.forecast.get(from).get((int) departure).getWindSpeed();
                long depatureVisibility = json.forecast.get(from).get((int) departure).getVisibility();
                long arrivalWindSpeed = json.forecast.get(to).get((int) arrivalTime).getWindSpeed();
                long arrivalVisibility = json.forecast.get(to).get((int) arrivalTime).getVisibility();

                //Getting flight status
                if (departureWindSpeed <= 30 && depatureVisibility >= 200){
                    if (arrivalWindSpeed < 30 && arrivalVisibility >= 200){
                        status = "по расписанию";
                    }
                }
                //Writing information about flight in list
                String flightData = flightNumber + " | " + from + " -> " + to + " | " + status;
                flights.add(flightData);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return flights;
    }
}
