import axios from 'axios';

const url = "http://localhost:8080/accType/";

function fetchAccTypes() {
    return axios({
        method: 'get',
        url: url + "getAccTypes",
        withCredentials: true
      });
}

const accTypesService = { fetchAccTypes };
export default accTypesService;