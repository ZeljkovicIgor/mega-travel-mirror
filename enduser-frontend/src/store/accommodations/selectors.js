export function accommodationsSelector(state) {
    return state.accommodations;
}

export function accommodationByIdSelector(state) {
    return function(id) {
      return state.accommodations.find(accommodation => accommodation.accId === parseInt(id, 10));
    };
  }
  