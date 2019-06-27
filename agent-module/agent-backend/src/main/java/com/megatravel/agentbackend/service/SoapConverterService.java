package com.megatravel.agentbackend.service;

import com.megatravel.agentbackend.model.*;
import com.megatravel.agentbackend.ws.*;
import org.springframework.stereotype.Service;

public interface SoapConverterService {

     Accommodation accommodationConverter(AccommodationSoap accommodationSoap);
     AccommodationSoap accommodationConverter(Accommodation accommodation);

     User userConverter(UserSoap userSoap);
     UserSoap userConverter(User user);

     AccType accTypeConverter(AccTypeSoap accTypeSoap);
     AccTypeSoap accTypeConverter(AccType accType);

     AddService addServiceConverter(AddServiceSoap addServiceSoap);
     AddServiceSoap addServiceConverter(AddService addService);

     Category categoryConverter(CategorySoap categorySoap);
     CategorySoap categoryConverter(Category category);

     AccPrice accPriceConverter(AccPriceSoap accPriceSoap);
     AccPriceSoap accPriceConverter(AccPrice accPrice);

     AccLocation accLocationConverter(AccLocationSoap accLocationSoap);
     AccLocationSoap accLocationConverter(AccLocation accLocation);

     AccUnavailable accUnavailableConverter(AccUnavailableSoap accUnavailableSoap);
     AccUnavailableSoap accUnavailableConverter(AccUnavailable accUnavailable);

     Message messageConverter(MessageSoap messageSoap);
     MessageSoap messageConverter(Message message);

     Reservation reservationConverter(ReservationSoap reservationSoap);
     ReservationSoap reservationConverter(Reservation reservation);

     Review reviewConverter(ReviewSoap reviewSoap);
     ReviewSoap reviewConverter(Review review);

     UserType userTypeConverter(UserTypeSoap userTypeSoap);
     UserTypeSoap userTypeConverter(UserType userType);

     MessageStatus messageStatusConverter(MessageStatusSoap messageStatusSoap);
     MessageStatusSoap messageStatusConverter(MessageStatus messageStatus);



}
