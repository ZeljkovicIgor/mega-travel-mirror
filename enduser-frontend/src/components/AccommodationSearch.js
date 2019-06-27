import Axios from 'axios';
import React, { Component } from 'react';
import { Button, Container, Form, InputGroup } from 'react-bootstrap';

class AccommodationSearch extends Component {
    constructor (props) {
        super(props);
        this.state = {
            searchField: ''
        }
    }

    async componentDidMount() {
        const { data } = await Axios.get(
            'http://localhost:8080/user/getLogged',
            {withCredentials: true}
        )

        console.log(data);
    }

    render () {
        return (
            <Container style={{width:"50rem", marginTop:"3rem"}}>
                <h2>Find accommodations</h2>
                <Form>
                    <Form.Group>
                        <Form.Label>Where are you going?</Form.Label>
                        <Form.Control
                            size='lg'
                            type='text'
                            placeholder='Search places...'
                            autoFocus
                        />
                        </Form.Group>
                    <Form.Group>
                        <Form.Label>How much are you staying?</Form.Label>
                        <InputGroup>
                            <InputGroup.Prepend><InputGroup.Text>From</InputGroup.Text></InputGroup.Prepend>
                            <Form.Control
                                type='date'
                            />
                            <InputGroup.Prepend><InputGroup.Text>To</InputGroup.Text></InputGroup.Prepend>
                            <Form.Control
                                type='date'
                            />
                        </InputGroup>
                    </Form.Group>
                    <Form.Group>
                        <Form.Label>How many people?</Form.Label>
                        <Form.Control
                            style={{width:"5rem"}}
                            size='lg'
                            type='number'
                            min='1'
                        />
                    </Form.Group>
                    <Button
                        variant='primary'
                        type='submit'

                    >
                        Search
                    </Button>
                </Form>
            </Container>
        )
    }
}

export default AccommodationSearch;