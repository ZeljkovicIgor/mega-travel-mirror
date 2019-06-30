import axios from 'axios';

const url = "http://localhost:8080/";

function fetchReservations() {
    return axios({
        method: 'get',
        url: url + "user/reservations",
        withCredentials: true
      });
}

const reservationsService = { fetchReservations };
export default reservationsService;