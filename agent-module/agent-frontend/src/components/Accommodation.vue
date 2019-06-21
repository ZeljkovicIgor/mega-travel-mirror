<template>
  
  <div v-if="this.accommodation">
    <h4>{{this.accommodation.accName}}</h4>
    <div>
      <label>Naziv: </label> {{this.accommodation.accName}}
    </div>
    <div>
      <label>Opis: </label> {{this.accommodation.accDescription}}
    </div>
    <div>
      <label>Kapacitet: </label> {{this.accommodation.accCapacity}}
    </div>
  
    <span v-if="this.accommodation.active"
      v-on:click="updateActive(false)"
      class="button is-small btn-primary">Inactive</span>
    <span v-else
      v-on:click="updateActive(true)"
      class="button is-small btn-primary">Active</span>
  
    <span class="button is-small btn-danger" v-on:click="deleteAccommodation()">Izbrisi</span>
  </div>
  <div v-else>
    <br/>
    <p>Please click on a accommodation...</p>
  </div>
</template>

<script>
import http from "../http-common";

export default {
  name: "accommodation",
  props: ["accommodation"],
  methods: {
    /* eslint-disable no-console */
    updateActive(status) {
      var data = {
        accId: this.accommodation.accId,
        accName: this.accommodation.accName,
        accDescription: this.accommodation.accDescription,
        accCapacity: this.accCapacity,
        accPricePlan: this.pricePlan,
        accType: this.accType,
        accLocation: this.accLocation,
        accCategory: this.accCategory,
        accServices: this.accServices,
        accCancelPeriod: this.accCancelPeriod,
        accDate: this.accDate
      };

      http
        .put("/accommodation/" + this.accommodation.accId, data)
        .then(response => {
          this.accommodation.active = response.data.active;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    deleteAccommodation() {
      http
        .delete("/accommodation/" + this.accommodation.accId)
        .then(response => {
          console.log(response.data);
          this.$emit("refreshData");
          this.$router.push('/');
        })
        .catch(e => {
          console.log(e);
        });
    }
    /* eslint-enable no-console */
  }
};
</script>