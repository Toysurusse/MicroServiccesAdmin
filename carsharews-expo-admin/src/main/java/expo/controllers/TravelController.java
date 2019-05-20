package expo.controllers;

import expo.security.jwt.JwtProvider;
import message.request.TravelForm;
import message.request.TravelUpdate;
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
import services.TravelService;
import services.UserService;

import javax.validation.Valid;
import java.util.Optional;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class TravelController {

    private static final Logger logger = LoggerFactory.getLogger(TravelController.class);

    @Autowired
    TravelService travelService;

    @Autowired
    UserService userservice;

    @Autowired
    CityService cityService;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/back/admin/api/admin/updatetravel")
    public ResponseEntity<?> updateTravel(@Valid @RequestBody TravelForm travelRequest) {
        logger.info("in updatetravel");
        jwtProvider.validateJwtToken(travelRequest.getToken());
        Optional<User> user = userservice.userByUserName(jwtProvider.getUserNameFromJwtToken(travelRequest.getToken()));
        User userNotOpt = user.get();
        travelService.update(travelRequest, userNotOpt);
        return new ResponseEntity<>(travelService.getTravelByUser(
                userservice.userByUserName(jwtProvider.getUserNameFromJwtToken(travelRequest.getToken()))),
                HttpStatus.OK);
    }

    @PostMapping("/back/admin/api/admin/deleteactivetravel")
    public ResponseEntity<?> deleteactiveTravel(@Valid @RequestBody TravelUpdate travelRequest) {
        logger.info("in deleteactivetravel");
        Optional<User> user = userservice.userByUserName(travelRequest.getToken());
        User userNotOpt = user.get();
        travelService.deleteactive(travelRequest, userNotOpt);
        return new ResponseEntity<>(travelService.getTravelByEvent(travelRequest.getName()),
                HttpStatus.OK);
    }

    @PostMapping("/back/admin/api/admin/gettravelbyevent")
    public ResponseEntity<?> getTravelByUser(@Valid @RequestBody String event) {
        logger.info("in get Travel By event");
        return new ResponseEntity<>(travelService.getTravelByEvent(event),
                HttpStatus.OK);
    }
}
