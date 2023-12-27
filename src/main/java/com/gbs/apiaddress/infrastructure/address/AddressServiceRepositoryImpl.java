package com.gbs.apiaddress.infrastructure.address;

import com.gbs.apiaddress.api.dto.AddressResponse;
import com.gbs.apiaddress.api.rest.ViaCepClient;
import com.gbs.apiaddress.model.entities.Address;
import com.gbs.apiaddress.model.repositories.AddressRepository;
import com.gbs.apiaddress.shared.exceptions.DatabaseNotFoundException;
import com.gbs.apiaddress.shared.exceptions.InvalidCepException;
import com.gbs.apiaddress.shared.utils.Mapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AddressServiceRepositoryImpl implements AddressServiceRepository {

    private final AddressRepository repository;
    private final ViaCepClient viaCepClient;

    @Override
    public Address findByCep(String cep) {

        String validCep = cleanCep(cep);

        Optional<Address> addressReturn = repository.findById(validCep);

        if (addressReturn.isPresent()) {
            return addressReturn.get();
        }

        log.info("Cep: {} não encontrado na base de dados. Buscando no viaCep", cep);
        AddressResponse response = viaCepClient.findCepRest(validCep);
        if (Strings.isEmpty(response.getUf())) {
            throw new DatabaseNotFoundException(String.format("Cep: %s não encontrado", validCep));
        }
        return repository.save(Mapper.converte(response, Address.class));


    }

    private String cleanCep(String cep) {
        cep = cep.replaceAll("\\D", "");
        cep = cep.substring(0, 5) + "-" + cep.substring(5, cep.length());

        if (cep.length() > 9) {
            throw new InvalidCepException(cep);
        }

        return cep;
    }
}
