package com.gbs.apiaddress.api.controller;

import com.gbs.apiaddress.api.dto.AddressResponse;
import com.gbs.apiaddress.application.usecase.address.AddressService;
import jakarta.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService service;

    @GetMapping(value = "/{cep}")
    public AddressResponse findCep(@PathVariable @NotEmpty final String cep){
        return service.findByCep(cep);
    }
}
