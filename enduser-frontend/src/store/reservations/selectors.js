export function reservationsSelector(state) {
    return state.reservations;
}

export function reservationByIdSelector(state) {
    console.log(state)
    return function(id) {
      return state.reservations.find(reservation => reservation.rId === parseInt(id, 10));
    };
  }
  