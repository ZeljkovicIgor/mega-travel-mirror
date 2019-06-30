import React, { Component } from 'react';
import ReservationCard from './ReservationCard';
import { connect } from 'react-redux'
import { reservationsSelector } from '../store/reservations'
import { getReservations } from '../store/reservations/actionCreators'

class ReservationList extends Component {

    async componentDidMount(){
        await this.props.getReservations()
    }

    render() {
        const { reservations } = this.props;

        return (
            <div>
                {
                    reservations.map( reservation => (
                        <ReservationCard reservation={reservation} key={reservation.rId} />
                    ))
                }
            </div>
        )
    }
}

function mapStateToProps(state){
    return{
        reservations: reservationsSelector(state)
    }
}

function mapDispatchToProps(dispatch){
    return {
        getReservations: () => dispatch(getReservations())
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(ReservationList)