<template>
    <div id="app" class="container-fluid">
        <div class="site-info">
            <h1>Kreiranje smestaja</h1>
        </div>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <router-link class="btn btn-light" to="/">Smestajne jednice</router-link>
            <router-link class="btn btn-light" to="/add">Dodaj novi smestaj</router-link>
            <router-link class="btn btn-light" to="/reservation">Rezervacije</router-link>
            <router-link class="btn btn-light" to="/reservation">Poruke</router-link>
            <router-link v-if=!isLoggedIn() class="btn btn-light" to="/login">Prijavi se</router-link>
            <router-link v-if=isLoggedIn() class="btn btn-light" to="/logout">Odjavi se</router-link>
        </nav>
        <br/>
        <router-view/>
    </div>
</template>

<script>
import http from "./http-common";
    /* eslint-disable */
export default {
    name: "app",
    methods:{
        isLoggedIn(){
            http
                .get("/isLogged")
                .then(response => {
                    console.log(response.data);
                    if (response.data === undefined)
                        return false;
                    else
                        return true;

                })
                .catch(e => {
                    console.log(e);
                    return false;
                });
        }
    }
};
</script>

<style>
.site-info {
  color: blue;
  margin-bottom: 20px;
}

.btn-primary {
  margin-right: 5px;
}


</style>
