<template>
  <div class="submitform">
    <div v-if="!submitted">
        <div class="form-group"> <!-- Naziv-->
          <label for="accName">Naziv</label>
          <input type="text" class="form-control" id="accName" required v-model="accommodation.accName" name="accName">
        </div><!-- /Naziv-->
        <div class="form-group"> <!-- Kapacitet-->
          <label for="accCapacity">Kapacitet</label>
          <input type="number" class="form-control" id="accCapacity" required v-model="accommodation.accCapacity" name="accCapacity">
        </div> <!-- /Kapacitet-->
        <div class="form-group"> <!-- Opis-->
          <label for="accDescription">Opis</label>
          <input type="text" class="form-control" id="accDescription" required v-model="accommodation.accDescription" name="accDescription">
        </div> <!-- /Opis-->
        <div class="form-row"> <!-- Lokacija-->
            <div class="form-group">
              <label for="country">Drzava</label>
              <input type="text" class="form-control" id="country" v-model="accommodation.accLocation.country"   name="country">
            </div> 
            <div  class="form-group">
              <label for="city">Grad</label>
              <input type="text" class="form-control" id="city" v-model="accommodation.accLocation.city"  name="city">
            </div>
            <div class="form-group">
              <label for="address">Adresa</label>
              <input type="text" class="form-control" id="address" v-model="accommodation.accLocation.address"  name="address">
            </div>
        </div><!-- /Lokacija-->
        <div id="additionalServices"> <!-- Dodatne usluge-->
          <h5>Dodatne usluge</h5>
          <b-form-group>
          <b-form-checkbox-group id="checkbox-group-2" v-model="selectedAddServices" name="flavour-2">
          <b-form-checkbox v-for="(s, index) in this.allAddServices" :key="index" v-bind:value="s.serviceId">{{s.serviceName}}</b-form-checkbox>

          </b-form-checkbox-group>
          <p>{{this.selectedAddServices}}</p>
          </b-form-group>
        </div> <!-- /Dodatne usluge-->
        <div class="form-group"> <!-- Tip smestaja-->
            <label for="accType">Tip smestaja</label>
            <select id="accType" class="form-control" v-model="accommodation.accType.accTypeId" >
              <option v-for="(type, index) in this.allTypes" :key="index" :id=type.accTypeId v-bind:value="type.accTypeId" >{{type.accTypeName}}</option>
            </select>
        </div> <!-- /Tip smestaja-->
        <div class="form-group"> <!-- Kategorija smestaja-->
            <label for="accCategory">Kategorija smestaja</label>
            <select id="accCategory" class="form-control" v-model="accommodation.accCategory.categoryId" >
                  <option v-for="(category, index) in this.allCategories" :key="index" :id=category.categoryId v-bind:value="category.categoryId" >{{category.categoryName}}</option>
            </select>
        </div> <!-- /Kategorija smestaja-->
        <div class="form-group"> <!-- Otkazni rok smestaja-->
          <label for="accCancelPeriod">Otkazni rok</label>
          <input type="number" class="form-control" id="accCancelPeriod" required v-model="accommodation.accCancelPeriod" name="accCancelPeriod">
        </div> <!-- /Otkazni rok smestaja-->
        <div id="pricePlan"> <!--Plan cena-->
          <h4>Plan cena</h4>  
          <div class="form-row">
            <div class="form-group">
              <label for="priceValue">Cena</label>
              <input type="number" class="form-control" id="priceValue" v-model="priceValue"   name="priceValue">
            </div> 
            <div class="form-group">
              <label for="priceStartDate">Datum od</label>
              <input type="date" class="form-control" id="priceStartDate" v-model="priceStartDate"  name="priceStartDate">
            </div>
            <div class="form-group">
              <label for="priceEndDate">Datum do</label>
              <input type="date" class="form-control" id="priceEndDate" v-model="priceEndDate"  name="priceEndDate">
            </div>
            <table class="table">
              <thead>
                <tr>
                <th scope="col">#</th>
                <th scope="col">Od</th>
                <th scope="col">Do</th>
                <th scope="col">Cena</th>
                <th scope="col">
                     <button class="btn-sm btn-info" v-on:click="addPrice()" type="button" >Dodaj</button>
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
          </div>
        </div> <!--/Plan cena-->
        <div id="unavailablePlan"> <!--Plan dostupnosti-->
          <h4>Nedostupnost smestaja</h4>  
          <div class="form-row">
            <div class="form-group">
              <label for="unavailableStart">Nedostupan od</label>
              <input type="date" class="form-control" id="unavailableStart" v-model="unavailableStart"  name="unavailableStart">
            </div>
            <div class="form-group">
              <label for="unavailableEnd">Nedostupan do</label>
              <input type="date" class="form-control" id="unavailableEnd" v-model="unavailableEnd"  name="unavailableEnd">
            </div>
            <table class="table">
              <thead>
                <tr>
                <th scope="col">#</th>
                <th scope="col">Od</th>
                <th scope="col">Do</th>
                <th scope="col">
                     <button class="btn-sm btn-info" v-on:click="addUnavailable()" type="button" >Dodaj</button>
                </th>
                </tr>
              </thead>
              <tbody v-for="(unav, index) in accommodation.accUnavailable" :key="index">
             
                <tr>
                <td scope="row">{{index}}</td>
                <td>{{unav.unavailableStart}}</td>
                <td>{{unav.unavailableEnd}}</td>
                <td>
                   <button class="btn-sm btn-danger" type="button">Izbrisi</button> 
                </td>
                </tr>
             
              </tbody>
            </table>
          </div>
        </div><!--/Plan dostupnosti-->

        <!--Izbor slike
        <div class="form-group">
            <label for="accPicture">Izaberite sliku</label>
            <input type="file" class="form-control-file" id="accPicture">
        </div>
        /Izbor slike-->
        <button v-on:click="saveAccommodation()" class="btn btn-success">Dodaj</button>
    </div>

  </div>

