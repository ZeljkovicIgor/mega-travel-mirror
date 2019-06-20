package com.megatravel.agentbackend.service;


import com.megatravel.agentbackend.dto.AccommodationDto;
import com.megatravel.agentbackend.model.Accommodation;

import java.util.List;

public interface AccommodationService {

    Accommodation getOneById(Long id);
    List<Accommodation> getAll();
    Accommodation addOne(Accommodation accommodation);
    Accommodation editOne(Accommodation accommodation);
    boolean deleteOne(Accommodation accommodation);
    boolean deleteAccById(Long id);
    Accommodation convertFromDto(AccommodationDto accDto);
}
