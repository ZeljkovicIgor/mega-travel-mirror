import React from 'react';
import { Link } from 'react-router-dom';
import { userSelector, logout } from '../store/users';
import { connect } from 'react-redux';
import { Navbar, Button } from 'react-bootstrap';
import logo from '../logo.svg';

function AppHeader ({ user, onLogout }) {
    return (
        <Navbar>
            <Navbar.Brand>
                <Link to="/" className="navbar-brand">mega-travel<img src={logo} className="App-logo" alt="logo" /></Link>
            </Navbar.Brand>
            {
                user
                ? 
                <Navbar.Collapse className="justify-content-end">
                    <Button
                        variant="outline-danger"
                        type='button'
                        onClick={onLogout}
                    >
                        Logout
                    </Button>
                </Navbar.Collapse>
                :
                <Navbar.Collapse className="justify-content-end">
                        <Link to="/login" className="nav-link">Login</Link>
                        <Link to="/register" className="nav-link">Register</Link>
                </Navbar.Collapse>
            }
            
        </Navbar>
    )
}

function mapStateToProps(state){
    return {
        user: userSelector(state)
    }
}

function mapDispatchToProps(dispatch){
    return{
        onLogout: () => dispatch(logout())
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(AppHeader);