package services.mapper;

import message.request.TravelForm;
import message.request.TravelUpdate;
import message.response.TravelReponse;
import model.City;
import model.Event;
import model.Travel;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CityRepository;
import repository.PassagerRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TravelMapper {

    @Autowired
    CityRepository cityRepository;

    @Autowired
    PassagerRepository passagerRepository;

    public Travel travelExpoToData(TravelForm travelForm, Event event, User user){
        String code = travelForm.getCity()+travelForm.getTypeCar()+ user.getUsername()+event.getNameEvent();
        City city = cityRepository.findByCodepostal(travelForm.getCodePostal());
        City cityEvent=event.getCity();
        Travel travel = new Travel(code, travelForm.getCity(),  travelForm.getTypeCar(), Integer.parseInt(travelForm.getDispo()),
                travelForm.isActive(), user, event, city,cityEvent, travelForm.getBeginEvent(), travelForm.getEndEvent());
        return travel;
    }

    public Travel travelUpExpoToData(TravelUpdate travelForm, Event event, User user){
        String code = travelForm.getCity()+travelForm.getTypeCar()+ user.getName()+event.getNameEvent();
        Travel travel = new Travel(code, travelForm.getCity(),  travelForm.getTypeCar(), Integer.parseInt(travelForm.getDispo()),
                travelForm.isActive(), user, event, travelForm.getCodePostal(),travelForm.getCityEvent(), travelForm.getBeginEvent(), travelForm.getEndEvent());
        return travel;
    }

    public TravelReponse travelSoloDataToExpo(Travel travel){
        TravelReponse travelReponse =new TravelReponse(String.valueOf(travel.getDispo()),travel.getTravel(),travel.getEvent().getNameEvent(),
                travel.getTypeCar(), travel.getUser().getUsername(), travel.isActive(), travel.getCity(),travel.getCityEvent(),
                travel.getBeginEvent(), travel.getEndEvent(), passagerRepository.findPassagersByTravel(travel).size());
        return travelReponse;
    }

    public List<TravelReponse> travelDataToExpo(List<Travel> travel){
        List<TravelReponse> travelReponses=new ArrayList<>();
        if (travel.size()>0){
            for (Travel e:travel
                    ) {
                travelReponses.add(new TravelReponse(String.valueOf(e.getDispo()),e.getTravel(),e.getEvent().getNameEvent(), e.getTypeCar(),
                        e.getUser().getUsername(), e.isActive(), e.getCity(),e.getCityEvent(), e.getBeginEvent(), e.getEndEvent(), passagerRepository.findPassagersByTravel(e).size()));
            }
        }
        return travelReponses;
    }
}
