<template>
    <form @submit.prevent="logInUser" class="loginForm">
        <h1 class="h3 mb-3 font-weight-normal">Prijava</h1>
        <label for="userUsername" class="sr-only">Email adreas</label>
        <input type="text" id="userUsername" class="form-control" v-model="user.userUsername" placeholder="Korisnicko ime" required autofocus>
        <label for="userPassword" class="sr-only">Lozinka</label>
        <input type="password" id="userPassword" class="form-control" v-model="user.userPassword" placeholder="Lozinka" required>


        <button class="btn btn-lg btn-primary btn-block" type="submit">Prijavi se</button>

    </form>
</template>
    

<script>

import http from "../http-common";
export default {
  name: "login",
  data(){
    return {
      user: {
        userUsername: "",
        userPassword: ""
      },
      logedIn: false,
      isLogged: false
    }

  },

  methods: {
    /* eslint-disable no-console */
    logInUser(){
      var data = {
        userUsername: this.user.userUsername,
        userPassword: this.user.userPassword
      };
      console.log(this.user.userUsername);
      http
        .post("/login", data,{withCredentials: true})
        .then(response => {
          console.log(response.status);
          localStorage.setItem('agent', response.data);
          this.logedIn = true;
          this.$router.push('home');
        })
        .catch(e => {
          console.log(e);
        });
    },
    /* eslint-enable no-console */
  }

};
</script>