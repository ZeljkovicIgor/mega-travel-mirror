<template>
  <div class="submitform">
    
        <div class="form-group">
          <label for="accName">Naziv</label>
          <input type="text" class="form-control" id="accName" required v-model="accommodation.accName" name="accName">
        </div>

        <div class="form-group">
          <label for="accCapacity">Kapacitet</label>
          <input type="number" class="form-control" id="accCapacity" required v-model="accommodation.accCapacity" name="accCapacity">
        </div>
        <div class="form-group">
          <label for="accDescription">Opis</label>
          <input type="text" class="form-control" id="accDescription" required v-model="accommodation.accDescription" name="accDescription">
        </div>
        
        <div id="additionalServices">
        <h4>Dodatne usluge</h4>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="checkbox" id="inlineCheckbox1" value="option1">
            <label class="form-check-label" for="inlineCheckbox1">1</label>
        </div>
        </div>
        <div class="form-group">
            <label for="accType">Tip smestaja</label>
            <select id="accType" class="form-control">
                <option selected>Choose...</option>
                <option>...</option>
            </select>
        </div>
        <div class="form-group">
            <label for="inputState">Kategorija smestaja</label>
            <select id="inputState" class="form-control">
                <option selected>Choose...</option>
                <option>...</option>
            </select>
        </div>
        <div class="form-group">
          <label for="accCapacity">Otkazni rok</label>
          <input type="number" class="form-control" id="accCapacity" required v-model="accommodation.accCapacity" name="accCapacity">
        </div>
        <div id="pricePlan">
         <h4>Plan cena</h4>   
        <table class="table">
            <thead>
                <tr>
                <th scope="col">#</th>
                <th scope="col">Od</th>
                <th scope="col">Do</th>
                <th scope="col">Cena</th>
                <th scope="col">
                     <button class="btn-sm btn-info" type="button" >Dodaj</button>
                </th>
                </tr>
            </thead>
             <tbody v-for="(price, index) in accommodation.accPricePlan" :key="index">
             
                <tr>
                <td scope="row">{{index}}</td>
                <td>{{price.priceStartDate}}</td>
                <td>{{price.priceEndDate}}</td>
                <td>{{price.priceValue}}</td>
                <td>
                   <button class="btn-sm btn-danger" type="button">Izbrisi</button> 
                </td>
                </tr>
             
            </tbody>
        </table>


        
        
        <div class="form-group">
            <label for="accPicture">Izaberite sliku</label>
            <input type="file" class="form-control-file" id="accPicture">
        </div>
        <button v-on:click="editAccommodation()" class="btn btn-success">Izmeni</button>
    </div>
    
    
    
  </div>
</template>

<script>
import http from "../http-common";

export default {
  name: "edit-accommodation",
  props: ["accommodation"],
  data() {
    return {
      /*
      accommodation: {
        accId: 0,
        accName: "",
        accDescription: "",
        accCapacity: 0,
      },*/
      submitted: false
    };
  },

  methods: {
    /* eslint-disable no-console */
    editAccommodation() {
      var data = {
        accId: this.accommodation.accId,
        accName: this.accommodation.accName,
        accDescription: this.accommodation.accDescription,
        accCapacity: this.accommodation.accCapacity
      };

      http
        .put("/accommodation/"+ this.accommodation.accId, data)
        .then(response => {
          this.accommodation.accId = response.data.accId;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });

    
    },
    newAccommodation() {
      this.submitted = false;
      this.accommodation = {};
    }
    /* eslint-enable no-console */
  }
};
</script>

<style>
.submitform {
  max-width: 600px;
  margin: auto;
}
</style>