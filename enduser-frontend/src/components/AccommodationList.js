import React, { Component } from 'react';
import AccommodationCard from './AccommodationCard';
import { accommodationsSelector } from '../store/accommodations'
import { connect } from 'react-redux';

class AccommodationList extends Component {

    render() {
        const { accommodations } = this.props;

        return (
            <div>
                {
                    accommodations.map(accommodation => (
                        <AccommodationCard accommodation={accommodation} key={accommodation.accId}/>
                    ))
                }
            </div>
        )
    }
}

function mapStateToProps(state){
    return{
        accommodations: accommodationsSelector(state)
    }
}

export default connect(mapStateToProps)(AccommodationList)