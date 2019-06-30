
<template>
    <div>
        <h4>Rezervacije</h4>
        <b-table :items="reservations" :fields="fields" striped>
            <template slot="show_details" slot-scope="row">
                <b-button size="sm" @click="row.toggleDetails" class="mr-2">
                    {{ row.detailsShowing ? 'Sakrij' : 'Prikazi'}}
                </b-button>
                <b-button size="sm" class=" mr-2"  @click="confirmReservation(row.item)">Potvrdi</b-button>

                <router-link :to="{
                        name: 'reservation-message-list',
                        params: {reservationData: row.item}
                        }">
                    <b-button size="sm" class=" mr-2" >Poruke</b-button>
                </router-link>

                <!-- As `row.showDetails` is one-way, we call the toggleDetails function on @change
                <b-form-checkbox v-model="row.detailsShowing" @change="row.toggleDetails">
                    Details via check
                </b-form-checkbox>
                -->
            </template>

            <template slot="row-details" slot-scope="row">
                <b-card>
                    <b-row class="mb-2">
                        <b-col sm="3" class="text-sm-right"><b>Korisnik:</b></b-col>
                        <b-col>{{ row.item.rendUser.userUsername }}</b-col>
                    </b-row>

                    <b-row class="mb-2">
                        <b-col sm="3" class="text-sm-right"><b>Broj osoba:</b></b-col>
                        <b-col>{{ row.item.rpeople }} osoba</b-col>
                    </b-row>

                    <b-row class="mb-2">
                        <b-col sm="3" class="text-sm-right"><b>Od:</b></b-col>
                        <b-col>{{ parseDate(row.item.rstartDate) }} </b-col>
                    </b-row>
                    <b-row class="mb-2">
                        <b-col sm="3" class="text-sm-right"><b>Do:</b></b-col>
                        <b-col>{{ parseDate(row.item.rendDate) }} </b-col>
                    </b-row>
                    <b-row class="mb-2">
                        <b-col sm="3" class="text-sm-right"><b>Otkazni rok:</b></b-col>
                        <b-col>{{ row.item.raccommodation.accCancelPeriod }}</b-col>
                    </b-row>

                    <b-row class="mb-2">
                        <b-col sm="3" class="text-sm-right"><b>Ukupna cena:</b></b-col>
                        <b-col>{{ row.item.rprice }} </b-col>
                    </b-row>

                    <b-button size="sm" @click="row.toggleDetails">Sakrij detalje</b-button>
                </b-card>
            </template>
        </b-table>
    </div>
</template>

<script>
    import http from "../http-common";
    export default {
        name: "reservation-list",
        data() {
            return {
                fields: [
                    {
                        key: 'raccommodation.accName',
                        label: 'Smestaj',
                    },
                    {
                        key: 'rid',
                        label: 'Broj rezervacije',
                    },
                    {
                        key: 'rdate',
                        label: 'Datum kreiranja',
                        formatter: 'parseDate'
                    },
                    {
                        key: 'realized',
                        label: 'Realizovana',
                        formatter: 'checkStatus'
                    },
                    {
                        key: 'cancelled',
                        label: 'Otkazana',
                        formatter: 'checkStatus'
                    },
                    {
                        key: 'show_details',
                        label: 'Detalji',
                    }

                ],
                reservations: [],

            }
        },

        methods:{
            /* eslint-disable no-console */
            parseDate(value) {
                return `${value.split('T')[0]}`
            },
            checkStatus(value) {
                let status = '';
                if (value == true)
                    status = 'Da';
                else
                    status = 'Ne';
                return `${status}`
            },
            retrieveReservations() {
                http
                    .get("/reservation")
                    .then(response => {
                        this.reservations = response.data;
                        console.log(response.data);
                    })
                    .catch(e => {
                        console.log(e);
                    });
            },
            confirmReservation(value){
                http
                    .put("/reservation/confirm/" + value.rid)
                    .then(response => {
                        console.log(response.data);
                    })
                    .catch(e => {
                        console.log(e);
                    });
            }

        },
        mounted() {
            this.retrieveReservations();
        }
    }
</script>