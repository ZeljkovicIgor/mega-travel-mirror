import { SET_ACCOMMODATIONS } from './actionTypes';
import accommodationsService from '../../services/accommodationsService';

const setAccommodations = accommodations => ({
  type: SET_ACCOMMODATIONS,
  payload: accommodations
});

export function getAccommodations(search) {
  return async function(dispatch) {
    const { data } = await accommodationsService.fetchAccommodations(search);
    dispatch(setAccommodations(data));
  };
}
