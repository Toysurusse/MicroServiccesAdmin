package services.mapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import model.City;
import model.Event;
import model.User;
import message.request.EventForm;
import message.response.EventReponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CityRepository;
import repository.TravelRepository;
import repository.UserRepository;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



@Service
public class EventMapper {

    @Autowired
    CityRepository cityRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TravelRepository travelRepository;

    private static final Logger logger = LoggerFactory.getLogger(EventMapper.class);

    public Event eventExpoToData(EventForm eventForm, User user) throws Exception {
        City city = cityRepository.findByCodepostal(eventForm.getCodePostal());
        Event event = new Event();
        try {
            if(cityRepository.findByCodepostal(eventForm.getCodePostal())!=null){
                event = new Event(eventForm.getNameEvent(), eventForm.getVoyage(), eventForm.isActive(),
                        eventForm.isDelete(), eventForm.getType(), user, city, eventForm.getBeginEvent(), eventForm.getEndEvent());
            }
        } catch (Exception e) {
            logger.error("Code commune non valide", e);
        }
        return event;
    }

    public List<EventReponse> eventDataToExpo(List<Event> event){
        List<EventReponse> eventReponses=new ArrayList<>();
        if (event.size()>0){
            for (Event e:event
                    ) {
                eventReponses.add(new EventReponse(e.getVoyage(),e.getType(),e.getNameEvent(), e.isActive(), e.isDelete(), e.getCity(),
                        e.getBeginEvent(), e.getEndEvent(), travelRepository.findAllByEvent(e).size(), userRepository.findByUsername(e.getUser().getUsername()).get().getUsername()));
            }
        }
        return eventReponses;
    }
}
