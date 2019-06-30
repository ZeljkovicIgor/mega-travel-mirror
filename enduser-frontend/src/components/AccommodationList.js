import React, { Component } from 'react';
import { connect } from 'react-redux';
import { accommodationsSelector, sortAccommodations } from '../store/accommodations';
import { searchSelector } from '../store/search';
import AccommodationCard from './AccommodationCard';
import { Button, ButtonToolbar, Container } from 'react-bootstrap';
import Axios from 'axios';

class AccommodationList extends Component {

    handleSort = async (event, path) => {
        console.log(path)
        const { data : accommodations } = await Axios({
            method: 'POST',
            url: `http://localhost:8080/accommodation/${path}`,
            data: this.props.search,
            withCredentials: true
        })

        this.props.sort([])
        this.props.sort(accommodations)
    }

    render() {
        const { accommodations } = this.props;
        const { search } = this.props;

        return (
            <Container>
                <ButtonToolbar>
                    <Button variant='outline-secondary' onClick={(event) => this.handleSort(event, 'sortByPriceAsc')}>Price ^</Button>
                    <Button variant='outline-secondary' onClick={(event) => this.handleSort(event, 'sortByPriceDesc')}>Price v</Button>
                    <Button variant='outline-secondary' onClick={(event) => this.handleSort(event, 'sortByReviewGradeAsc')}>Grade ^</Button>
                    <Button variant='outline-secondary' onClick={(event) => this.handleSort(event, 'sortByReviewGradeDesc')}>Grade v</Button>
                    <Button variant='outline-secondary' onClick={(event) => this.handleSort(event, 'sortByCategoryAsc')}>Category ^</Button>
                    <Button variant='outline-secondary' onClick={(event) => this.handleSort(event, 'sortByCategoryDesc')}>Category v</Button>
                </ButtonToolbar>
                
                {
                    accommodations.map(accommodation => (
                        <AccommodationCard accommodation={accommodation} key={accommodation.accId}/>
                    ))
                }
            </Container>
        )
    }
}

function mapStateToProps(state){
    return{
        accommodations: accommodationsSelector(state),
        search: searchSelector(state)
    }
}

function mapDispatchToProps(dispatch){
    return {
        sort: accommodations => dispatch(sortAccommodations(accommodations))
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(AccommodationList)