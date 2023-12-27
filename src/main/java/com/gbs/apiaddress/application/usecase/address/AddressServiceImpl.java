package com.gbs.apiaddress.application.usecase.address;

import com.gbs.apiaddress.api.dto.AddressResponse;
import com.gbs.apiaddress.infrastructure.address.AddressServiceRepository;
import com.gbs.apiaddress.shared.utils.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AddressServiceImpl implements AddressService {

    private final AddressServiceRepository serviceRepository;

    @Override
    public AddressResponse findByCep(String cep) {
        return Mapper.converte(serviceRepository.findByCep(cep), AddressResponse.class);
    }
}
