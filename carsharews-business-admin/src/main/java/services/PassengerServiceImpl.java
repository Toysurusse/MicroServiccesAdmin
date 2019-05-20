package services;

import message.request.PassengerForm;

import message.request.TravelUpdate;
import message.response.PassagerResponse;
import model.Passager;
import model.Travel;
import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.EventRepository;
import repository.PassagerRepository;
import repository.TravelRepository;
import services.mapper.PassagerMapper;
import services.mapper.TravelMapper;

import java.util.List;

@Service
public class PassengerServiceImpl implements PassengerService {

    private static final Logger logger = LoggerFactory.getLogger(PassengerServiceImpl.class);

    @Autowired
    PassagerMapper passagerMapper;

    @Autowired
    PassagerRepository passagerRepository;

    @Autowired
    TravelMapper travelMapper;

    @Autowired
    TravelRepository travelRepository;

    @Override
    public String add(PassengerForm passager, User user) {
        String result = "Plus de place disponible";
        Passager passagerData = passagerMapper.passagerExpoToData(passager, user);
        List<Passager> passagers=passagerRepository.findPassagersByTravel(passagerData.getTravel());
        logger.info("travel : "+ passagerData.getTravel());
        logger.info("travel : "+ passagerData.getTravel());
        if(passagerData.getTravel().getDispo()>passagerRepository.findPassagersByTravel(passagerData.getTravel()).size()){
            passagerRepository.save(passagerData);
            result="Save";
        }
        return result;
    }

    @Override
    public void delete(PassengerForm passager, User user) {
        //Passager passager1 = passagerRepository.findPassagersByTravelAndUser(passager.getTravel(), user);
       // passagerRepository.delete(passager1);
    }

    public List<PassagerResponse> getPassagerByTravelForm(String travelCode, User user) {
        return passagerMapper.passagerDataToExpo(passagerRepository.findPassagersByTravel(travelRepository.findByCode(travelCode)));
    }

    @Override
    public List<PassagerResponse> getAllTravel() {
        return passagerMapper.passagerDataToExpo(passagerRepository.findAll());
    }

    @Override
    public List<PassagerResponse> getPassagerByTravel(Travel travel) {
        return passagerMapper.passagerDataToExpo(passagerRepository.findPassagersByTravel(travel));
    }
}
