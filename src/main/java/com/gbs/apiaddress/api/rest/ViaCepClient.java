package com.gbs.apiaddress.api.rest;

import com.gbs.apiaddress.api.dto.AddressResponse;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class ViaCepClient {

    private final RestTemplate restTemplate;

    public ViaCepClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public AddressResponse findCepRest(final String cep){
        String url = "https://viacep.com.br/ws/{cep}/json/";
        try {
            return restTemplate.getForObject(url, AddressResponse.class, cep);
        }catch (RestClientException e){
            throw new RestClientException("Erro ao realizar busca no ViaCep");
        }
    }

}
