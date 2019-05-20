package services;

import model.Event;
import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import repository.EventRepository;
import message.request.EventForm;
import message.response.EventReponse;
import services.mapper.EventMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    EventMapper eventMapper;

    @Autowired
    EventRepository eventRepository;

    private static final Logger logger = LoggerFactory.getLogger(EventService.class);

    @Override
    public void add(EventForm event, User user) throws Exception {
        try {
            if (eventMapper.eventExpoToData(event, user).getNameEvent()!=null){
                Event eventData = eventMapper.eventExpoToData(event, user);
                eventRepository.save(eventData);
            }
        } catch (Exception e) {
            logger.error("Ce code commune n'existe pas", e);
        }
    }

    @Override
    public void deleteactive(EventForm event, User user) throws Exception {
        Event e = eventMapper.eventExpoToData(event, user);
        e.setEvent_id(eventRepository.findByNameEvent(event.getNameEvent()).getEvent_id());
        e.setCreatedAt(eventRepository.findByNameEvent(event.getNameEvent()).getCreatedAt());
        eventRepository.save(e);}

    @Override
    public void delete(EventForm event, User user) throws Exception { 
        Event e = eventMapper.eventExpoToData(event, user);
        e.setEvent_id(eventRepository.findByNameEvent(event.getNameEvent()).getEvent_id());
        e.setCreatedAt(eventRepository.findByNameEvent(event.getNameEvent()).getCreatedAt());
        eventRepository.save(e);}

    @Override
    public void update(EventForm event, User user) throws Exception { eventRepository.save(eventMapper.eventExpoToData(event, user));}

    @Override
    public List<EventReponse> getEventLimit(Optional<User> user,int begin, int end){
        List<EventReponse> eventReponse = new ArrayList<>();
        List<EventReponse> eventList = new ArrayList<>();
        eventList = eventMapper.eventDataToExpo(eventRepository.findAll());
        int i = 0;
        for (EventReponse e:eventList
                ) {
            if (i>=begin && i<=end){
                eventReponse.add(e);
            }
            i++;
        }
        return eventReponse;
    }

    @Override
    public List<EventReponse> getEventByUser(Optional<User> user) {
        List<EventReponse> eventReponse = new ArrayList<>();
        List<EventReponse> eventList = new ArrayList<>();
        eventList = eventMapper.eventDataToExpo(eventRepository.findAllByUser(user));
        for (EventReponse e:eventList) {
                eventReponse.add(e);
        }
        return eventReponse;
    }

    @Override
    public List<EventReponse> getEventFree() {
        List<EventReponse> eventReponse = new ArrayList<>();
        List<EventReponse> eventList = new ArrayList<>();
        eventList = eventMapper.eventDataToExpo(eventRepository.findAll());
        for (EventReponse e:eventList) {
                eventReponse.add(e);
        }
        return eventReponse;
    }

    @Override
    public boolean getEventByName(String name){
        if(eventRepository.findByNameEvent(name)==null){
            return true;
        }
        return false;
    }
}
