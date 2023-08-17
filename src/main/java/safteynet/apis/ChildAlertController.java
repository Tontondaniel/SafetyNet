package safteynet.apis;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ChildAlertController {

    // Simulated data
    private List<Person> personList = new ArrayList<>();

    public ChildAlertController() {
        // Initialize simulated data
        personList.add(new Person("John", "Doe", "123 Main St", "555-1234", 30));
        personList.add(new Person("Jane", "Smith", "123 Main St", "555-5678", 25));
        personList.add(new Person("Michael", "Johnson", "456 Elm St", "555-9876", 10));
        personList.add(new Person("Sarah", "Johnson", "456 Elm St", "555-4321", 8));
        // Add more persons...
    }

    @GetMapping("/childAlert")
    public List<ChildAlertResponse> getChildAlert(@RequestParam String address) {
        List<ChildAlertResponse> childAlertResponses = new ArrayList<>();

        for (Person person : personList) {
            if (person.getAddress().equals(address) && person.getAge() <= 18) {
                List<String> otherFamilyMembers = new ArrayList<>();
                for (Person familyMember : personList) {
                    if (familyMember.getAddress().equals(address) && !familyMember.getFirstName().equals(person.getFirstName())) {
                        otherFamilyMembers.add(familyMember.getFirstName() + " " + familyMember.getLastName());
                    }
                }
                childAlertResponses.add(new ChildAlertResponse(person.getFirstName(), person.getLastName(),
                        person.getAge(), otherFamilyMembers));
            }
        }

        return childAlertResponses;
    }
}