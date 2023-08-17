package safteynet.apis;

public class ChildAlertResponse {
    private String firstName;
    private String lastName;
    private int age;
    private List<String> otherFamilyMembers;

    public ChildAlertResponse(String firstName, String lastName, int age, List<String> otherFamilyMembers) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.otherFamilyMembers = otherFamilyMembers;
    }

}