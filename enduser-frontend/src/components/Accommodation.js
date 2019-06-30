import React from 'react';
import { Container, Badge } from 'react-bootstrap';
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
        <p><b>
          {accommodation.accLocation.address},&nbsp;
          {accommodation.accLocation.city},&nbsp;
          {accommodation.accLocation.country}
        </b></p>
        <p><b>Averate rating:</b> { accommodation.accAvgRating }</p>
        <p><b>Description:</b>{ accommodation.accDescription }</p>
        <p><b>Cancel period:</b>{ accommodation.accCancelPeriod }</p>
        <p><b>Capacity:</b>{ accommodation.accCapacity }</p>
        <p><b>Category:</b>{ accommodation.accCategory.categoryName }</p>
        <p><b>Type:</b>{ accommodation.accType.accTypeName }</p>
        <h4>Price plan:</h4>
        <ul>
        {
          accommodation.accPricePlan.map(price => (
            <li>{price.priceStartDate.split('T')[0]} to {price.priceEndDate.split('T')[0]} | {price.priceValue}</li>
          ))
        }
        </ul>
        <h4>Additional services:</h4>
        <div>
          {
            accommodation.accServices.map(service => (
              <Badge variant='info'>{service.serviceName}</Badge> 
            ))
          }
        </div>
        
        <hr/>

        {
          user ?
          <Link to={`/bookAccommodation/${accommodation.accId}`} className='btn btn-primary'
            style={{marginBottom:'2rem'}}
          >
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
