package com.megatravel.mainbackend.controller;

import java.io.IOException;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.megatravel.mainbackend.model.AccPrice;
import com.megatravel.mainbackend.model.AccUnavailable;
import com.megatravel.mainbackend.model.Accommodation;
import com.megatravel.mainbackend.model.Reservation;
import com.megatravel.mainbackend.model.User;
import com.megatravel.mainbackend.service.AccPriceService;
import com.megatravel.mainbackend.service.AccUnavailableService;
import com.megatravel.mainbackend.service.AccommodationService;
import com.megatravel.mainbackend.service.ReservationService;

@RestController
@RequestMapping(value = "/reservation")
public class ReservationController {

	@Autowired
	private ReservationService reservationService;
	@Autowired
	private AccUnavailableService accUnavailableService;
	@Autowired
	private AccommodationService accommodationService;
	
	@RequestMapping(value="/getReservations", method=RequestMethod.GET)
	public ResponseEntity<List<Reservation>> getReservations(){
		return new ResponseEntity<>(reservationService.findAll(),HttpStatus.OK);	
	}
	
	@RequestMapping(value="/addReservation",method=RequestMethod.POST)
	public ResponseEntity<Reservation> addReservation(@RequestBody Reservation newReservation,HttpServletRequest request){
		User logged =(User) request.getSession().getAttribute("logged");
		Accommodation toReservate =accommodationService.findOne(newReservation.getRAccommodation().getAccId());
		List<Reservation> findAllRes=reservationService.findAll();
		
		for(Reservation r: findAllRes) {
			if(!newReservation.getRStartDate().before(r.getRStartDate())  && !newReservation.getREndDate().after(r.getREndDate()) ) {
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			}
			
		
		}
		
		List<AccUnavailable> allUnavailable =accUnavailableService.findAll();
		List<AccPrice> accPrice = toReservate.getAccPricePlan();
		if(checkReservation(accPrice,newReservation.getRStartDate(),newReservation.getREndDate())
				&& !checkUnavailable(allUnavailable,newReservation.getRStartDate(),newReservation.getREndDate())) {
			newReservation.setRDate(new Date());
			newReservation.setCancelled(false);
			newReservation.setREndUser(logged);
			//kolkio je dana izmedju
			int days=(int) reservationService.betweenDates(newReservation.getRStartDate(), newReservation.getREndDate());
			float priceAcc =reservationService.getAccPrice(accPrice,newReservation.getRStartDate(),newReservation.getREndDate());
	
			newReservation.setRPeople(newReservation.getRPeople());
			newReservation.setRPrice(priceAcc*days);
			
			reservationService.save(newReservation);
			return new ResponseEntity<>(newReservation,HttpStatus.OK);
		}

	
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}
	
	@RequestMapping(value="/deleteReservation/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Reservation> deleteReservations(@PathVariable("id")  Long id){
		reservationService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);	
	}
	
	@RequestMapping(value="/updateReservation/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Reservation> updateReservation(@RequestBody Reservation updateReservation,@PathVariable("id")  Long id){
		//implementirati
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/cancelReservation/{id}", method=RequestMethod.PUT)
	public ResponseEntity cancelReservation(@PathVariable("id")  Long id,HttpServletRequest request) throws IOException{
		Reservation resToCancel = reservationService.findOne(id);
		System.out.println("Rezervacija koju zelim da otkazem " + resToCancel.getRId());
		Accommodation acc = resToCancel.getRAccommodation();
		User logged = (User) request.getSession().getAttribute("logged");
		System.out.println("Korisnik koji je logovan " +logged.getUserId());
		//proveri da li sme da canceluje zbog dana
		//da li je za smestaj dozvoljeno sa se otkaze
		int accCancelPeriod=acc.getAccCancelPeriod();
		System.out.println("canclPerdiod je"+accCancelPeriod);
		Date now = new Date();
		//kada pocinje rezervacija 
		//koji je danas dan
		//koja je razlika izmedju ta dva dana
		//da li je manja od accCancelPeriod
		//oduzmi od accCancelPeriod i proveri da li sme
		//Date resDate
		//if(acc.getAccCancelPeriod())
		int days = (int)reservationService.betweenDates(now,resToCancel.getRStartDate());
		
		if(resToCancel.getREndUser().getUserId()==logged.getUserId() && now.before(resToCancel.getRStartDate()) && days>accCancelPeriod ) {
			resToCancel.setCancelled(true);
			reservationService.save(resToCancel);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		
	}
	public long betweenDates(Date firstDate, Date secondDate) throws IOException
	{
	    return ChronoUnit.DAYS.between(firstDate.toInstant(), secondDate.toInstant());
	}
	
	public boolean checkReservation(List<AccPrice> accPrice,Date startDate, Date endDate) {
	
		for(AccPrice a: accPrice) {
			//a > b ⇔ ¬ (a ≤ b)
			if(!startDate.before(a.getPriceStartDate())  && !endDate.after(a.getPriceEndDate()) ) {
				
				
				return true;
			}
		}
		return false;
	}
	public float getAccPrice(List<AccPrice> accPrice,Date startDate, Date endDate) {
		
		for(AccPrice a: accPrice) {
			//a > b ⇔ ¬ (a ≤ b)
			//if(startDate.after(a.getPriceStartDate())  && endDate.before(a.getPriceEndDate())) {
			if(!startDate.before(a.getPriceStartDate())  && !endDate.after(a.getPriceEndDate()) ) {
				return a.getPriceValue();
			}
		}
	
		return 0;
	}
	
	public boolean checkUnavailable(List<AccUnavailable> allUnavailable,Date startDate, Date endDate) {
		
		for(AccUnavailable a: allUnavailable) {
			if(!startDate.before(a.getUnavailableStart()) && !endDate.after(a.getUnavailableEnd())) {
				return true;
			}
		}
		return false;
	}
	
	/*public long betweenDates(Date firstDate, Date secondDate) throws IOException
	{
	    return ChronoUnit.DAYS.between(firstDate.toInstant(), secondDate.toInstant());
	}
	
	public boolean checkReservation(List<AccPrice> accPrice,Date startDate, Date endDate) {
	
		for(AccPrice a: accPrice) {
			if(startDate.after(a.getPriceStartDate()) && endDate.before(a.getPriceEndDate())) {
				return true;
			}
		}
		return false;
	}
	public float getAccPrice(List<AccPrice> accPrice,Date startDate, Date endDate) {
		
		for(AccPrice a: accPrice) {
			if(startDate.after(a.getPriceStartDate()) && endDate.before(a.getPriceEndDate())) {
				return a.getPriceValue();
			}
		}
	
		return 0;
	}
	
	public boolean checkUnavailable(List<AccUnavailable> allUnavailable,Date startDate, Date endDate) {
		
		for(AccUnavailable a: allUnavailable) {
			if(startDate.after(a.getUnavailableStart()) && endDate.before(a.getUnavailableEnd())) {
				return true;
			}
		}
		return false;
	}*/
	
}
