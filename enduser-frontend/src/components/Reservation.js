import React, { Component } from 'react';
import { connect } from 'react-redux';
import { Redirect, Link } from 'react-router-dom';
import { reservationByIdSelector } from '../store/reservations';
import { Container, Button } from 'react-bootstrap';
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
          <p>opis</p>
          <Button variant='danger' onClick={() => this.cancelReservation(id)}>Cancel reservation</Button>
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
