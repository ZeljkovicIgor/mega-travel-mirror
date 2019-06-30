import React, { Component } from 'react';
import { Container, Form, InputGroup, Button, Row, Col } from 'react-bootstrap';
import { accommodationByIdSelector } from '../store/accommodations';
import { connect } from 'react-redux'
import Axios from 'axios';

class ReservationForm extends Component {

    constructor (props) {
        super(props);
        this.state = {
            rstartDate: '',
            rendDate: '',
            rpeople: '',
            raccommodation: {},
            rprice: 0
        }
        this.otherState = {
            selectedPlan: null
        }
    }

    componentDidMount(){
        const { id } = this.props.match.params;
        const raccommodation = this.props.getAccommodationById( id );

        this.setState({
            ...this.state,
            raccommodation
        })
    }

    handleSubmit = async (event) => {
        event.preventDefault();
        
        await Axios({
            method:'POST',
            url: 'http://localhost:8080/reservation/addReservation',
            data: this.state,
            withCredentials: true
        }).then(() => {
            this.props.history.push('/reservations');
        }).catch(() => {
            this.props.history.push('/reservations');
        })

    }

    handleInput = async (event, name) => {
        await this.setState({
            [name]: event.target.value
        })

        this.calculatePrice()
    }

    handleChange = async (event) => {
        const { accPricePlan } = this.state.raccommodation;
        let price = accPricePlan.find(price => Number(price.priceId) === Number(event.target.value) ) 

        this.otherState = {
            selectedPlan: price
        }
    }

    calculatePrice = () => {

        // let pricePlan = this.state.raccommodation.accPricePlan.sort(function(a, b){
        //     let sa = new Date(a.priceStartDate);
        //     let sb = new Date(b.priceStartDate);
        //     return sa - sb
        // });
        const startDate = new Date(this.state.rstartDate);
        const endDate = new Date(this.state.rendDate);
        const pricePlanStart = this.otherState.selectedPlan ? 
                                    new Date( this.otherState.selectedPlan.priceStartDate )
                                    : new Date('')
        const pricePlanEnd = this.otherState.selectedPlan ?
                                    new Date( this.otherState.selectedPlan.priceEndDate )
                                    : new Date('')

        let totalPrice = 0;

        // pricePlan.forEach(( price ) => {
        //     var pStart = new Date(price.priceStartDate)
        //     var pEnd = new Date(price.priceEndDate)

        //     if(startDate > pStart && startDate < pEnd && endDate < pEnd && endDate > pStart){

        //         const diffTime = Math.abs(endDate.getTime() - startDate.getTime());
        //         const diffDays = Math.ceil(diffTime / (1000 * 60 * 60 * 24));
        //         totalPrice = totalPrice + diffDays * price.priceValue * this.state.rpeople;

        //     }else if(startDate < pStart && endDate > pStart && endDate < pEnd){

        //         const diffTime = Math.abs(endDate.getTime() - pStart.getTime());
        //         const diffDays = Math.ceil(diffTime / (1000 * 60 * 60 * 24));
        //         totalPrice = totalPrice + diffDays * price.priceValue * this.state.rpeople;

        //     }else if(startDate < pEnd && endDate > pEnd && startDate > pStart){

        //         const diffTime = Math.abs(pEnd.getTime() - startDate.getTime());
        //         const diffDays = Math.ceil(diffTime / (1000 * 60 * 60 * 24));
        //         totalPrice = totalPrice + diffDays * price.priceValue * this.state.rpeople;

        //     }else if(startDate < pStart && endDate > pEnd){

        //         const diffTime = Math.abs(pEnd.getTime() - pStart.getTime());
        //         const diffDays = Math.ceil(diffTime / (1000 * 60 * 60 * 24));
        //         totalPrice = totalPrice + diffDays * price.priceValue * this.state.rpeople;

        //     }
        // });

        if( startDate < pricePlanStart || 
            startDate > pricePlanEnd || 
            endDate < pricePlanStart || 
            endDate > pricePlanEnd ) {
                alert('Odabrali ste datum van granica ovog plana cena.')
                this.myFormRef.reset();
                this.setState({
                    rstartDate: '',
                    rendDate: ''
                })
                return
        }else{
            let price = this.otherState.selectedPlan || { priceValue: 0 }

            const diffTime = Math.abs(endDate.getTime() - startDate.getTime());
            const diffDays = Math.ceil(diffTime / (1000 * 60 * 60 * 24));
            totalPrice = diffDays * price.priceValue * this.state.rpeople;

            this.setState({
                rprice: totalPrice
            })
        }
        
        
    }

    render () {

        const { id } = this.props.match.params;
        const accommodation = this.props.getAccommodationById( id );

        return (
            <Container style={{width:"50rem", marginTop:"3rem"}}>
                <h2>Rezervacija akomodacije { accommodation.accName }</h2>
                <Form onSubmit={this.handleSubmit} ref={(el) => this.myFormRef = el} >
                    <Form.Group>
                        <Form.Label>Choose the price plan.</Form.Label>
                        <Form.Control as='select' onChange={this.handleChange}>
                            <option></option>
                            {
                                accommodation.accPricePlan.map(plan => (
                                    <option value={plan.priceId} key={plan.priceId}>
                                        {plan.priceStartDate.split('T')[0]} do {plan.priceEndDate.split('T')[0]} 
                                        &nbsp;|
                                        jednodnevna cena za jednu osobu: {plan.priceValue}
                                    </option>
                                ))
                            }
                        </Form.Control>
                    </Form.Group>
                    <Form.Group>
                        <Form.Label>How much are you staying?</Form.Label>
                        <InputGroup>
                            <InputGroup.Prepend><InputGroup.Text>From</InputGroup.Text></InputGroup.Prepend>
                            <Form.Control
                                onInput={ event => this.handleInput(event, 'rstartDate')}
                                type='date'
                            />
                            <InputGroup.Prepend><InputGroup.Text>To</InputGroup.Text></InputGroup.Prepend>
                            <Form.Control
                                onInput={ event => this.handleInput(event, 'rendDate')}
                                type='date'
                            />
                        </InputGroup>
                    </Form.Group>
                    <Form.Group>
                        <Form.Label>How many people?</Form.Label>
                        <Form.Control
                            onInput={ event => this.handleInput(event, 'rpeople')}
                            style={{width:"5rem"}}
                            size='lg'
                            type='number'
                            min='1'
                            max={ accommodation.accCapacity }
                        />
                    </Form.Group>
                    <hr></hr>
                    <Row>
                        <Col md={4}>
                            <Button type='submit' variant='primary'>Book accommodation</Button>
                        </Col>
                        <Col md={{ span: 4, offset: 4 }}>
                            <InputGroup>
                                <InputGroup.Prepend>
                                    <InputGroup.Text>Total:</InputGroup.Text>
                                </InputGroup.Prepend>
                                <Form.Control disabled value={this.state.rprice}></Form.Control>
                                <InputGroup.Append><InputGroup.Text>$</InputGroup.Text></InputGroup.Append>
                            </InputGroup>
                        </Col>
                    </Row>
                </Form>
            </Container>
        )
    }

}

function mapStateToProps(state){
    return {
        getAccommodationById: accommodationByIdSelector(state)
    }
}

export default connect(mapStateToProps, null)(ReservationForm)