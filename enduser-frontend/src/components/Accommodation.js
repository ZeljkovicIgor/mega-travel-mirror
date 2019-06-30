import React from 'react';
import { Container } from 'react-bootstrap';
import { connect } from 'react-redux';
import { Link, Redirect } from 'react-router-dom';
import { accommodationByIdSelector } from '../store/accommodations';
import { userSelector } from '../store/users';

function Accommodation({ getAccommodationById, match, user }) {
  const { id } = match.params;

  const accommodation = getAccommodationById(id);

  return accommodation ? (
    <Container>
      <Link to='/searchAccommodations' className='btn btn-info'>&lt;Nazad</Link>
      <Container style={{width:"50rem", marginTop:"3rem"}}>
        <h2>{ accommodation.accName } </h2>
        <p>{ accommodation.accDescription }</p>
        
        {
          user ?
          <Link to={`/bookAccommodation/${accommodation.accId}`} className='btn btn-primary'>
            Make reservation
          </Link>
          : ''
        }
      </Container>
    </Container>
    
  ) : (
    <Redirect to="/not-found" />
  );
}

function mapStateToProps(state) {
  return {
    getAccommodationById: accommodationByIdSelector(state),
    user: userSelector(state)
  };
}

export default connect(mapStateToProps)(Accommodation);
