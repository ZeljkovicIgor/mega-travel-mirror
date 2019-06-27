import userService from '../../services/userService';
import { SET_USER } from './actionTypes';

function setUserState(user){
    return {
        type: SET_USER,
        payload: user
    };
}

export function setUser(user){
    return function(dispatch){
        localStorage.setItem('user', JSON.stringify(user));
        dispatch(setUserState(user));
    };
}

export function login(email, password){
    return async function(dispatch){
        const { data : user } = await userService.login(email, password);
        user && dispatch(setUser(user));
    }
}

export function logout(){
    return async function(dispatch){
        const { data } = await userService.logout();
        console.log(data);
        dispatch(setUser(null));
    }
}

export function register(user){
    return async function(dispatch){
        const { data } = await userService.register(user)
        console.log(data);
    }
}