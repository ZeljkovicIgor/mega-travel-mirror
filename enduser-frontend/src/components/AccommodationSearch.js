import React, { Component } from 'react';
import { Form, Container } from 'react-bootstrap';

class AccommodationSearch extends Component {
    constructor (props) {
        super(props);
        this.state = {
            searchField: ''
        }
    }

    render () {
        return (
            <Container style={{width:"50rem", marginTop:"10rem"}}>
                <Form>
                    <Form.Control
                        size='lg'
                        type='text'
                        placeholder='Search accommodation'
                    />
                </Form>
            </Container>
        )
    }
}

export default AccommodationSearch;