package safteynet.apis;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonInfoController {

    // Simulated data
    private List<Person> personList = new ArrayList<>();

    public PersonInfoController() {
        // Initialize simulated data
        personList.add(new Person("John", "Doe", "123 Main St", "john@example.com", 30, "Aspirin", "10mg", "None"));
        personList.add(new Person("Jane", "Smith", "456 Elm St", "jane@example.com", 25, "Epinephrine", "15mg", "Peanuts"));
        personList.add(new Person("John", "Johnson", "789 Oak St", "john@example.com", 40, "Insulin", "5 units", "None"));
        // Add more persons...
    }

    @GetMapping("/personInfo")
    public List<PersonInfoResponse> getPersonInfo(@RequestParam String firstName, @RequestParam String lastName) {
        List<PersonInfoResponse> personInfoResponses = new ArrayList<>();

        for (Person person : personList) {
            if (person.getFirstName().equals(firstName) && person.getLastName().equals(lastName)) {
                personInfoResponses.add(new PersonInfoResponse(person.getFirstName(), person.getLastName(),
                        person.getAddress(), person.getAge(), person.getEmail(),
                        person.getMedication(), person.getDosage(), person.getAllergies()));
            }
        }

        return personInfoResponses;
    }
}