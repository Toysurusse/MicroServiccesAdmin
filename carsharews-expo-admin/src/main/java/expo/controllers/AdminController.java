package expo.controllers;

import expo.security.jwt.JwtProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import services.AdminService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class AdminController {

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    AdminService adminService;

    @Autowired
    JwtProvider jwtProvider;

    @GetMapping("/back/admin/api/dashboard")
    public ResponseEntity<?> getAdminInfo() {
        logger.info("In Admin");
        return new ResponseEntity<>(adminService.adminReponse(),
                HttpStatus.OK);
    }
}
