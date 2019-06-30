import React from 'react';
import { Card } from 'react-bootstrap';
import { Link } from 'react-router-dom';

export default function ReservationCard ({ reservation }) {
    return (
        <Card style={{ width: '18rem', float: "left", margin: "10px"}}>
        <Card.Body>
            <Card.Title>
              <Link to={`/reservations/${reservation.rId}`}>
                {reservation.rAccommodation.accName}
              </Link>
            </Card.Title>
            <Card.Text>
                {reservation.rPeople} people are staying from&nbsp;
                {reservation.rStartDate.split('T')[0]} to&nbsp;
                {reservation.rEndDate.split('T')[0]} for only...
            </Card.Text>
        </Card.Body>
        <Card.Footer style={{textAlign:'right'}}>
          {reservation.rPrice}
        </Card.Footer>
    </Card>
    )
}