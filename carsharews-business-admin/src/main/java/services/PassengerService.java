package services;

import message.request.PassengerForm;
import message.request.TravelUpdate;
import message.response.PassagerResponse;
import model.Passager;
import model.Travel;
import model.User;

import java.util.List;
import java.util.Optional;

public interface PassengerService {
    String add(PassengerForm passager, User user);
    void delete(PassengerForm passager, User user);
    List<PassagerResponse> getPassagerByTravel(Travel travel);
    List<PassagerResponse> getPassagerByTravelForm(String travelCode, User user);
    List<PassagerResponse> getAllTravel();
}
