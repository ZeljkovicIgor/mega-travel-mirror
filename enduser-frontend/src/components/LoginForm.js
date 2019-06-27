import React, { Component } from 'react';
import { connect } from 'react-redux';
import { login } from '../store/users';
import { Form, Container, Button } from 'react-bootstrap';

class LoginForm extends Component {
    constructor (props) {
        super(props);
        this.state = {
            email: '',
            password: ''
        }
    }

    handleSubmit = (event) => {
        event.preventDefault();
        const { email, password } = this.state;

        this.props.login(email, password);
    }

    render () {
        return (
            <Container style={{width:"25rem", marginTop:"3rem"}}>
                <h2>Sign in</h2>
                <br/>
                <Form
                    onSubmit={ this.handleSubmit }
                >
                    <Form.Group controlId="formBasicEmail">
                        <Form.Label>Email address</Form.Label>
                        <Form.Control
                            type="email"
                            placeholder="Enter email"
                            onInput={ event => { this.setState({ email: event.target.value })}}
                            autoFocus
                        />
                    </Form.Group>
                    <Form.Group>
                        <Form.Label>Password</Form.Label>
                        <Form.Control
                            type="password"
                            placeholder="Password"
                            onInput={ event => { this.setState({ password: event.target.value })}}
                        />
                    </Form.Group>
                    <Button
                        variant="primary"
                        type="submit"
                    >
                        Sign in
                    </Button>
                </Form>
            </Container>
        )
    }
}

function mapDispatchToProps(dispatch) {
    return {
        login: (email, password) => dispatch(login(email, password))
    }
}

export default connect( null,  mapDispatchToProps)(LoginForm)