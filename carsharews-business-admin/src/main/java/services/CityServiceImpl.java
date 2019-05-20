package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CityRepository;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    CityRepository cityRepository;

    @Override
    public boolean checkIfCodePostalExist(String code){
        if(cityRepository.findByCodepostal(code)==null){
            return true;
        }
        return false;
    }
}
