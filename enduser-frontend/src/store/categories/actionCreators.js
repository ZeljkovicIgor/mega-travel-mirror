import { SET_CATEGORIES } from './actionTypes';
import categoriesService from '../../services/categoriesService';

const setCategories = categories => ({
  type: SET_CATEGORIES,
  payload: categories
});

export function getCategories() {
  return async function(dispatch) {
    const { data } = await categoriesService.fetchCategories();
    dispatch(setCategories(data));
    return data;
  };
}
