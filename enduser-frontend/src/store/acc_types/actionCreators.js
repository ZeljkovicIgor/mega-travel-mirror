import { SET_ACCOMMODATION_TYPES } from './actionTypes';
import accTypesService from '../../services/accTypesService';

const setAccommodationTypes = types => ({
  type: SET_ACCOMMODATION_TYPES,
  payload: types
});

export function getAccommodationTypes() {
  return async function(dispatch) {
    const { data } = await accTypesService.fetchAccTypes();
    dispatch(setAccommodationTypes(data));
    return data;
  };
}
