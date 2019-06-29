package com.megatravel.agentbackend.service;

import com.megatravel.agentbackend.client.MegaTravelClient;
import com.megatravel.agentbackend.dto.ReservationDto;
import com.megatravel.agentbackend.model.*;
import com.megatravel.agentbackend.ws.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.net.ConnectException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SoapServiceImpl implements SoapService {

    @Autowired
    MegaTravelClient client;
    @Autowired
    SoapConverterService converterService;
    @Autowired
    AddServiceService addServiceService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    AccTypeService accTypeService;
    @Autowired
    UserService userService;
    @Autowired
    AccommodationService accommodationService;
    @Autowired
    ReservationService reservationService;
    @Autowired
    MessageService messageService;
    @Autowired
    ReviewService reviewService;


    @Override
    public boolean logInSync(String username, String password) {
        CheckAgentResponse response = client.getAgent(username, password);

        User agent = converterService.userConverter(response.getAgent());
        if (agent.getUserDbId() == 0)
            return false;
        //userService.addOne(agent);
        getUsers(agent);
        getAccTypes(agent);
        getAddServices(agent);
        getCategories(agent);
        List<AccommodationSoap> accommodationList = response.getAccommodation();
        Accommodation acc;
        for (AccommodationSoap accommodationSoap : accommodationList) {
                acc = new Accommodation();
                acc = converterService.accommodationConverter(accommodationSoap);
                accommodationService.addOne(acc);
        }
        //getAllAccommodations(agent);
        getAllReservations(agent);
        getAllReviews(agent);
        getAllMessages(agent);

        //predefinisano

        //tipovi smestaja
        //List<AccTypeSoap> accTypeSoapList = client.getAllAccommodationTypes(agent).getAccType();


            //kategorije smestaja
        //List<CategorySoap> categorySoapList = client.getAllCategories(agent).getCategory();
            //dodatne usluge
        //List<AddServiceSoap> addServiceSoapList = client.getAllAddServices(agent).getAddServce();


        //korisnici

        //List<UserSoap> userSoapList = client.getAllUsers(agent).getUser();
        //smestaj

        //poruke
        //List<MessageSoap> messageSoapList = client.getAllMessages(agent).getMessage();

        //komentari
        return true;
    }

    @Override
    public List<User> getUsers(User agent) {
        GetAllUserResponse response = client.getAllUsers(agent);
        List<UserSoap> userSoapList = response.getUser();
        User user;
        for (UserSoap userSoap : userSoapList) {
            user = new User();
            user = converterService.userConverter(userSoap);
            userService.addOne(user);
        }
        return null;
    }

    @Override
    public List<AccTypeSoap> getAccTypes(User agent) {
        GetAccTypeResponse response = client.getAllAccommodationTypes(agent);

        System.out.println("Stigao odgovor" + response.getAccType());
        for (AccTypeSoap accTypeSoap : response.getAccType()) {
            System.out.println(accTypeSoap.getAccTypeName());
        }
        List<AccTypeSoap> accTypeSoapList = new ArrayList<>();
        accTypeSoapList.addAll(response.getAccType());

        for (AccTypeSoap accTypeSoap : accTypeSoapList) {
            accTypeService.addOne(converterService.accTypeConverter(accTypeSoap));
        }
        return accTypeSoapList;
    }

    @Override
    public List<CategorySoap> getCategories(User agent) {
        GetCategoryResponse response = client.getAllCategories(agent);

        System.out.println("Stigao odgovor" + response.getCategory());
        for (CategorySoap categorySoap : response.getCategory()) {
            System.out.println(categorySoap.getCategoryName());
        }
        List<CategorySoap> categorySoapList = new ArrayList<>();
        categorySoapList.addAll(response.getCategory());

        for (CategorySoap categorySoap : categorySoapList) {
            categoryService.addOne(converterService.categoryConverter(categorySoap));
        }
        return categorySoapList;
    }

    @Override
    public List<AddServiceSoap> getAddServices(User agent) {
        GetAddServicesResponse response = client.getAllAddServices(agent);

        System.out.println("Stigao odgovor" + response.getAddServce());
        for (AddServiceSoap addServiceSoap : response.getAddServce()) {
            System.out.println(addServiceSoap.getServiceName());
        }
        List<AddServiceSoap> serviceSoapList = new ArrayList<>();
        serviceSoapList.addAll(response.getAddServce());

        for (AddServiceSoap addServiceSoap : serviceSoapList) {
            addServiceService.addOne(converterService.addServiceConverter(addServiceSoap));
        }
        return serviceSoapList;
    }

    @Override
    public List<Accommodation> getAllAccommodations(User agent) {
        GetAllAccommodationResponse response = client.getAllAccommodations(agent);
        List<AccommodationSoap> soapList = response.getAccommodation();
        Accommodation acc;
        for (AccommodationSoap accommodationSoap : soapList) {
            acc = new Accommodation();
            acc = converterService.accommodationConverter(accommodationSoap);
            accommodationService.addOne(acc);
        }
        return accommodationService.getAll();
    }

    @Override
    public List<Reservation> getAllReservations(User agent) {
        GetAllReservationResponse response = client.getAllReservations(agent);
        List<ReservationSoap> reservationSoapList = response.getReservation();
        Reservation reservation;
        for (ReservationSoap reservationSoap : reservationSoapList) {
            reservation = new Reservation();
            reservation = converterService.reservationConverter(reservationSoap);
            reservationService.addOne(reservation);
        }
        return reservationService.getAll();
    }

    @Override
    public List<Message> getAllMessages(User agent) {
        GetMessageResponse response = client.getAllMessages(agent);
        List<MessageSoap> messageSoapList = response.getMessage();
        Message message;
        for (MessageSoap messageSoap : messageSoapList) {
            message = new Message();
            message = converterService.messageConverter(messageSoap);
            messageService.addOne(message);
        }
        return messageService.getAll();
    }

    @Override
    public List<Review> getAllReviews(User agent) {
        GetAllReviewResponse response = client.getAllReviews(agent);
        List<ReviewSoap> reviewSoapList = response.getReview();
        Review review;
        for (ReviewSoap reviewSoap : reviewSoapList) {
            review = converterService.reviewConverter(reviewSoap);
            reviewService.addOne(review);
        }
        return reviewService.getAll();

    }

    @Override
    public Accommodation createOneAccommodation(Accommodation acc){
        AccommodationSoap accSoap = new AccommodationSoap();
        accSoap.setAccName(acc.getAccName());
        accSoap.setAccDescription(acc.getAccDescription());
        accSoap.setAccCapacity(acc.getAccCapacity());
        accSoap.setAccCancelPeriod(acc.getAccCancelPeriod());
        accSoap.setAccDate(acc.getAccDate());

        //Agent
        accSoap.setAccAgent(converterService.userConverter(acc.getAccAgent()));

        //Lokacija
        AccLocationSoap accLocationSoap = new AccLocationSoap();
        accLocationSoap.setAddress(acc.getAccLocation().getAddress());
        accLocationSoap.setCity(acc.getAccLocation().getCity());
        accLocationSoap.setCountry(acc.getAccLocation().getCountry());
        accLocationSoap.setXCoordinate(acc.getAccLocation().getXCoordinate());
        accLocationSoap.setYCoordinate(acc.getAccLocation().getYCoordinate());
        accSoap.setAccLocation(accLocationSoap);

        //Dodatni servisi
        List<AddService> addServiceList = acc.getAccServices();
        AddServiceSoap addServiceSoap = null;
        for (AddService addService : addServiceList){
            addServiceSoap = new AddServiceSoap();
            addServiceSoap.setServiceId(addService.getServiceDbId());
            addServiceSoap.setServiceName(addService.getServiceName());
            accSoap.getAccServices().add(addServiceSoap);
        }


        //Kategorija
        CategorySoap categorySoap = new CategorySoap();
        categorySoap.setCategoryId(acc.getAccCategory().getCategoryDbId());
        categorySoap.setCategoryName(acc.getAccCategory().getCategoryName());
        accSoap.setAccCategory(categorySoap);

        //Tip
        AccTypeSoap accTypeSoap = new AccTypeSoap();
        accTypeSoap.setAccTypeId(acc.getAccType().getAccTypeDbId());
        accTypeSoap.setAccTypeName(acc.getAccType().getAccTypeName());
        accSoap.setAccType(accTypeSoap);

        //Plan cena
        AccPriceSoap accPriceSoap = null;
        for (AccPrice accPrice : acc.getAccPricePlan()) {
            accPriceSoap = new AccPriceSoap();
            accPriceSoap.setPriceStartDate(accPrice.getPriceStartDate());
            accPriceSoap.setPriceEndDate(accPrice.getPriceEndDate());
            accPriceSoap.setPriceValue(accPrice.getPriceValue());
            accSoap.getAccPricePlan().add(accPriceSoap);
        }

        //Zauzetost

        AccUnavailableSoap accUnavailableSoap = null;
        for (AccUnavailable accUnavailable : acc.getAccUnavailable()) {
            accUnavailableSoap = new AccUnavailableSoap();
            accUnavailableSoap.setUnavailableStart(accUnavailable.getUnavailableStart());
            accUnavailableSoap.setUnavailableEnd(accUnavailable.getUnavailableEnd());
            accSoap.getAccUnavailable().add(accUnavailableSoap);
        }


        try {
            AddOneAccommodationResponse response = client.addOneAccommodation(accSoap);
            System.out.println(response.getAccDBId());
            acc.setAccDbId(response.getAccDBId());
        }catch (Exception e){
            System.out.println("Nema konekcije sa bazom. " + e);
        }


        return acc;
    }

    @Override
    public Reservation createReservation(Reservation reservation) {
        Reservation retVal = new Reservation();

        ReservationSoap reservationSoap = converterService.reservationConverter(reservation);
        ReservationSoap test = new ReservationSoap();
        SendReservationResponse response = client.sendReservation(reservationSoap);
        //prilikom salje novu rezervaciju agenta na back
        //moguce da je termin vec rezervisan na glavnom backu pa rezervacija nece biti moguca
        System.out.println(response.getReservationId());
        if(response.getReservationId() != 0){
            reservation.setrDbId(response.getReservationId());
            return reservation;

        }else
            return null;
    }

    @Override
    public boolean confirmReservation(Reservation reservation) {
        ReservationSoap reservationSoap = converterService.reservationConverter(reservation);
        ConfirmReservationResponse response = client.confirmReservation(reservationSoap);
        return response.isStatus();
    }

    @Override
    public Message sendMessage(Message message) {

        MessageSoap messageSoap = converterService.messageConverter(message);

        SendMessageResponse response = client.sendMessage(messageSoap);
        return null;
    }

    @Override
    public boolean deleteAccommodation(Accommodation accommodation) {
        AccommodationSoap accommodationSoap = converterService.accommodationConverter(accommodation);
        List<AccommodationSoap> soapList = new ArrayList<>();
        soapList.add(accommodationSoap);

        DeleteAccommodationsResponse response = client.deleteAccommodations(soapList);
        return response.isStatus();
    }
}
