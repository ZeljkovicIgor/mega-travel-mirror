import { createStore, combineReducers, applyMiddleware } from 'redux';
import thunk from 'redux-thunk';
import userReducer from './users/reducer';
import accommodationsReducer from './accommodations/reducer'

const reducer = combineReducers({
    user: userReducer,
    accommodations: accommodationsReducer
});

const store = createStore(reducer, applyMiddleware(thunk));

export default store;