</template>

<script>
import http from "../http-common";

export default {
name: "add-accommodation",

  data() {
    return {
      addService:{
      
          serviceId: 0,
          serviceName: ""
      
      },
      servicesToSend: [],
      selectedAddServices: [],
      allAddServices: [],
      allCategories: [],
      allTypes: [],
      accommodation: {
        accId: 0,
        accName: "",
        accDescription: "",
        accCapacity: 0,
        accPricePlan: [],
        accUnavailable: [],
        accType: {
          accTypeId: 0,
          accTypeName: ""
        },
        accLocation: {
          address: "",
          city: "",
          country: ""
        },
        accCategory: {
          categoryId: 0,
          categoryName: ""
        },
        accServices:[{
          serviceId: 0,
          serviceName: ""
        }],
        accCancelPeriod: 0,
        accDate: 0
      },
      submitted: false

    };
  },

  methods: {
    /* eslint-disable no-console */
    selectServices(){
     this.selectedAddServices.forEach(selected => {
      this.allAddServices.forEach(service => {
          if(selected === service.serviceId )
          this.servicesToSend.push(service);
        });
     });
    },
    saveAccommodation() {
      this.selectServices();
      var data = {
        accName: this.accommodation.accName,
        accDescription: this.accommodation.accDescription,
        accCapacity: this.accommodation.accCapacity,
        accPricePlan: this.accommodation.accPricePlan,
        accUnavailable: this.accommodation.accUnavailable,
        accType: {accTypeId: this.accommodation.accType.accTypeId,
                  accTypeName: this.accommodation.accType.accTypeName
        },
        accLocation: {  address: this.accommodation.accLocation.address,
                        city: this.accommodation.accLocation.city,
                        country: this.accommodation.accLocation.country,
        },
        accCategory: {
          categoryId: this.accommodation.accCategory.categoryId,
          categoryName: this.accommodation.accCategory.categoryName
        } ,
        accServices: this.servicesToSend,
        accCancelPeriod: this.accommodation.accCancelPeriod,
        accDate: new Date()

      };


      http
        .post("/accommodation", data)
        .then(response => {
          this.accommodation.accId = response.data.accId;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });

      this.submitted = true;
    },
    newAccommodation() {
      this.submitted = false;
      this.accommodation = {};
      
    },
    addPrice(){
      var price = { priceValue: this.priceValue,
                    priceStartDate: this.priceStartDate,
                    priceEndDate: this.priceEndDate
                  };
    console.log(price);
    this.accommodation.accPricePlan.push(price);
    console.log(this.accommodation.accPricePlan);
    },
    addUnavailable(){
      var unav = {  unavailableStart: this.unavailableStart,
                    unavailableEnd: this.unavailableEnd
                  };
    console.log(unav);
    this.accommodation.accUnavailable.push(unav);
    console.log(this.accommodation.accPricePlan);
    },
    retrieveAccTypes() {
      http
        .get("/acctype")
        .then(response => {
          
          this.allTypes = response.data;
          console.log(this.allTypes);
        })
        .catch(e => {
          console.log(e);
        });
    },
    retrieveAccCategories() {
      http
        .get("/category")
        .then(response => {
          console.log(response.data);
          this.allCategories = response.data;
        })
        .catch(e => {
          console.log(e);
        });
    },
    retrieveAddServices() {
      http
        .get("/additionalservice")
        .then(response => {
          console.log(response.data);
          this.allAddServices = response.data;
        })
        .catch(e => {
          console.log(e);
        });
    },
        /* eslint-enable no-console */
  },
  mounted(){
      this.retrieveAccTypes();
      this.retrieveAddServices();
      this.retrieveAccCategories();
  },
};

</script>

<style>
.submitform {
  max-width: 600px;
  margin: auto;
}
</style>