import React from 'react'
import { Link } from 'react-router-dom'
import { Card, Button } from 'react-bootstrap';

export default function AccommodationCard ({ accommodation }) {
  return (
    <Card style={{ width: '18rem', float: "left", margin: "10px"}}>
        <Card.Body>
            <Card.Title>
              <Link to={`/accommodations/${accommodation.accId}`}>
                {accommodation.accName}
              </Link>
            </Card.Title>
            <Card.Text>
                {accommodation.accDescription}
            </Card.Text>
            <Button variant="primary">Go somewhere</Button>
        </Card.Body>
    </Card>
  )
}