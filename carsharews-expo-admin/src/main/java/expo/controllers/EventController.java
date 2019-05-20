package expo.controllers;

import expo.security.jwt.JwtProvider;
import message.request.EventForm;
import message.response.ResponseMessage;
import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import services.CityService;
import services.EventService;
import services.UserService;

import javax.validation.Valid;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class EventController {

    private static final Logger logger = LoggerFactory.getLogger(EventController.class);

    @Autowired
    EventService eventService;

    @Autowired
    CityService cityService;

    @Autowired
    UserService userservice;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/back/admin/api/admin/deleteactiveevent")
    public ResponseEntity<?> deleteactiveEvent(@Valid @RequestBody EventForm eventRequest) throws Exception {
        logger.info("In DeleteActiveEvent");
        jwtProvider.validateJwtToken(eventRequest.getToken());
        Optional<User> user = userservice.userByUserName(jwtProvider.getUserNameFromJwtToken(eventRequest.getToken()));
        User userNotOpt = user.get();
        eventService.deleteactive(eventRequest, userNotOpt);
        return new ResponseEntity<>(eventService.getEventByUser(
                userservice.userByUserName(jwtProvider.getUserNameFromJwtToken(eventRequest.getToken()))),
                HttpStatus.OK);
    }
}
