import { SET_RESERVATIONS } from './actionTypes';
import reservationsService from '../../services/reservationsService';

const setReservations = reservations => ({
  type: SET_RESERVATIONS,
  payload: reservations
});

export function getReservations() {
  return async function(dispatch) {
    const { data } = await reservationsService.fetchReservations();
    dispatch(setReservations(data));
  };
}
