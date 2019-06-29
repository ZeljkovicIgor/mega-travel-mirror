package com.megatravel.mainbackend.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megatravel.mainbackend.dto.SearchAccommodationDTO;
import com.megatravel.mainbackend.model.AccPrice;
import com.megatravel.mainbackend.model.AccUnavailable;
import com.megatravel.mainbackend.model.Accommodation;
import com.megatravel.mainbackend.model.AddService;
import com.megatravel.mainbackend.model.Reservation;
import com.megatravel.mainbackend.repository.AccommodationRepository;
import com.megatravel.mainbackend.repository.ReservationRepository;
import com.megatravel.mainbackend.util.MyDatatypeConverter;

@Service
public class AccommodationServiceImpl implements AccommodationService {

	@Autowired
	public AccommodationRepository accommodationRepository;
	
	@Autowired
	public ReservationRepository reservationRepository;
	
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
		
		List<Accommodation> cityAndCapacity = accommodationRepository
				.findByAccLocationCityIgnoreCaseContainingAndAccCapacityGreaterThanEqual(search.getCity(), search.getPeople());
		
		Date startDate = MyDatatypeConverter.parseDate(search.getStartDate());
		Date endDate = MyDatatypeConverter.parseDate(search.getEndDate());
		
		for(int i = 0; i < cityAndCapacity.size(); i++) {
			List<AccUnavailable> unavailables = cityAndCapacity.get(i).getAccUnavailable();
			for(int j = 0; j < unavailables.size(); j++) {
				AccUnavailable un = unavailables.get(j);
				
				if(
					(startDate.before(un.getUnavailableStart()) && endDate.after(un.getUnavailableStart()))
						||
					(startDate.before(un.getUnavailableEnd()) && endDate.after(un.getUnavailableEnd()))
						||
					(startDate.after(un.getUnavailableStart()) && endDate.before(un.getUnavailableEnd()))
				) {
					cityAndCapacity.remove(i);
				}
			}
		}
		
		List<Reservation> reservations = reservationRepository.findAll();
		
		List<Accommodation> accommodations = new ArrayList<>();
		
		for(Reservation res : reservations) {
			for(Accommodation acc : cityAndCapacity) {
				if(acc.getAccId() != res.getRAccommodation().getAccId()) {
					accommodations.add(acc);
				}else if(
					(startDate.before(res.getRStartDate()) && endDate.before(res.getRStartDate()))
						||
					(startDate.after(res.getREndDate()) && endDate.after(res.getREndDate()))
						) {
					accommodations.add(acc);
				}
			}
		}
		
		if(!reservations.isEmpty())
			return accommodations;
		return cityAndCapacity;
		
	}

	@Override
	public List<Accommodation> advancedSearch(SearchAccommodationDTO search) {
		
		List<Accommodation> basicSearch = search(search);
		
		List<Accommodation> accommodations = new ArrayList<>();
		
		List<Accommodation> categories = new ArrayList<>();
		
		for(Accommodation bs : basicSearch) {
			if(search.getCategoryId() == null) {
				categories = basicSearch;
				break;
			}
			if(bs.getAccCategory().getCategoryId() == search.getCategoryId()) {
				categories.add(bs);
			}
		}
		
		for(Accommodation cat : categories) {
			if(search.getAccTypeId() == null) {
				accommodations = categories;
				break;
			}
			if(cat.getAccType().getAccTypeId() == search.getAccTypeId()) {
				accommodations.add(cat);
			}
		}
		
		
		if(search.getAddServices().isEmpty())
			return accommodations;
		
		for(int i = 0; i < accommodations.size();) {
			List<AddService> services = accommodations.get(i).getAccServices();
			List<Long> accServiceIds = new ArrayList<>();
			for(AddService service : services) {
				accServiceIds.add(service.getServiceId());
			}
			
			int j = 0;
			boolean flag = false;
			
			for(Long serviceId : search.getAddServices()) {
				if(!accServiceIds.contains(serviceId)) {
					accommodations.remove(i);
					break;
				}
				if( j+1 == search.getAddServices().size() )
					flag = true;
				j++;
			}
			
			if(flag == true)
				i++;
			
		}
		
		return accommodations;
	}

}
