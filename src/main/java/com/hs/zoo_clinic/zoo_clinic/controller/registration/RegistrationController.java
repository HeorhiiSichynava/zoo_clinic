package com.hs.zoo_clinic.zoo_clinic.controller.registration;

import com.hs.zoo_clinic.zoo_clinic.dto.ClientDto;
import com.hs.zoo_clinic.zoo_clinic.service.ServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegistrationController {

    ServiceClient serviceClient;

    @Autowired
    public RegistrationController(ServiceClient serviceClient) {
        this.serviceClient = serviceClient;
    }

    @GetMapping
    public @ResponseBody String helloWeb() {
        return "Hello Web";
    }

    @PostMapping("/registration")
    ClientDto registration(@RequestBody ClientDto clientDto) {
        ClientDto responseClient = serviceClient.save(clientDto);
        return responseClient;
    }
}
