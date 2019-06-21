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
            <router-link class="btn btn-light" to="/login">Prijavi se</router-link>
        </nav>
        <br/>
        <router-view/>
    </div>
</template>

<script>
export default {
  name: "app"
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
