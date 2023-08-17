package safteynet.apis;

import java.util.List;

public class FirestationResponse {
    private List<PersonInfo> personInfos;
    private int adultsCount;
    private int childrenCount;

    public FirestationResponse(List<PersonInfo> personInfos, int adultsCount, int childrenCount) {
        this.personInfos = personInfos;
        this.adultsCount = adultsCount;
        this.childrenCount = childrenCount;
    }
}
