package com.gbs.apiaddress.shared.utils;

import org.modelmapper.ModelMapper;

public class Mapper {

    private static ModelMapper modelMapper = null;



    private Mapper() {
    }

    private static ModelMapper getMapper() {
        if (modelMapper == null) {
            modelMapper = new ModelMapper();
        }
        return modelMapper;
    }

    public static <T> T converte(Object origin, Class<T> destiny) {
        return Mapper.getMapper().map(origin, destiny);
    }

    public static void copyEntity(Object origin, Object destiny) {
        Mapper.getMapper().map(origin, destiny);
    }

}
