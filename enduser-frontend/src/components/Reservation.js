import React, { Component } from 'react';
import { connect } from 'react-redux';
import { Redirect, Link } from 'react-router-dom';
import { reservationByIdSelector } from '../store/reservations';
import { Container, Button,  Badge } from 'react-bootstrap';
import { userSelector } from '../store/users';
import Axios from 'axios';

class Reservation extends Component {

  constructor(props){
    super(props);
    this.state = {

    }
  }

  cancelReservation = async (id) => {

    await Axios({
      method:'PUT',
      url: `http://localhost:8080/reservation/cancelReservation/${id}`,
      withCredentials: true
    }).then(() => {
        this.props.history.push('/reservations');
    }).catch((err) => {
        alert(err)
    })
  
  }

  render () {

    const { id } = this.props.match.params;

    const reservation = this.props.getReservationById(id);

    return reservation ? (
      <Container>
        <Link to='/reservations' className='btn btn-info'>&lt;Nazad</Link>
        <Link to={`/messages/${id}`} className='btn btn-info'>Messages</Link>
        <Container style={{width:"50rem", marginTop:"3rem"}}>
          <h2>{ reservation.rAccommodation.accName } </h2>
          <p><b>How many people are staying: </b>{reservation.rPeople}</p>
          <p><b>Reservation start: </b>{reservation.rStartDate.split('T')[0]}</p>
          <p><b>Reservation end: </b>{reservation.rEndDate.split('T')[0]}</p>
          <p><b>Price: </b>{reservation.rPrice}</p>

          <h3>Accommodation information:</h3>

          <p><b>Name: </b>{ reservation.rAccommodation.accName } </p>
          <p><b>Address: </b>{reservation.rAccommodation.accLocation.address},&nbsp;
            {reservation.rAccommodation.accLocation.city},&nbsp;
            {reservation.rAccommodation.accLocation.country}</p>
          <p><b>Averate rating:</b> { reservation.rAccommodation.accAvgRating }</p>
          <p><b>Description:</b>{ reservation.rAccommodation.accDescription }</p>
          <p><b>Cancel period:</b>{ reservation.rAccommodation.accCancelPeriod }</p>
          <p><b>Capacity:</b>{ reservation.rAccommodation.accCapacity }</p>
          <p><b>Category:</b>{ reservation.rAccommodation.accCategory.categoryName }</p>
          <p><b>Type:</b>{ reservation.rAccommodation.accType.accTypeName }</p>
          <h4>Price plan:</h4>
          <ul>
          {
            reservation.rAccommodation.accPricePlan.map(price => (
              <li>{price.priceStartDate.split('T')[0]} to {price.priceEndDate.split('T')[0]} | {price.priceValue}</li>
            ))
          }
          </ul>
          <h4>Additional services:</h4>
          <div>
            {
              reservation.rAccommodation.accServices.map(service => (
                <Badge variant='info'>{service.serviceName}</Badge> 
              ))
            }
          </div>

          <hr/>

          <Button variant='danger' onClick={() => this.cancelReservation(id)}>Cancel reservation</Button>
          <br/>
          <br/>
        </Container>
      </Container>
      
    ) : (
      <Redirect to="/not-found" />
    )
  }
}

function mapStateToProps(state) {
  return {
    getReservationById: reservationByIdSelector(state),
    user: userSelector(state)
  };
}

export default connect(mapStateToProps)(Reservation);
