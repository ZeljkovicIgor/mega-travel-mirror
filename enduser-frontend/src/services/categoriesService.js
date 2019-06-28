import axios from 'axios';

const url = "http://localhost:8080/category/";

function fetchCategories() {
    return axios({
        method: 'get',
        url: url + "getCategories",
        withCredentials: true
      });
}

const categoriesService = { fetchCategories };
export default categoriesService;