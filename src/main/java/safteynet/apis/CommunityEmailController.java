package safteynet.apis;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
public class CommunityEmailController {

    // Simulated data
    private List<Person> personList = new ArrayList<>();

    public CommunityEmailController() {
        // Initialize simulated data
        personList.add(new Person("John", "Doe", "123 Main St", "john@example.com", 30));
        personList.add(new Person("Jane", "Smith", "456 Elm St", "jane@example.com", 25));
        personList.add(new Person("Michael", "Johnson", "789 Oak St", "michael@example.com", 40));
        // Add more persons...
    }

    @GetMapping("/communityEmail")
    public List<String> getCommunityEmails(@RequestParam String city) {
        List<String> communityEmails = new ArrayList<>();

        for (Person person : personList) {
            if (person.getCity().equalsIgnoreCase(city)) {
                communityEmails.add(person.getEmail());
            }
        }

        return communityEmails;
    }

}