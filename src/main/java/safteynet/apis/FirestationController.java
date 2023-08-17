package safteynet.apis;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FirestationController {

    // Simulated data
    private List<Person> personList = new ArrayList<>();

    public FirestationController() {
        // Initialize simulated data
        personList.add(new Person("John", "Doe", "123 Main St", "555-1234", 30));
        personList.add(new Person("Jane", "Smith", "456 Elm St", "555-5678", 25));
        personList.add(new Person("Michael", "Johnson", "789 Oak St", "555-9876", 10));
        // Add more persons...
    }

    @GetMapping("/firestation")
    public FirestationResponse getFirestationInfo(@RequestParam int stationNumber) {
        List<PersonInfo> personInfos = new ArrayList<>();
        int adultsCount = 0;
        int childrenCount = 0;

        for (Person person : personList) {
            if (person.getStationNumber() == stationNumber) {
                personInfos.add(new PersonInfo(person.getFirstName(), person.getLastName(),
                        person.getAddress(), person.getPhoneNumber()));

                if (person.getAge() <= 18) {
                    childrenCount++;
                } else {
                    adultsCount++;
                }
            }
        }

        return new FirestationResponse(personInfos, adultsCount, childrenCount);
    }


}
