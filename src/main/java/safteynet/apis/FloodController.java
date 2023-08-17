package safteynet.apis;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
public class FloodController {

    // Simulated data
    private List<Person> personList = new ArrayList<>();

   // public FloodController() {
        // Initialize simulated data
    //    personList.add(new Person("John", "Doe", "123 Main St", "555-1234", 30, "Aspirin", "10mg", "None", 1));
    //    personList.add(new Person("Jane", "Smith", "123 Main St", "555-5678", 25, "Epinephrine", "15mg", "Peanuts", 1));
    //    personList.add(new Person("Michael", "Johnson", "456 Elm St", "555-9876", 40, "Insulin", "5 units", "None", 2));
        // Add more persons...
    //}

    @GetMapping("/flood/stations")
    public Map<String, List<FloodStationResponse>> getFloodStationInfo(@RequestParam List<Integer> stations) {
        Map<String, List<FloodStationResponse>> floodMap = new HashMap<>();

        for (Person person : personList) {
            if (stations.contains(person.getStationNumber())) {
                String address = person.getAddress();
                if (!floodMap.containsKey(address)) {
                    floodMap.put(address, new ArrayList<>());
                }
                floodMap.get(address).add(new FloodStationResponse(person.getFirstName(), person.getLastName(),
                        person.getPhoneNumber(), person.getAge(), person.getMedication(),
                        person.getDosage(), person.getAllergies()));
            }
        }

        return floodMap;
    }
}