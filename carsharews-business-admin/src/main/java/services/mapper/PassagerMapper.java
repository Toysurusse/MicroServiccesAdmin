package services.mapper;

import message.request.PassengerForm;
import message.response.PassagerResponse;
import model.Passager;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.EventRepository;
import repository.TravelRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PassagerMapper {

    @Autowired
    TravelMapper travelMapper;

    @Autowired
    TravelRepository travelRepository;

    public Passager passagerExpoToData(PassengerForm passagerForm, User user){
        Passager passager = new Passager(passagerForm.getUserInfo(), user, travelRepository.findByCode(passagerForm.getTravelCode()));
        return passager;
    }

    public List<PassagerResponse> passagerDataToExpo(List<Passager> passager){
        List<PassagerResponse> passagerReponses=new ArrayList<>();
        if (passager.size()>0){
            for (Passager e:passager
                    ) {
                passagerReponses.add(new PassagerResponse(e.getUserInfo(),e.getUser().getUsername(), travelMapper.travelSoloDataToExpo(travelRepository.findByCode(e.getTravel().getCode()))));
            }
        }
        return passagerReponses;
    }


}
