package com.megatravel.mainbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megatravel.mainbackend.model.Accommodation;
import com.megatravel.mainbackend.repository.AccommodationRepository;

@Service
public class AccommodationServiceImpl implements AccommodationService {

	@Autowired
	public AccommodationRepository accommodationRepository;
	
	@Override
	public List<Accommodation> findAll() {
		// TODO Auto-generated method stub
		return accommodationRepository.findAll();
	}

	@Override
	public Accommodation save(Accommodation accommodation) {
		// TODO Auto-generated method stub
		return accommodationRepository.save(accommodation);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		accommodationRepository.deleteById(id);
	}
}
