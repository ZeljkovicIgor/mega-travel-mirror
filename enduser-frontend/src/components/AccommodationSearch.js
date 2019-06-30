import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Form, InputGroup } from 'react-bootstrap';
import { connect } from 'react-redux';
import { Link } from 'react-router-dom';
import { getAccommodations } from '../store/accommodations/actionCreators';
import { getSearch } from '../store/search/actionCreators';

class AccommodationSearch extends Component {
    constructor (props) {
        super(props);
        this.state = {
            city: '',
            startDate: '',
            endDate: '',
            people: '',
            accTypeId: '',
            categoryId: '',
            addServices: []
        }
    }

    handleSubmit = (event) => {
        event.preventDefault();
        const searchDTO = this.state;
        
        this.props.searchAccommodations(searchDTO).then(() => {
            this.props.setSearch(searchDTO);
            this.props.history.push('/searchAccommodations');
        }).catch((error) => {
            console.log(error);
        })
    }

    render () {
        return (
            <Container style={{width:"50rem", marginTop:"3rem"}}>
                <h2>Find accommodations</h2>
                <Form onSubmit={this.handleSubmit}>
                    <Form.Group>
                        <Form.Label>Where are you going?</Form.Label>
                        <Form.Control
                            onInput={ event => { this.setState({ city: event.target.value })}}
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
                                onInput={ event => { this.setState({ startDate: event.target.value })}}
                                type='date'
                            />
                            <InputGroup.Prepend><InputGroup.Text>To</InputGroup.Text></InputGroup.Prepend>
                            <Form.Control
                                onInput={ event => { this.setState({ endDate: event.target.value })}}
                                type='date'
                            />
                        </InputGroup>
                    </Form.Group>
                    <Form.Group>
                        <Form.Label>How many people?</Form.Label>
                        <Form.Control
                            onInput={ event => { this.setState({ people: event.target.value })}}
                            style={{width:"5rem"}}
                            size='lg'
                            type='number'
                            min='1'
                        />
                    </Form.Group>
                    <ButtonGroup>
                        <Button
                            variant='primary'
                            type='submit'

                        >
                            Search
                        </Button>
                        <Link className='btn btn-info' to='/advancedSearch'>
                            Advanced Search
                        </Link>
                    </ButtonGroup>
                    
                </Form>
            </Container>
        )
    }
}

function mapDispatchToProps (dispatch) {
    return {
        searchAccommodations: search => dispatch(getAccommodations(search)),
        setSearch: search => dispatch(getSearch(search))
    }
}

export default connect(null, mapDispatchToProps)(AccommodationSearch);