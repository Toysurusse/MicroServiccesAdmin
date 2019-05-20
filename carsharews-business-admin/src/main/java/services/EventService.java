package services;

import model.User;
import org.springframework.stereotype.Component;
import message.request.EventForm;
import message.response.EventReponse;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface EventService {
    void add(EventForm event, User user) throws IOException, Exception;
    void deleteactive(EventForm event, User user) throws IOException, Exception;
    void delete(EventForm event, User user) throws IOException, Exception;
    void update(EventForm event, User user) throws Exception;
    List<EventReponse> getEventLimit(Optional<User> user,int begin, int end);
    List<EventReponse> getEventByUser(Optional<User> user);
    boolean getEventByName(String name);
    List<EventReponse> getEventFree();
}
