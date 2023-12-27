package com.gbs.apiaddress.infrastructure.address;

import com.gbs.apiaddress.model.entities.Address;
import jakarta.validation.constraints.NotEmpty;

public interface AddressServiceRepository {

    Address findByCep(@NotEmpty final String cep);

}
