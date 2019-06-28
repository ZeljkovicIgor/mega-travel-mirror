import { SET_ACCOMMODATION_TYPES } from './actionTypes';

const initialState = [];

export default function stateReducer(state = initialState, action) {
  switch (action.type) {
    case SET_ACCOMMODATION_TYPES:
      return action.payload;

    default:
      return state;
  }
}
