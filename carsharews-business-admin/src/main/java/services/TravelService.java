package services;

import message.request.TravelForm;
import message.request.TravelUpdate;
import message.response.TravelReponse;
import model.Travel;
import model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface TravelService {

    void add(TravelForm event, User user);
    void deleteactive(TravelUpdate event, User user);
    void update(TravelForm event, User user);
    List<TravelReponse> getTravelLimit(String eventName, int begin, int end);
    List<TravelReponse> getTravelByUser(Optional<User> user);
    List<TravelReponse> getTravelByEvent(String eventName);
    List<TravelReponse> getTravelList();
    Travel getTravelByCode(String codeName);
}
