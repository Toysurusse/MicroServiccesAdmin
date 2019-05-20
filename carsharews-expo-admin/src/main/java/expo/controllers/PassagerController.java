package expo.controllers;


import expo.security.jwt.JwtProvider;
import message.request.PassengerForm;
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
import services.PassengerService;
import services.TravelService;
import services.UserService;

import javax.validation.Valid;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class PassagerController {


    private static final Logger logger = LoggerFactory.getLogger(PassagerController.class);

    @Autowired
    PassengerService passagerService;

    @Autowired
    TravelService travelService;

    @Autowired
    UserService userservice;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/back/admin/api/admin/deletepassager")
    public ResponseEntity<?> deleteTravel(@Valid @RequestBody PassengerForm passagerRequest) {
        logger.info("in Delete Passager");
        jwtProvider.validateJwtToken(passagerRequest.getToken());
        Optional<User> user = userservice.userByUserName(jwtProvider.getUserNameFromJwtToken(passagerRequest.getToken()));
        User userNotOpt = user.get();
        passagerService.delete(passagerRequest, userNotOpt);
        return new ResponseEntity<>(passagerService.getPassagerByTravel(travelService.getTravelByCode(passagerRequest.getTravelCode())),
                HttpStatus.OK);
    }
}
