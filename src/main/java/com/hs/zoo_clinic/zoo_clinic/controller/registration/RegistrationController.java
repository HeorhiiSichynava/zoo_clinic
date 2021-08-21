package com.hs.zoo_clinic.zoo_clinic.controller.registration;

import com.hs.zoo_clinic.zoo_clinic.dto.client.ClientDto;
import com.hs.zoo_clinic.zoo_clinic.service.ServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@RestController
public class RegistrationController {

    ServiceClient serviceClient;

    @Autowired
    public RegistrationController(ServiceClient serviceClient) {
        this.serviceClient = serviceClient;
    }

    @PostMapping("/registration")
    ClientDto registration(@RequestBody ClientDto clientDto) {
        ClientDto responseClient = serviceClient.save(clientDto);
        return responseClient;
    }

    @GetMapping("/findAll")
    List<ClientDto> findAll(){
        return serviceClient.findAll();
    }
}
