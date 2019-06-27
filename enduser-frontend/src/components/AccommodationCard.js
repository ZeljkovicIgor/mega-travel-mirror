import React from 'react'
import { Link } from 'react-router-dom'
import { Card, Button } from 'react-bootstrap';

export default function AccommodationCard ({ accommodation }) {
  return (
    <Card style={{ width: '18rem' }}>
        <Card.Body>
            <Card.Title>{accommodation.accName}</Card.Title>
            <Card.Text>
                {accommodation.accDescription}
            </Card.Text>
            <Button variant="primary">Go somewhere</Button>
        </Card.Body>
    </Card>
  )
}