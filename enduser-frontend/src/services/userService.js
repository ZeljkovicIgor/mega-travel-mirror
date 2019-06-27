import axios from 'axios';

const url = "http://localhost:8080/user/";


function login(email, password){
    return axios.post(url + "login", {
        userEmail: email,
        userPassword: password
    }, {withCredentials: true})
}

function logout(){
    return axios.get(url + "loggoutUser");
} 

function register(user){
    return axios.post(url + "register", {
        userEmail: user.email,
        userPassword: user.password,
        userUsername: user.username,
        userFirstName: user.firstName,
        userLastName: user.lastName
    }, {withCredentials: true})
}

const userService = { login, logout, register };
export default userService;