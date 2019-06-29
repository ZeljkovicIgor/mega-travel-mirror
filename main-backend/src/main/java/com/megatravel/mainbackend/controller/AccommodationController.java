package com.megatravel.mainbackend.controller;

import com.megatravel.mainbackend.dto.SearchAccommodationDTO;
import com.megatravel.mainbackend.model.*;
import com.megatravel.mainbackend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;


@RestController
@RequestMapping(value= "/accommodation")
public class AccommodationController {

	@Autowired
	private AccommodationService accommodationService;
	@Autowired
	AddServiceService addServiceService;
	@Autowired
	AccTypeService accTypeService;
	@Autowired
	AccLocationService accLocationService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	AccPriceService accPriceService;
	@Autowired
	UserService userService;
	@Autowired
	private ReviewService reviewService;

	@GetMapping(value = "/test1")
	private ResponseEntity<Accommodation> test(){

		User agent = new User();
		agent.setUserUsername("agent");
		agent.setUserPassword("password");
		agent.setUserType(UserType.AGENT);
		agent.setUserEmail("agent@agent.com");
		agent.setActivated(true);
		agent.setUserBusinessId("12345");
		User saved = userService.save(agent);

		AddService addService = new AddService();
		addService.setServiceName("WIFI");
		addService = addServiceService.save(addService);

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date datum1 = null;
		Date datum2 = null;
		Date datum3 = null;
		Date datum4 = null;
		Date datum5=null;
		try {
			datum1 = dateFormat.parse("2019-07-25 00:00");
			datum2 = dateFormat.parse("2019-07-30 00:00");
			datum3 = dateFormat.parse("2019-08-25 00:00");
			datum4 = dateFormat.parse("2019-08-27 00:00");
			datum5 = dateFormat.parse("2019-06-25 00:00");
		} catch (ParseException e) {
		
			e.printStackTrace();
		}
		
		AccPrice accPrice = new AccPrice();
		Date startDate = new Date();
		accPrice.setPriceStartDate(datum1);
		accPrice.setPriceEndDate(datum2);
		accPrice.setPriceValue(5000);
		accPrice = accPriceService.save(accPrice);

		AccPrice accPrice2 = new AccPrice();
		accPrice2.setPriceStartDate(datum3);
		accPrice2.setPriceEndDate(datum4);
		accPrice2.setPriceValue(10000);
		accPrice2 = accPriceService.save(accPrice2);

		AccType accType = new AccType();
		accType.setAccTypeName("Hotel");
		accType = accTypeService.save(accType);
		System.out.println("ID tipa " + accType.getAccTypeId());

		AccLocation accLocation = new AccLocation();
		accLocation.setAddress("Neka adresa 1");
		accLocation.setCity("Novi Sad");
		accLocation.setCountry("Srbija");
		accLocation = accLocationService.save(accLocation);
		System.out.println("ID Lokacije " + accLocation.getLocId());
		Category category = new Category();
		category.setCategoryName("Neka kategorija");
		category = categoryService.save(category);
		System.out.println("ID kategorije " + category.getCategoryId());
		Accommodation acc1= new Accommodation();
		acc1.setAccAgent(userService.findOne(saved.getUserId()));
		acc1.setAccName("Smestaj 1");
		acc1.setAccDescription("Neki opis 1");
		acc1.setAccCategory(category);
		acc1.setAccLocation(accLocation);

		List<AccPrice> prices1 = new ArrayList<>();
		prices1.add(accPrice);
		acc1.setAccPricePlan(prices1);

		List<AccUnavailable>  accUnavailable = new ArrayList<>();
		acc1.setAccUnavailable(accUnavailable);



		Accommodation acc2= new Accommodation();
		acc2.setAccAgent(userService.findOne(saved.getUserId()));
		acc2.setAccName("Smestaj 2");
		acc2.setAccDescription("Neki opis 2");

		List<AccPrice> prices2 = new ArrayList<>();
		prices2.add(accPrice2);
		acc2.setAccPricePlan(prices2);

		acc2.setAccPricePlan(prices2);
		accommodationService.save(acc2);
		return new ResponseEntity<Accommodation>(accommodationService.save(acc1), HttpStatus.OK);
	}

