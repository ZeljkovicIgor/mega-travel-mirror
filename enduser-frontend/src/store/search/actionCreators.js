import { SET_SEARCH } from './actionTypes';

const setSearch = search => ({
  type: SET_SEARCH,
  payload: search
});

export function getSearch(search, advanced = false) {
  return async function(dispatch) {
    dispatch(setSearch(search));
  };
}
