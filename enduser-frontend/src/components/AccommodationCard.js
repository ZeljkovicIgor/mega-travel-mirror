import React from 'react'
import { Link } from 'react-router-dom'
import { Card, Button, Badge } from 'react-bootstrap';

export default function AccommodationCard ({ accommodation }) {
  return (
    <Card style={{ width: '18rem', float: "left", margin: "10px", height:'20rem'}}>
        <Card.Body>
            <span style={{float:'right'}}><Badge pill variant='warning'>{accommodation.accAvgRating}</Badge></span>
            <Card.Title>
              <Link to={`/accommodations/${accommodation.accId}`}>
                {accommodation.accName}
              </Link>
            </Card.Title>
            <Card.Subtitle>
              {accommodation.accType.accTypeName}
            </Card.Subtitle>
            <Card.Text>
                Kapacitet:{accommodation.accCapacity}
            </Card.Text>
            <Card.Text style={{overflowY:'auto', height:'6rem'}}>
                {accommodation.accDescription}
            </Card.Text>
        </Card.Body>
        <Card.Footer>
          <Card.Subtitle>
            {accommodation.accLocation.address},<br/>
            {accommodation.accLocation.city},<br/>
            {accommodation.accLocation.country}
          </Card.Subtitle>
        </Card.Footer>
    </Card>
  )
}