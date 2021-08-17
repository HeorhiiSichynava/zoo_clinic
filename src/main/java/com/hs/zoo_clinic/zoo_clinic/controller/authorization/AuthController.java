package com.hs.zoo_clinic.zoo_clinic.controller.authorization;

import com.hs.zoo_clinic.zoo_clinic.dao.AuthResponse;
import com.hs.zoo_clinic.zoo_clinic.dto.AuthClientDto;
import com.hs.zoo_clinic.zoo_clinic.service.ServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    ServiceClient serviceClient;

    @Autowired
    public AuthController(ServiceClient serviceClient) {
        this.serviceClient = serviceClient;
    }

    @PostMapping("/auth")
    AuthResponse auth(@RequestBody AuthClientDto authClientDto) {
        return serviceClient.findByLoginAndPassword(authClientDto);
     }


}
