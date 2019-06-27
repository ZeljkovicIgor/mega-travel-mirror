import { SET_ACCOMMODATIONS } from './actionTypes';

const initialState = [];

export default function stateReducer(state = initialState, action) {
  switch (action.type) {
    case SET_ACCOMMODATIONS:
      return action.payload;

    default:
      return state;
  }
}
