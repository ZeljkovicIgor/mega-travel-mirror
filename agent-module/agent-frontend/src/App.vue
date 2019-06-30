<template>
    <div id="app" class="container-fluid">
        <div class="site-info">
            <h1>Kreiranje smestaja</h1>
        </div>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <router-link class="btn btn-light" to="/">Smestajne jednice</router-link>
            <router-link v-if="logged" class="btn btn-light" to="/add-accommodation">Dodaj novi smestaj</router-link>
            <router-link class="btn btn-light" to="/reservation">Rezervacije</router-link>
            <router-link v-if=!logged class="btn btn-light"  to="/login">Prijavi se</router-link>
            <!--<router-link v-if=logged class="btn btn-light"  to="/logout">Odjavi se</router-link>
            -->
            <button v-if=logged @click="logOutUser" class="btn btn-link"> Odjavi se</button>
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
    data(){
        return {
        logged: false
        }
    },
    methods:{
        isLoggedIn(){
            http
                .get("/isLogged")
                .then(response => {
                    console.log(response.status);

                    if (response.status === 200)
                        this.logged = true
                    else
                        this.logged =  false;

                })
                .catch(e => {
                    console.log(e);
                    this.logged =  false;
                });
        },
        logOutUser(){

            http
                .post("/logout")
                .then(response => {
                    console.log(response.status);
                    this.logged =  false;
                    this.$router.push('/login');


                })
                .catch(e => {
                    console.log(e);
                    //this.$router.push('/');

                });
        },
        /* eslint-enable no-console */
    },
    mounted() {
        this.isLoggedIn();
    }
};
</script>

<style>
.site-info {
  color: blue;
  margin-bottom: 20px;
}




</style>
