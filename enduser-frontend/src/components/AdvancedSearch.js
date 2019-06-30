import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Form, InputGroup } from 'react-bootstrap';
import { connect } from 'react-redux';
import { Link } from 'react-router-dom';
import { getAccommodations } from '../store/accommodations/actionCreators';
import { accTypesSelector } from '../store/acc_types';
import { getAccommodationTypes } from '../store/acc_types/actionCreators';
import { categoriesSelector } from '../store/categories';
import { getCategories } from '../store/categories/actionCreators';
import Axios from 'axios';
import Select from 'react-select';
import { getSearch } from '../store/search/actionCreators';

class AccommodationSearch extends Component {
    
    state = {
        search: {
            city: '',
            startDate: '',
            endDate: '',
            people: '',
            accTypeId: '',
            categoryId: '',
            addServices: []
        },
        allServices: [],
        selectedOption: null
    }

    async componentDidMount(){
        this.props.getAccommodationTypes()
        this.props.getCategories()
        const { data : services } = await Axios.get('http://localhost:8080/addServices/')
        this.setState({
            ...this.state,
            allServices: services.map(service => ({ value: service.serviceId, label: service.serviceName }))
        })
    }

    handleSubmit = (event) => {
        event.preventDefault();
        const searchDTO = this.state.search;
        this.props.searchAccommodations(searchDTO, true).then(() => {
            this.props.setSearch(searchDTO);
            this.props.history.push('/searchAccommodations');
        }).catch((error) => {
            console.log(error);
        })
    }

    handleInput = (event, name) => {
        this.setState({
            ...this.state,
            search: {
                ...this.state.search,
                [name]: event.target.value
            }
        })
    }

    handleChange = (selectedOption) => {
        this.setState({
            ...this.state,
            search: {
                ...this.state.search,
                addServices: [ ...selectedOption.map(option => option.value) ]
            },
            selectedOption
        })
    }

    render () {

        const { accTypes } = this.props;
        const { categories } = this.props;

        return (
            <Container style={{width:"50rem", marginTop:"3rem"}}>
                <h2>Find accommodations</h2>
                <Form onSubmit={this.handleSubmit}>
                    <Form.Group>
                        <Form.Label>Where are you going?</Form.Label>
                        <Form.Control
                            onInput={ event => this.handleInput(event, 'city')}
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
                                onInput={ event => this.handleInput(event, 'startDate')}
                                type='date'
                            />
                            <InputGroup.Prepend><InputGroup.Text>To</InputGroup.Text></InputGroup.Prepend>
                            <Form.Control
                                onInput={ event => this.handleInput(event, 'endDate')}
                                type='date'
                            />
                        </InputGroup>
                    </Form.Group>
                    <Form.Group>
                        <Form.Label>How many people?</Form.Label>
                        <Form.Control
                            onInput={ event => this.handleInput(event, 'people')}
                            style={{width:"5rem"}}
                            size='lg'
                            type='number'
                            min='1'
                        />
                    </Form.Group>
                    <Form.Group>
                        <Form.Label>Accommodation type</Form.Label>
                        <Form.Control
                            onInput={ event => this.handleInput(event, 'accTypeId')}
                            as='select'
                        >
                            <option value=''></option>
                            {
                                accTypes.map(type => (
                                    <option key={type.accTypeId} value={type.accTypeId}>{type.accTypeName}</option>
                                ))
                            }
                        </Form.Control>
                    </Form.Group>
                    <Form.Group>
                        <Form.Label>Accommodation category</Form.Label>
                        <Form.Control
                            onInput={ event => this.handleInput(event, 'categoryId')}
                            as='select'
                        >
                            <option value=""></option>
                            {
                                categories.map(category => (
                                    <option key={category.categoryId} value={category.categoryId}>{category.categoryName}</option>
                                ))
                            }
                        </Form.Control>
                    </Form.Group>
                    <Form.Group>
                        <Form.Label>Additional services</Form.Label>
                        <Select
                            isMulti
                            value={ this.state.selectedOption }
                            options={ this.state.allServices }
                            onChange={ this.handleChange }
                        />
                    </Form.Group>
                    <ButtonGroup>
                        <Button
                            variant='primary'
                            type='submit'
                        >
                            Search
                        </Button>
                        <Link className='btn btn-info' to='/'>
                            Basic Search
                        </Link>
                    </ButtonGroup>
                    
                </Form>
            </Container>
        )
    }
}

function mapStateToProps (state) {
    return {
        accTypes: accTypesSelector(state),
        categories: categoriesSelector(state)
    }
}

function mapDispatchToProps (dispatch) {
    return {
        searchAccommodations: search => dispatch(getAccommodations(search, true)),
        getAccommodationTypes: () => dispatch(getAccommodationTypes()),
        getCategories: () => dispatch(getCategories()),
        setSearch: search => dispatch(getSearch(search))
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(AccommodationSearch);