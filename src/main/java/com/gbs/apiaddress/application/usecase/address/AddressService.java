package com.gbs.apiaddress.application.usecase.address;

import com.gbs.apiaddress.api.dto.AddressResponse;
import jakarta.validation.constraints.NotEmpty;

public interface AddressService {

    AddressResponse findByCep(@NotEmpty final String cep);

}
