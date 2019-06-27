import axios from "axios";
 
export default axios.create({
  withCredentials: true,
  baseURL: "http://localhost:8081/",
  headers: {
    "Content-type": "application/json",
    "Accept": "application/json",

  }
});