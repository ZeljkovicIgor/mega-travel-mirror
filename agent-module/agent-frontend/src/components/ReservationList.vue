
<template>
    <div class="container">
        <div>
            <h4>Rezervacije</h4>
            <div class="row">
                <div v-for="(reservation, index) in reservations" :key="index">
                    <router-link :to="{
                            name: 'accommodation-details',
                            params: { accommodation: accommodation, accId: accommodation.accId }
                        }">
                             <div>
                                <b-table :items="items" :fields="fields" striped>
                                <template slot="show_details" slot-scope="row">
                                    <b-button size="sm" @click="row.toggleDetails" class="mr-2">
                                    {{ row.detailsShowing ? 'Hide' : 'Show'}} Details
                                    </b-button>

                                    <!-- As `row.showDetails` is one-way, we call the toggleDetails function on @change -->
                                    <b-form-checkbox v-model="row.detailsShowing" @change="row.toggleDetails">
                                    Details via check
                                    </b-form-checkbox>
                                </template>

                                <template slot="row-details" slot-scope="row">
                                    <b-card>
                                    <b-row class="mb-2">
                                        <b-col sm="3" class="text-sm-right"><b>Age:</b></b-col>
                                        <b-col>{{ row.item.age }}</b-col>
                                    </b-row>

                                    <b-row class="mb-2">
                                        <b-col sm="3" class="text-sm-right"><b>Is Active:</b></b-col>
                                        <b-col>{{ row.item.isActive }}</b-col>
                                    </b-row>

                                    <b-button size="sm" @click="row.toggleDetails">Hide Details</b-button>
                                    </b-card>
                                </template>
                                </b-table>
                            </div>                        
                                


                                <div class="col-md">
                                <div class="card mb shadow-sm">
                                    <svg class="bd-placeholder-img card-img-top" width="100%" height="150" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: Thumbnail"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"/><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>
                                    <div class="card-body">
                                    <h5 class="card-title">{{accommodation.accName}}</h5>
                                    <p class="card-text">{{accommodation.accDescription}}</p>
                                    <div class="d-flex justify-content-between align-items-center">
                                        <div class="btn-group">
                                        <button type="button" class="btn btn-sm btn-outline-secondary">Detalji</button>
                                       
                                        <button type="button" class="btn btn-sm btn-outline-secondary">Izbrisi</button>
                                        </div>
                                        <small class="text-muted">{{accommodation.accDate}}</small>
                                    </div>
                                    </div>
                                </div>
                                </div>
                            
                    </router-link>
                </div>
            </div>
        </div>

        
            <router-view @refreshData="refreshList"></router-view>
        
        
    
    </div>
     
     
</template>
 
<script>
import http from "../http-common";
 
export default {
  name: "reservation-list",
  data() {
    return {
      reservations: []
    };
  },
  methods: {
    /* eslint-disable no-console */
    retrieveAccommodations() {
      http
        .get("/accommodation")
        .then(response => {
          this.accommodations = response.data; 
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    refreshList() {
      this.retrieveAccommodations();
    }
    /* eslint-enable no-console */
  },
  mounted() {
    this.retrieveAccommodations();
  }
};
</script>
 
<style>
.list {
  text-align: left;
  max-width: 450px;
  margin: auto;
}
</style>