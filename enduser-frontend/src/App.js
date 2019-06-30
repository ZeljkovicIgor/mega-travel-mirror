import "bootstrap/dist/css/bootstrap.min.css";
import React, { Component } from 'react';
import { connect } from 'react-redux';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import './App.css';
import Accommodation from "./components/Accommodation";
import AccommodationList from './components/AccommodationList';
import AccommodationSearch from './components/AccommodationSearch';
import AdvancedSearch from "./components/AdvancedSearch";
import AppHeader from './components/AppHeader';
import LoginForm from './components/LoginForm';
import NonAuthenticatedRoute from './components/NonAuthenticatedRoute';
import ProtectedRoute from './components/ProtectedRoute';
import RegisterForm from './components/RegisterForm';
import Reservation from './components/Reservation';
import ReservationForm from './components/ReservationForm';
import ReservationList from './components/ReservationList';
import MessagesList from './components/MessagesList';


class App extends Component {
  render(){

    return (
      <Router>
        <div className="App">
          <AppHeader/>
          <Switch>
            <NonAuthenticatedRoute
              path='/login'
              user={this.props.user}
              component={LoginForm}
            />
            <NonAuthenticatedRoute
              path='/register'
              user={this.props.user}
              component={RegisterForm}
            />
            <Route
              path='/searchAccommodations'
              component={AccommodationList}
            />
            <Route
              path='/advancedSearch'
              component={AdvancedSearch}
            />
            <Route
              path='/accommodations/:id'
              component={Accommodation}
            />
            <ProtectedRoute
              path='/bookAccommodation/:id'
              user={this.props.user}
              component={ReservationForm}
            />
            <ProtectedRoute
              exact
              path='/reservations'
              user={this.props.user}
              component={ReservationList}
            />
            <ProtectedRoute
              path='/reservations/:id'
              user={this.props.user}
              component={Reservation}
            />
            <ProtectedRoute
              path='/messages/:id'
              user={this.props.user}
              component={MessagesList}
            />
            <Route
              exact
              path='/'
              component={AccommodationSearch}
            />
          </Switch>
        </div>
      </Router>
    )

  }
}

function mapStateToProps(state) {
  return {
    user: state.user
  }
}

export default connect(mapStateToProps)(App);
