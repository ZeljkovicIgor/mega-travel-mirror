import "bootstrap/dist/css/bootstrap.min.css";
import React, { Component } from 'react';
import { connect } from 'react-redux';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import './App.css';
import AccommodationSearch from './components/AccommodationSearch';
import AppHeader from './components/AppHeader';
import LoginForm from './components/LoginForm';
import NonAuthenticatedRoute from './components/NonAuthenticatedRoute';
import RegisterForm from './components/RegisterForm';
import AccommodationList from './components/AccommodationList'


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
