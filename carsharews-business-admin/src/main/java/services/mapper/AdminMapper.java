package services.mapper;

import message.response.AdminReponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;
import services.EventService;
import services.PassengerService;
import services.TravelService;


@Service
public class AdminMapper {

    @Autowired
    EventService eventService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TravelService travelService;

    @Autowired
    PassengerService passengerService;

    public AdminReponse adminDataToExpo() {

        return new AdminReponse(eventService.getEventFree(), travelService.getTravelList(), passengerService.getAllTravel());

    }


}
