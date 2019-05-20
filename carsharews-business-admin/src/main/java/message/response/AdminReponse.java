package message.response;

import java.util.List;

public class AdminReponse {


    private List<EventReponse> eventList;

    private List<TravelReponse> travelReponses;

    private List<PassagerResponse> passagerResponses;

    public AdminReponse(List<EventReponse> eventList, List<TravelReponse> trabelList, List<PassagerResponse> passengerList) {
        this.eventList = eventList;
        travelReponses = trabelList;
        passagerResponses = passengerList;
    }

    public List<EventReponse> getEventList() {
        return eventList;
    }

    public void setEventList(List<EventReponse> eventList) {
        this.eventList = eventList;
    }

    public List<TravelReponse> getTravelReponses() {
        return travelReponses;
    }

    public void setTravelReponses(List<TravelReponse> travelReponses) {
        this.travelReponses = travelReponses;
    }

    public List<PassagerResponse> getPassagerResponses() {
        return passagerResponses;
    }

    public void setPassagerResponses(List<PassagerResponse> passagerResponses) {
        this.passagerResponses = passagerResponses;
    }
}
