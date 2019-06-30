import React, { Component } from 'react'
import Axios from 'axios';
import { Container, Button } from 'react-bootstrap';
import { userSelector } from '../store/users';
import { connect } from 'react-redux';
import { Form, InputGroup } from 'react-bootstrap';
import { reservationByIdSelector } from '../store/reservations';

const url = 'http://localhost:8080/message/'

class MessagesList extends Component {

    state = {
        messages: [],
        idReservation: '',
        idReciever: '',
        messageContent: ''
    }

    async componentDidMount () {
        const { data : recieved } = await Axios.get( url + 'getRecievedMessages', {withCredentials:true});
        const { data : sent } = await Axios.get( url + 'getSendMessages', {withCredentials:true});

        const allMessages = recieved.concat(sent).filter(message => (
            message.messageReservation.rid === Number(this.props.match.params.id)
        )).sort(function(a, b){
            const da = new Date(a.messageDate)
            const db = new Date(b.messageDate)
            return da - db
        })

        const id = this.props.match.params.id
        const reservation = this.props.reservationById(id)
        let idReciever = ''

        if(reservation !== undefined)
            idReciever = reservation.rAccommodation.accAgent.userId;

        this.setState({
            messages: allMessages,
            idReservation: this.props.match.params.id,
            idReciever: idReciever
        })

        console.log(this.state)
    }

    handleSubmit = async (event) => {
        event.preventDefault()
        const toSend = {
            messageContent: this.state.messageContent
        }
        const {idReciever} = this.state
        const {idReservation} = this.state

        await Axios.post(`${url}send/${idReciever}/${idReservation}`, toSend, {withCredentials:true})
        this.componentDidMount()
        this.myFormRef.reset();

        var el = document.getElementById('lastone');
        el.scrollTop = 1000;
    }

    render () {

        return (
            <Container style={{width:"50rem"}}>
                <Container style={{overflowY:"auto", height:"25rem"}}>
                    {
                        this.state.messages.map(message => {
                            if(this.props.user.userId === message.messageSender.userId){
                                return (
                                    <div>
                                        <p title={message.messageDate}>
                                            <b>{message.messageSender.userFirstName}: </b>
                                            {message.messageContent}
                                        </p>
                                    </div>
                                )
                            }else{
                                return (
                                    <div>
                                        <p title={message.messageDate}>
                                            <b>{message.messageSender.userFirstName}: </b>
                                            {message.messageContent}
                                        </p>
                                    </div>
                                )
                            }
                        })
                    }
                    <div id='lastone' hidden></div>
                </Container>
                <Form onSubmit={this.handleSubmit} ref={(el) => this.myFormRef = el}>
                    <InputGroup>
                        <Form.Control onInput={ event => { this.setState({ messageContent: event.target.value })}} placeholder='Write a message...'/>
                        <InputGroup.Append>
                            <Button type='submit'>
                                Send
                            </Button>
                        </InputGroup.Append>                        
                    </InputGroup>
                </Form>
            </Container>
        )
    }

}

function mapStateToProps(state){
    return {
        user: userSelector(state),
        reservationById: reservationByIdSelector(state)
    }
}

export default connect(mapStateToProps)(MessagesList)