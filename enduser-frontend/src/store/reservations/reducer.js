import { SET_RESERVATIONS } from './actionTypes';

const initialState = [];

export default function stateReducer(state = initialState, action) {
  switch (action.type) {
    case SET_RESERVATIONS:
      return action.payload;

    default:
      return state;
  }
}
