import axios from 'axios';

const url = "http://localhost:8080/";

function fetchAccommodations(searchDTO) {
    return axios({
        method: 'post',
        url: url + "search/searchAccommodation",
        data: searchDTO,
        withCredentials: true
      });
}

const accommodationsService = { fetchAccommodations };
export default accommodationsService;