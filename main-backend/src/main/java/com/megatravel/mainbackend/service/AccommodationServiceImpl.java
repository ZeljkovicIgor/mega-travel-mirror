package com.megatravel.mainbackend.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.megatravel.mainbackend.dto.SearchAccommodationDTO;
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

	@Override
	public List<Accommodation> findByCityAndAccCapacity(String city, Integer accCapacity, String accType,
			String accCategory) {
		// TODO Auto-generated method stub
		return accommodationRepository.findByAccLocationCityIgnoreCaseContainingAndAccCapacityAndAccTypeAccTypeNameIgnoreCaseContainingAndAccCategoryCategoryNameIgnoreCaseContaining(city, accCapacity, accType, accCategory);		
	}

	@Override
	public List<Accommodation> findByCityAndAccCapacity2(String city, Integer accCapacity, String accType) {
		// TODO Auto-generated method stub
		 return accommodationRepository.findByAccLocationCityIgnoreCaseContainingAndAccCapacityAndAccTypeAccTypeNameIgnoreCaseContaining(city, accCapacity, accType);
	}

	@Override
	public List<Accommodation> findByAccUnavailableDateStartBetweenAndAccUnavailableDateEndBetween(Date startDate,
			Date endDate, Date startDate1, Date endDate1) {
		// TODO Auto-generated method stub
		return accommodationRepository.findByAccUnavailableUnavailableStartBetweenAndAccUnavailableUnavailableEndBetween(startDate, endDate, startDate1, endDate1);
		
	}

	@Override
	public List<Accommodation> search(SearchAccommodationDTO search) {
		
		return accommodationRepository.findByAccLocationCityIgnoreCase(search.getCity());
		
	}

}
