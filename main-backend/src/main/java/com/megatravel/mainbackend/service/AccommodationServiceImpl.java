package com.megatravel.mainbackend.service;

import java.util.ArrayList;
import java.util.List;

import com.megatravel.mainbackend.model.AccPrice;
import com.megatravel.mainbackend.model.Accommodation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	@Override
	public Accommodation findOne(Long id) {
		return accommodationRepository.getOne(id);
	}

	@Override
	public List<Accommodation> findByAgentId(Long agentId) {
		List<Accommodation> accList = new ArrayList<>();
		for (Accommodation a : accommodationRepository.findAll()) {
			if (a.getAccAgent().getUserId() == agentId){
				accList.add(a);
			}
		}
		return accList;
	}

	@Override
	public List<AccPrice> getPricePlan(Long accId) {
		List<AccPrice> prices = new ArrayList<>();
		List<AccPrice> pricePlan = accommodationRepository.getOne(accId).getAccPricePlan();
		for (AccPrice accPrice : pricePlan ) {
			prices.add(accPrice);
		}
		return prices;
	}

}
