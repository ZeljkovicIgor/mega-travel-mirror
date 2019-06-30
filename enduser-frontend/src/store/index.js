import { createStore, combineReducers, applyMiddleware } from 'redux';
import thunk from 'redux-thunk';
import userReducer from './users/reducer';
import accommodationsReducer from './accommodations/reducer'
import accTypesReducer from './acc_types/reducer'
import categoriesReducer from './categories/reducer'
import reservationsReducer from './reservations/reducer'

const reducer = combineReducers({
    user: userReducer,
    accommodations: accommodationsReducer,
    accTypes: accTypesReducer,
    categories: categoriesReducer,
    reservations: reservationsReducer
});

const store = createStore(reducer, applyMiddleware(thunk));

export default store;