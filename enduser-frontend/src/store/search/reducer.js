import { SET_SEARCH } from './actionTypes';

const initialState = [];

export default function stateReducer(state = initialState, action) {
  switch (action.type) {
    case SET_SEARCH:
      return action.payload;

    default:
      return state;
  }
}
