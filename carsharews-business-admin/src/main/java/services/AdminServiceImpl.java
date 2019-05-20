package services;

import message.response.AdminReponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.mapper.AdminMapper;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;


    @Override
    public AdminReponse adminReponse() {
        return adminMapper.adminDataToExpo();
    }
}
