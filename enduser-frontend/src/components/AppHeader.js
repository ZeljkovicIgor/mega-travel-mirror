import React from 'react';
import { Navbar, NavDropdown } from 'react-bootstrap';
import { connect } from 'react-redux';
import { Link } from 'react-router-dom';
import logo from '../logo.svg';
import { logout, userSelector } from '../store/users';

function AppHeader ({ user, onLogout }) {
    return (
        <Navbar>
            <Navbar.Brand>
                <Link to="/" className="navbar-brand">
                    <h1>mega-travel<img src={logo} className="App-logo" alt="logo" /></h1>
                </Link>
            </Navbar.Brand>
            {
                user
                ? 
                <Navbar.Collapse className="justify-content-end">
                    <Link to='/reservations' className='nav-link'>Reservations</Link>
                    <NavDropdown title={ user.userFirstName + ' ' + user.userLastName } alignRight>
                        
                        <NavDropdown.Item
                            onClick={onLogout}
                            as="button"
                        >
                            Logout
                        </NavDropdown.Item>
                    </NavDropdown>
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