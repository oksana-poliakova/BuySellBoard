package com.example.buysellboard.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author oksanapoliakova on 12.01.2024
 * @projectName BuySellBoard
 */

@Component
public class Beans {
    @Bean
    ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
