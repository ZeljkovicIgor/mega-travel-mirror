import { SET_ACCOMMODATIONS } from './actionTypes';
import accommodationsService from '../../services/accommodationsService';

const setAccommodations = accommodations => ({
  type: SET_ACCOMMODATIONS,
  payload: accommodations
});

export function sortAccommodations(accommodations){
  return function(dispatch) {
    console.log(accommodations)
    dispatch(setAccommodations(accommodations))
  }
}

export function getAccommodations(search, advanced = false) {
  return async function(dispatch) {
    const { data } = await accommodationsService.fetchAccommodations(search, advanced);
    dispatch(setAccommodations(data));
  };
}
