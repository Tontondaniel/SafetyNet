package safteynet.apis;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PhoneAlertController {

    // Simulated data
    private List<Person> personList = new ArrayList<>();

    public PhoneAlertController() {
        // Initialize simulated data
        personList.add(new Person("John", "Doe", "123 Main St", "555-1234", 1));
        personList.add(new Person("Jane", "Smith", "456 Elm St", "555-5678", 2));
        personList.add(new Person("Michael", "Johnson", "789 Oak St", "555-9876", 1));
        // Add more persons...
    }

    @GetMapping("/phoneAlert")
    public List<String> getPhoneAlert(@RequestParam int firestation) {
        List<String> phoneNumbers = new ArrayList<>();

        for (Person person : personList) {
            if (person.getStationNumber() == firestation) {
                phoneNumbers.add(person.getPhoneNumber());
            }
        }

        return phoneNumbers;
    }
}