	@GetMapping(value = "/test2")
	public ResponseEntity<List<Accommodation>> test2(){

		List<Accommodation> accommodationList = accommodationService.findAll();
		return new ResponseEntity<List<Accommodation>>(accommodationService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/sortByPriceAsc",method=RequestMethod.GET)
	public ResponseEntity<List<Accommodation>> sortByPrice(@RequestBody SearchAccommodationDTO search){
		List<Accommodation> searchList=accommodationService.search(search);
		List<Accommodation> retListAll=accommodationService.sortPriceByAsc(); 
		List<Accommodation> retListSearch=new ArrayList<>(); 
		for(Accommodation a: retListAll) {
			for(Accommodation s:searchList) {
				if(a.getAccId()==s.getAccId()) {
					retListSearch.add(a);
				}
				
			}
		}
		
		return new ResponseEntity<List<Accommodation>>(retListSearch, HttpStatus.OK);
	}
	@RequestMapping(value = "/sortByPriceDesc",method=RequestMethod.GET)
	public ResponseEntity<List<Accommodation>> sortByPriceDesc(@RequestBody SearchAccommodationDTO search){
		List<Accommodation> searchList=accommodationService.search(search);
		List<Accommodation> retListAll=accommodationService.sortPriceByDesc(); 
		List<Accommodation> retListSearch=new ArrayList<>(); 
		for(Accommodation a: retListAll) {
			for(Accommodation s:searchList) {
				if(a.getAccId()==s.getAccId()) {
					retListSearch.add(a);
				}
				
			}
		}
		
		return new ResponseEntity<List<Accommodation>>(retListSearch, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/sortByReviewGradeDesc",method=RequestMethod.GET)
	public ResponseEntity<List<Accommodation>> sortBreviewGradeDesc(@RequestBody SearchAccommodationDTO search){
		List<Accommodation> retListSearch=new ArrayList<Accommodation>();
		List<Accommodation> searchList=accommodationService.search(search);
		List<Review> reviewAllAsc =reviewService.sortReviewByDesc();
		for(Review r: reviewAllAsc) {
			for(Accommodation a: searchList ) {
				if(a.getAccId()==r.getReviewAccommodation().getAccId()) {
					retListSearch.add(a);
				}
			}
		}
		
		return new ResponseEntity<List<Accommodation>>(retListSearch, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/sortByReviewGradeAsc",method=RequestMethod.GET)
	public ResponseEntity<List<Accommodation>> sortBreviewGradeAsc(@RequestBody SearchAccommodationDTO search){
		List<Accommodation> retListSearch=new ArrayList<Accommodation>();
		List<Accommodation> searchList=accommodationService.search(search);
		List<Review> reviewAllAsc =reviewService.sortReviewByAsc();
		for(Review r: reviewAllAsc) {
			for(Accommodation a: searchList ) {
				if(a.getAccId()==r.getReviewAccommodation().getAccId()) {
					retListSearch.add(a);
				}
			}
		}
		
		return new ResponseEntity<List<Accommodation>>(retListSearch, HttpStatus.OK);
	}
	@RequestMapping(value = "/sortByCategoryAsc",method=RequestMethod.GET)
	public ResponseEntity<List<Accommodation>> sortByCategoryAsc(@RequestBody SearchAccommodationDTO search){
		List<Accommodation> retListSearch=new ArrayList<Accommodation>();
		List<Accommodation> searchList=accommodationService.search(search);
		List<Category> allCategorySort=categoryService.sortCategoryByAsc();
		for(Category c: allCategorySort) {
			for(Accommodation a: searchList) {
				if(a.getAccCategory().getCategoryName().equals(c.getCategoryName()));
				retListSearch.add(a);
			}
		}
		
		return new ResponseEntity<List<Accommodation>>(retListSearch, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/sortByCategoryDesc",method=RequestMethod.GET)
	public ResponseEntity<List<Accommodation>> sortByCategoryDesc(@RequestBody SearchAccommodationDTO search){
		List<Accommodation> retListSearch=new ArrayList<Accommodation>();
		List<Accommodation> searchList=accommodationService.search(search);
		List<Category> allCategorySort=categoryService.sortCategoryByDesc();
		for(Category c: allCategorySort) {
			for(Accommodation a: searchList) {
				if(a.getAccCategory().getCategoryName().equals(c.getCategoryName()));
				retListSearch.add(a);
			}
		}
		
		return new ResponseEntity<List<Accommodation>>(retListSearch, HttpStatus.OK);
	}
}
