package safteynet.apis;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
public class FireController {

    // Simulated data
    private List<Person> personList = new ArrayList<>();

    public FireController() {
        // Initialize simulated data
        personList.add(new Person("John", "Doe", "123 Main St", "555-1234", 30, "Aspirin", "10mg", "None"));
        personList.add(new Person("Jane", "Smith", "123 Main St", "555-5678", 25, "Epinephrine", "15mg", "Peanuts"));
        personList.add(new Person("Michael", "Johnson", "456 Elm St", "555-9876", 40, "Insulin", "5 units", "None"));
        // Add more persons...
    }

    @GetMapping("/fire")
    public List<FireResponse> getFireInfo(@RequestParam String address) {
        List<FireResponse> fireResponses = new ArrayList<>();

        for (Person person : personList) {
            if (person.getAddress().equals(address)) {
                fireResponses.add(new FireResponse(person.getFirstName(), person.getLastName(),
                        person.getPhoneNumber(), person.getAge(), person.getMedication(),
                        person.getDosage(), person.getAllergies(), person.getStationNumber()));
            }
        }

        return fireResponses;
    }
}