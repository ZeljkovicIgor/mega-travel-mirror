import React, { Component } from 'react';
import { Button, Container, Form } from 'react-bootstrap';
import { connect } from 'react-redux';
import { register } from '../store/users';

class RegisterForm extends Component {
    constructor (props) {
        super(props);
        this.state = {
            username: '',
            password: '',
            firstName: '',
            lastName: '',
            email: ''
        }
    }

    handleSubmit = event => {
        event.preventDefault();
        const user = this.state;
        this.props.register(user).then(() => {
            this.props.history.push('/login');
        }).catch((error) => {
            console.log(error);
        })
    }

    render () {
        return (
            <Container style={{width:"25rem", marginTop:"3rem"}}>
                <h2>Registration</h2>
                <br/>
                <Form
                    onSubmit={this.handleSubmit}
                >
                    <Form.Group>
                        <Form.Control
                            type='email'
                            placeholder='Email'
                            onInput={ event => { this.setState({ email: event.target.value })}}
                        />
                    </Form.Group>
                    <Form.Group>
                        <Form.Control
                            type='text'
                            placeholder='Username'
                            onInput={ event => { this.setState({ username: event.target.value })}}
                        />
                    </Form.Group>
                    <Form.Group>
                        <Form.Control
                            type='text'
                            placeholder='Password'
                            onInput={ event => { this.setState({ password: event.target.value })}}
                        />
                    </Form.Group>
                    <Form.Group>
                        <Form.Control
                            type='text'
                            placeholder='First Name'
                            onInput={ event => { this.setState({ firstName: event.target.value })}}
                        />
                    </Form.Group>
                    <Form.Group>
                        <Form.Control
                            type='text'
                            placeholder='Last Name'
                            onInput={ event => { this.setState({ lastName: event.target.value })}}
                        />
                    </Form.Group>
                    <Button
                        variant="primary"
                        type="submit"
                    >
                        Register
                    </Button>
                </Form>
            </Container>
        )
    }
}

function mapDispatchToProps(dispatch) {
    return {
        register: user => dispatch(register(user))
    }
}

export default connect(null, mapDispatchToProps)(RegisterForm);