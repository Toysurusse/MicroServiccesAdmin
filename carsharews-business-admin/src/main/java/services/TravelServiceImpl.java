package services;

import message.request.TravelForm;
import message.request.TravelUpdate;
import message.response.EventReponse;
import message.response.TravelReponse;
import model.Travel;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.EventRepository;
import repository.TravelRepository;
import services.mapper.TravelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TravelServiceImpl implements TravelService {

    @Autowired
    TravelMapper travelMapper;

    @Autowired
    TravelRepository travelRepository;

    @Autowired
    EventRepository eventRepository;

    public void add(TravelForm event, User user){
        travelRepository.save(travelMapper.travelExpoToData(event, eventRepository.findByNameEvent(event.getName()),user));
    }

    public void deleteactive(TravelUpdate event, User user){
        Travel travel = travelMapper.travelUpExpoToData(event, eventRepository.findByNameEvent(event.getName()),user);
        System.out.println(event.getCity()+event.getTypeCar()+ user.getUsername()+event.getName());
        travel.setTravel_id(travelRepository.findByCode(event.getCity()+event.getTypeCar()+ user.getUsername()+event.getName()).getTravel_id());
        travel.setCode(event.getCity()+event.getTypeCar()+ user.getUsername()+event.getName());
        travelRepository.save(travel);
    }

    public void update(TravelForm event, User user){
        Travel travel = travelMapper.travelExpoToData(event, eventRepository.findByNameEvent(event.getName()),user);
        travel.setTravel_id(travelRepository.findByCode(event.getCity()+event.getTypeCar()+ user.getName()+event.getName()).getTravel_id());
        travelRepository.save(travelMapper.travelExpoToData(event, eventRepository.findByNameEvent(event.getName()),user));
    }

    public List<TravelReponse> getTravelLimit(String eventName, int begin, int end){
        List<TravelReponse> travelReponses=new ArrayList<>();
        List<TravelReponse> travelReponses1= travelMapper.travelDataToExpo(travelRepository.findAllByEvent(eventRepository.findByNameEvent(eventName)));
        int i = 0;
        for (TravelReponse e:travelReponses1
                ) {
            if (i>=begin && i<=end){
                travelReponses.add(e);
            }
            i++;
        }
        return travelReponses;
    }



    public List<TravelReponse> getTravelByUser(Optional<User> user){
        List<TravelReponse> travelReponses=new ArrayList<>();
        User user1 = user.get();
        List<TravelReponse> travelReponses1= travelMapper.travelDataToExpo(travelRepository.findAllByUser(user1));

        travelReponses=travelReponses1;
        return travelReponses;
    }

    public List<TravelReponse> getTravelByEvent(String eventName){
        List<TravelReponse> travelReponses=new ArrayList<>();
        List<TravelReponse> travelReponses1= travelMapper.travelDataToExpo(travelRepository.findAllByEvent(eventRepository.findByNameEvent(eventName)));
        travelReponses=travelReponses1;
        return travelReponses;
    }

    @Override
    public List<TravelReponse> getTravelList() {
        return travelMapper.travelDataToExpo(travelRepository.findAll());
    }

    public Travel getTravelByCode(String codeName){
        Travel travelReponse= travelRepository.findByCode(codeName);
        return travelReponse;
    }
}
