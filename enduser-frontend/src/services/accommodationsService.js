import axios from 'axios';

const url = "http://localhost:8080/";

function fetchAccommodations(searchDTO, advanced = false) {
    return axios({
        method: 'post',
        url: advanced ? url + "search/advancedSearchAccommodation" : url + "search/searchAccommodation",
        data: searchDTO,
        withCredentials: true
      });
}

const accommodationsService = { fetchAccommodations };
export default accommodationsService;