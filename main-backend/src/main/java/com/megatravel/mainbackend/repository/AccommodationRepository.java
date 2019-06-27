package com.megatravel.mainbackend.repository;

import com.megatravel.mainbackend.model.Accommodation;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {
	
	List<Accommodation> findByAccLocationCityIgnoreCaseContainingAndAccCapacity(String city,Integer accCapacity);
	List<Accommodation> findByAccLocationCityIgnoreCaseContainingAndAccCapacityAndAccTypeAccTypeNameIgnoreCaseContaining(String city,Integer accCapacity,String accType);
	List<Accommodation> findByAccLocationCityIgnoreCaseContainingAndAccCapacityAndAccTypeAccTypeNameIgnoreCaseContainingAndAccCategoryCategoryNameIgnoreCaseContaining(String city,Integer accCapacity,String accType,String accCategory);	
	List<Accommodation> findByAccUnavailableUnavailableStartBetweenAndAccUnavailableUnavailableEndBetween(Date startDate,Date endDate,Date startDate1,Date endDate1);
	
	List<Accommodation> findByAccLocationCityIgnoreCase(String city);
	
}
