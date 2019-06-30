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
                opis
            </Card.Text>
        </Card.Body>
    </Card>
    )
}