package com.megatravel.agentbackend.service;

import com.megatravel.agentbackend.dto.AccommodationDTO;
import com.megatravel.agentbackend.model.Accommodation;

public interface AccommodationService {

    public Accommodation getAcc(Long id);
    public Accommodation addAcc(Accommodation accommodation);
    public Accommodation editAcc(Accommodation accommodation);
    public boolean deleteAcc(Accommodation accommodation);
    public boolean deleteAccById(Long id);
    public Accommodation convertFromDto(AccommodationDTO accDto);
}
