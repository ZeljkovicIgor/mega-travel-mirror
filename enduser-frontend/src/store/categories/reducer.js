import { SET_CATEGORIES } from './actionTypes';

const initialState = [];

export default function stateReducer(state = initialState, action) {
  switch (action.type) {
    case SET_CATEGORIES:
      return action.payload;

    default:
      return state;
  }
}
