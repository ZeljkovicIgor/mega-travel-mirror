package com.megatravel.agentbackend.service;

import com.megatravel.agentbackend.model.*;
import com.megatravel.agentbackend.ws.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class SoapConverterServiceImpl implements SoapConverterService{


    @Autowired
    AddServiceService addServiceService;
    @Autowired
    AccTypeService accTypeService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    AccommodationService accommodationService;
    @Autowired
    UserService userService;
    @Autowired
    ReservationService reservationService;

    @Override
    public User userConverter(UserSoap userSoap) {
        User user = new User();
        user.setUserDbId(userSoap.getUserId());
        user.setUserUsername(userSoap.getUserUsername());
        user.setUserEmail(userSoap.getUserEmail());
        user.setUserBusinessName(userSoap.getUserBusinessName());
        user.setUserBusinessId(userSoap.getUserBusinessId());
        user.setUserPassword(userSoap.getUserPassword());
        user.setUserFirstName(userSoap.getUserFirstName());
        user.setUserLastName(userSoap.getUserLastName());
        user.setActivated(true);
        user.setDeleted(false);
        user.setUserType(userTypeConverter(userSoap.getUserType()));

        return user;
    }

    @Override
    public UserSoap userConverter(User user) {
        UserSoap userSoap = new UserSoap();
        userSoap.setUserId(user.getUserDbId());
        userSoap.setUserUsername(user.getUserUsername());
        userSoap.setUserEmail(user.getUserEmail());
        userSoap.setUserBusinessName(user.getUserBusinessName());
        userSoap.setUserBusinessId(user.getUserBusinessId());
        userSoap.setUserPassword(user.getUserPassword());
        userSoap.setUserFirstName(user.getUserFirstName());
        userSoap.setUserLastName(user.getUserLastName());
        userSoap.setActivated(true);
        userSoap.setDeleted(false);
        userSoap.setUserType(userTypeConverter(user.getUserType()));

        return userSoap;
    }

    @Override
    public AccType accTypeConverter(AccTypeSoap accTypeSoap) {
        AccType accType = new AccType();
        accType.setAccTypeDbId(accTypeSoap.getAccTypeId());
        accType.setAccTypeName(accTypeSoap.getAccTypeName());
        return accType;
    }

    @Override
    public AccTypeSoap accTypeConverter(AccType accType) {
        AccTypeSoap accTypeSoap = new AccTypeSoap();
        accTypeSoap.setAccTypeId(accType.getAccTypeDbId());
        accTypeSoap.setAccTypeName(accType.getAccTypeName());
        return accTypeSoap;
    }

    @Override
    public AddService addServiceConverter(AddServiceSoap addServiceSoap) {
        AddService addService = new AddService();
        addService.setServiceDbId(addServiceSoap.getServiceId());
        addService.setServiceName(addServiceSoap.getServiceName());
        return addService;
    }

    @Override
    public AddServiceSoap addServiceConverter(AddService addService) {
        AddServiceSoap addServiceSoap = new AddServiceSoap();
        addServiceSoap.setServiceId(addService.getServiceDbId());
        addServiceSoap.setServiceName(addService.getServiceName());
        return addServiceSoap;
    }

    @Override
    public Category categoryConverter(CategorySoap categorySoap) {
        Category category = new Category();
        category.setCategoryDbId(categorySoap.getCategoryId());
        category.setCategoryName(categorySoap.getCategoryName());
        return category;
    }

    @Override
    public CategorySoap categoryConverter(Category category) {
        CategorySoap categorySoap = new CategorySoap();
        categorySoap.setCategoryId(category.getCategoryDbId());
        categorySoap.setCategoryName(category.getCategoryName());
        return categorySoap;
    }

    @Override
    public AccPrice accPriceConverter(AccPriceSoap accPriceSoap) {
        AccPrice accPrice = new AccPrice();
        accPrice.setPriceDbId(accPriceSoap.getPriceId());
        accPrice.setPriceValue(accPriceSoap.getPriceValue());
        accPrice.setPriceStartDate(accPriceSoap.getPriceStartDate());
        accPrice.setPriceEndDate(accPriceSoap.getPriceEndDate());
        return accPrice;
    }

    @Override
    public AccPriceSoap accPriceConverter(AccPrice accPrice) {
        AccPriceSoap accPriceSoap = new AccPriceSoap();
        accPriceSoap.setPriceId(accPrice.getPriceDbId());
        accPriceSoap.setPriceValue(accPrice.getPriceValue());
        accPriceSoap.setPriceStartDate(accPrice.getPriceStartDate());
        accPriceSoap.setPriceEndDate(accPrice.getPriceEndDate());
        return accPriceSoap;
    }

    @Override
    public AccLocation accLocationConverter(AccLocationSoap accLocationSoap) {
        AccLocation accLocation = new AccLocation();
        accLocation.setLocDbId(accLocationSoap.getLocId());
        accLocation.setCity(accLocationSoap.getCity());
        accLocation.setCountry(accLocationSoap.getCountry());
        accLocation.setAddress(accLocationSoap.getAddress());
        accLocation.setXCoordinate(accLocationSoap.getXCoordinate());
        accLocation.setYCoordinate(accLocationSoap.getYCoordinate());
        return accLocation;
    }

    @Override
    public AccLocationSoap accLocationConverter(AccLocation accLocation) {
        AccLocationSoap accLocationSoap = new AccLocationSoap();
        accLocationSoap.setLocId(accLocation.getLocDbId());
        accLocationSoap.setCity(accLocation.getCity());
        accLocationSoap.setCountry(accLocation.getCountry());
        accLocationSoap.setAddress(accLocation.getAddress());
        accLocationSoap.setXCoordinate(accLocation.getXCoordinate());
        accLocationSoap.setYCoordinate(accLocation.getYCoordinate());
        return accLocationSoap;

    }

    @Override
    public AccUnavailable accUnavailableConverter(AccUnavailableSoap accUnavailableSoap) {
        AccUnavailable accUnavailable = new AccUnavailable();
        accUnavailable.setUnavDbId(accUnavailableSoap.getUnavId());
        accUnavailable.setUnavailableStart(accUnavailableSoap.getUnavailableStart());
        accUnavailable.setUnavailableEnd(accUnavailableSoap.getUnavailableEnd());
        return accUnavailable;
    }

    @Override
    public AccUnavailableSoap accUnavailableConverter(AccUnavailable accUnavailable) {
        AccUnavailableSoap accUnavailableSoap = new AccUnavailableSoap();
        accUnavailableSoap.setUnavId(accUnavailable.getUnavDbId());
        accUnavailableSoap.setUnavailableStart(accUnavailable.getUnavailableStart());
        accUnavailableSoap.setUnavailableEnd(accUnavailable.getUnavailableEnd());
        return accUnavailableSoap;
    }

    @Override
    public Message messageConverter(MessageSoap messageSoap) {
        Message message = new Message();
        message.setMessageDbId(messageSoap.getMessageId());
        message.setMessageReservation(reservationService.getOneByDbId(messageSoap.getMessageReservation().getRId()));
        message.setMessageSender(userService.getOneByDbId(messageSoap.getMessageSender().getUserId()));
        message.setMessageReciever(userService.getOneByDbId(messageSoap.getMessageReciever().getUserId()));
        message.setMessageDate(messageSoap.getMessageDate());
        message.setMessageContent(messageSoap.getMessageContent());
        message.setStatus(messageStatusConverter(messageSoap.getStatus()));
        return message;
    }

    @Override
    public MessageSoap messageConverter(Message message) {
        MessageSoap messageSoap = new MessageSoap();
        messageSoap.setMessageId(message.getMessageDbId());
        messageSoap.setMessageReservation(reservationConverter(message.getMessageReservation()));
        messageSoap.setMessageSender(userConverter(message.getMessageSender()));
        messageSoap.setMessageReciever(userConverter(message.getMessageReciever()));
        messageSoap.setMessageDate(message.getMessageDate());
        messageSoap.setMessageContent(message.getMessageContent());
        messageSoap.setStatus(messageStatusConverter(message.getStatus()));
        return messageSoap;

    }

    @Override
    public Reservation reservationConverter(ReservationSoap reservationSoap) {
        Reservation reservation = new Reservation();
        reservation.setrDbId(reservationSoap.getRId());
        reservation.setREndUser(userService.getOneByDbId(reservationSoap.getREndUser().getUserId()));
        reservation.setRAccommodation(accommodationService.getOneByDbId(reservationSoap.getRAccommodation().getAccId()));
        reservation.setRPrice(reservationSoap.getRPrice());
        reservation.setRealized(reservationSoap.isRealized());
        reservation.setCancelled(reservationSoap.isCancelled());
        reservation.setRStartDate(reservationSoap.getRStartDate());
        reservation.setREndDate(reservationSoap.getREndDate());
        reservation.setRDate(reservationSoap.getRDate());
        reservation.setRPeople(reservationSoap.getRPeople().intValue());
        return reservation;
    }

    @Override
    public ReservationSoap reservationConverter(Reservation reservation) {
        ReservationSoap reservationSoap = new ReservationSoap();
        reservationSoap.setRId(reservation.getrDbId());
        reservationSoap.setREndUser(userConverter(reservation.getREndUser()));
        reservationSoap.setRAccommodation(accommodationConverter(reservation.getRAccommodation()));
        reservationSoap.setRPrice(reservation.getRPrice());
        reservationSoap.setRealized(reservation.isRealized());
        reservationSoap.setCancelled(reservation.isCancelled());
        reservationSoap.setRStartDate(reservation.getRStartDate());
        reservationSoap.setREndDate(reservation.getREndDate());
        reservationSoap.setRDate(reservation.getRDate());
        reservationSoap.setRPeople(BigInteger.valueOf( reservation.getRPeople()));
        return reservationSoap;
    }

    @Override
    public Review reviewConverter(ReviewSoap reviewSoap) {
        Review review = new Review();
        review.setReviewDbId(reviewSoap.getReviewId());
        review.setReviewAccommodation(accommodationService.getOneByDbId(reviewSoap.getReviewAccommodation().getAccId()));
        review.setAccDate(reviewSoap.getAccDate());
        review.setCommentApproved(reviewSoap.isCommentApproved());
        review.setReviewComment(reviewSoap.getReviewComment());
        review.setReviewEndUser(userService.getOneByDbId(reviewSoap.getReviewEndUser().getUserId()));
        review.setReviewGrade(reviewSoap.getReviewGrade());
        return review;
    }

    @Override
    public ReviewSoap reviewConverter(Review review) {
        ReviewSoap reviewSoap = new ReviewSoap();
        reviewSoap.setReviewId(review.getReviewId());
        reviewSoap.setReviewAccommodation(accommodationConverter(review.getReviewAccommodation()));
        reviewSoap.setAccDate(review.getAccDate());
        reviewSoap.setCommentApproved(review.isCommentApproved());
        reviewSoap.setReviewComment(review.getReviewComment());
        reviewSoap.setReviewEndUser(userConverter(review.getReviewEndUser()));
        reviewSoap.setReviewGrade(review.getReviewGrade());
        return reviewSoap;
    }

    @Override
    public UserType userTypeConverter(UserTypeSoap userTypeSoap) {
        UserType userType = UserType.ENDUSER;
        switch (userTypeSoap.value()){
            case "AGENT":
                userType = UserType.AGENT;
            case "ADMIN":
                userType = UserType.ADMIN;
        }
        return userType;
    }

    @Override
    public UserTypeSoap userTypeConverter(UserType userType) {
        UserTypeSoap userTypeSoap = UserTypeSoap.ENDUSER;
        switch (userType){
            case AGENT:
                userTypeSoap = UserTypeSoap.AGENT;
            case ADMIN:
                userTypeSoap = UserTypeSoap.ADMIN;
        }
        return userTypeSoap;
    }

    @Override
    public MessageStatus messageStatusConverter(MessageStatusSoap messageStatusSoap) {
        MessageStatus messageStatus = MessageStatus.SENT;
        switch (messageStatusSoap){
            case RECIEVED:
                messageStatus = MessageStatus.RECIEVED;
            case SEEN:
                messageStatus = MessageStatus.SEEN;
        }
        return messageStatus;
    }

    @Override
    public MessageStatusSoap messageStatusConverter(MessageStatus messageStatus) {
        MessageStatusSoap messageStatusSoap = MessageStatusSoap.SENT;
        switch (messageStatus){
            case RECIEVED:
                messageStatusSoap = MessageStatusSoap.RECIEVED;
            case SEEN:
                messageStatusSoap = MessageStatusSoap.SEEN;
        }
        return messageStatusSoap;
    }

    @Override
    public Accommodation accommodationConverter(AccommodationSoap accommodationSoap) {
        Accommodation accommodation = new Accommodation();
        accommodation.setAccDbId(accommodationSoap.getAccId());
        accommodation.setAccName(accommodationSoap.getAccName());
        accommodation.setAccDescription(accommodationSoap.getAccDescription());
        accommodation.setAccCapacity(accommodationSoap.getAccCapacity());
        accommodation.setAccCancelPeriod(accommodationSoap.getAccCancelPeriod());
        accommodation.setAccDate(accommodationSoap.getAccDate());

        //Agent
        accommodation.setAccAgent(userService.getOneByDbId(accommodationSoap.getAccAgent().getUserId()));

        //Lokacija
        AccLocation accLocation = new AccLocation();
        accLocation.setLocDbId(accommodationSoap.getAccLocation().getLocId());
        accLocation.setAddress(accommodationSoap.getAccLocation().getAddress());
        accLocation.setCity(accommodationSoap.getAccLocation().getCity());
        accLocation.setCountry(accommodationSoap.getAccLocation().getCountry());
        accLocation.setXCoordinate(accommodationSoap.getAccLocation().getXCoordinate());
        accLocation.setYCoordinate(accommodationSoap.getAccLocation().getYCoordinate());
        accommodation.setAccLocation(accLocation);

        //Dodatni servisi
        List<AddServiceSoap> addServiceSoapList = accommodationSoap.getAccServices();
        AddService addService = null;
        for (AddServiceSoap addServiceSoap : addServiceSoapList){
            addService = addServiceService.getOneByDbId(addServiceSoap.getServiceId());
            accommodation.getAccServices().add(addService);
        }


        //Kategorija
        Category category = categoryService.getOneByDbId(accommodationSoap.getAccCategory().getCategoryId());
        //category.setCategoryDbId(accommodationSoap.getAccCategory().getCategoryId());
        //category.setCategoryName(accommodationSoap.getAccCategory().getCategoryName());
        accommodation.setAccCategory(category);

        //Tip
        //AccType accType = new AccType();
        //accType.setAccTypeDbId(accommodationSoap.getAccType().getAccTypeId());
        //accType.setAccTypeName(accommodationSoap.getAccType().getAccTypeName());
        AccType accType = accTypeService.getOneByDbId(accommodationSoap.getAccType().getAccTypeId());
        accommodation.setAccType(accType);

        //Plan cena
        AccPrice accPrice = null;
        for (AccPriceSoap accPriceSoap : accommodationSoap.getAccPricePlan()) {
            accPrice = new AccPrice();
            accPrice.setPriceDbId(accPriceSoap.getPriceId());
            accPrice.setPriceStartDate(accPriceSoap.getPriceStartDate());
            accPrice.setPriceEndDate(accPriceSoap.getPriceEndDate());
            accPrice.setPriceValue(accPriceSoap.getPriceValue());
            accommodation.getAccPricePlan().add(accPrice);
        }

        //Zauzetost

        AccUnavailable accUnavailable;
        if (accommodationSoap.getAccUnavailable() != null){
            for (AccUnavailableSoap accUnavailableSoap : accommodationSoap.getAccUnavailable()) {
                accUnavailable = new AccUnavailable();
                accUnavailable.setUnavDbId(accUnavailableSoap.getUnavId());
                accUnavailable.setUnavailableStart(accUnavailableSoap.getUnavailableStart());
                accUnavailable.setUnavailableEnd(accUnavailableSoap.getUnavailableEnd());
                accommodation.getAccUnavailable().add(accUnavailable);
            }
        }

        return accommodation;
    }

    @Override
    public AccommodationSoap accommodationConverter(Accommodation accommodation) {

        AccommodationSoap accSoap = new AccommodationSoap();
        accSoap.setAccId(accommodation.getAccDbId());
        accSoap.setAccName(accommodation.getAccName());
        accSoap.setAccDescription(accommodation.getAccDescription());
        accSoap.setAccCapacity(accommodation.getAccCapacity());
        accSoap.setAccCancelPeriod(accommodation.getAccCancelPeriod());
        accSoap.setAccDate(accommodation.getAccDate());

        //user

        UserSoap userSoap = userConverter(accommodation.getAccAgent());
        accSoap.setAccAgent(userSoap);

        //Lokacija
        AccLocationSoap accLocationSoap = new AccLocationSoap();
        accLocationSoap.setLocId(accommodation.getAccLocation().getLocDbId());
        accLocationSoap.setAddress(accommodation.getAccLocation().getAddress());
        accLocationSoap.setCity(accommodation.getAccLocation().getCity());
        accLocationSoap.setCountry(accommodation.getAccLocation().getCountry());
        accLocationSoap.setXCoordinate(accommodation.getAccLocation().getXCoordinate());
        accLocationSoap.setYCoordinate(accommodation.getAccLocation().getYCoordinate());
        accSoap.setAccLocation(accLocationSoap);

        //Dodatni servisi
        List<AddService> addServiceList = accommodation.getAccServices();
        AddServiceSoap addServiceSoap = null;
        for (AddService addService : addServiceList){
            addServiceSoap = new AddServiceSoap();
            addServiceSoap.setServiceId(addService.getServiceDbId());
            addServiceSoap.setServiceName(addService.getServiceName());
            accSoap.getAccServices().add(addServiceSoap);
        }


        //Kategorija
        CategorySoap categorySoap = new CategorySoap();
        categorySoap.setCategoryId(accommodation.getAccCategory().getCategoryDbId());
        categorySoap.setCategoryName(accommodation.getAccCategory().getCategoryName());
        accSoap.setAccCategory(categorySoap);

        //Tip
        AccTypeSoap accTypeSoap = new AccTypeSoap();
        accTypeSoap.setAccTypeId(accommodation.getAccType().getAccTypeDbId());
        accTypeSoap.setAccTypeName(accommodation.getAccType().getAccTypeName());
        accSoap.setAccType(accTypeSoap);

        //Plan cena
        AccPriceSoap accPriceSoap = null;
        for (AccPrice accPrice : accommodation.getAccPricePlan()) {
            accPriceSoap = new AccPriceSoap();
            accPriceSoap.setPriceStartDate(accPrice.getPriceStartDate());
            accPriceSoap.setPriceEndDate(accPrice.getPriceEndDate());
            accPriceSoap.setPriceValue(accPrice.getPriceValue());
            accSoap.getAccPricePlan().add(accPriceSoap);
        }

        //Zauzetost

        AccUnavailableSoap accUnavailableSoap;
        for (AccUnavailable accUnavailable : accommodation.getAccUnavailable()) {
            accUnavailableSoap = new AccUnavailableSoap();
            accUnavailableSoap.setUnavailableStart(accUnavailable.getUnavailableStart());
            accUnavailableSoap.setUnavailableEnd(accUnavailable.getUnavailableEnd());
            accSoap.getAccUnavailable().add(accUnavailableSoap);
        }
        return accSoap;
    }
}
