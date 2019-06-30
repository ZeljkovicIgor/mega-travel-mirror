
<template>
    <div>
        <h4>Smestaj</h4>
        <b-table :items="accs" :fields="fields" striped>
            <template slot="show_details" slot-scope="row">
                <b-button size="sm" @click="row.toggleDetails" class="mr-2">
                    {{ row.detailsShowing ? 'Sakrij' : 'Prikazi'}}
                </b-button>
                <b-button size="sm" class="btn-danger mr-2" @click="deleteAccommodation(row.item)">Izbrisi</b-button>
                    <router-link :to="{
                                       name: 'add-reservation',
                                       params: {accommodation: row.item}
                    }">
                        <b-button size="sm" class="btn mr-2">Rezervisi</b-button>
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
                        <b-col sm="3" class="text-sm-right"><b>Opis smestaja:</b></b-col>
                        <b-col>{{ row.item.accDescription }}</b-col>
                    </b-row>

                    <b-row class="mb-2">
                        <b-col sm="3" class="text-sm-right"><b>Kapacitet:</b></b-col>
                        <b-col>
                            <span v-for="(i, index) in row.item.accCapacity" :key="index">
                                👤
                            </span>
                        </b-col>
                    </b-row>

                    <b-row class="mb-2">
                        <b-col sm="3" class="text-sm-right"><b>Kategorija smestaja:</b></b-col>
                        <b-col>{{ row.item.accCategory.categoryName }} </b-col>
                    </b-row>
                    <b-row class="mb-2">
                        <b-col sm="3" class="text-sm-right"><b>Tip smestaja:</b></b-col>
                        <b-col>{{ row.item.accType.accTypeName }} </b-col>
                    </b-row>
                    <b-row class="mb-2">
                        <b-col sm="3" class="text-sm-right"><b>Otkazni rok:</b></b-col>
                        <b-col>{{ row.item.accCancelPeriod }}</b-col>
                    </b-row>
                    <b-row class="mb-2">
                        <b-col sm="3" class="text-sm-right"><b>Prosecna ocena:</b></b-col>
                        <b-col>{{ row.item.accAvgRating }}</b-col>
                    </b-row>
                    <b-row class="mb-2">
                        <b-col sm="3" class="text-sm-right"><b>Adresa:</b></b-col>
                        <b-col>{{ row.item.accLocation.address }} </b-col>
                    </b-row>
                    <b-row class="mb-2">
                        <b-col sm="3" class="text-sm-right"><b>Grad:</b></b-col>
                        <b-col>{{ row.item.accLocation.city }} </b-col>
                    </b-row>
                    <b-row class="mb-2">
                        <b-col sm="3" class="text-sm-right"><b>Drzava:</b></b-col>
                        <b-col>{{ row.item.accLocation.country }} </b-col>
                    </b-row>
                    <b-row class="mb-2">
                        <b-col sm="3" class="text-sm-right"><b>Dodatne usluge:</b></b-col>
                        <b-col>
                            <span v-for="(service, index) in row.item.accServices" :key="index">{{ service.serviceName }},</span>
                        </b-col>
                    </b-row>
                    <b-row class="mb-2">
                        <b-col sm="3" class="text-sm-right"><b>Plan cena:</b></b-col>
                        <b-col>
                            <table class="table table-sm">
                                <thead>
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Od</th>
                                    <th scope="col">Do</th>
                                    <th scope="col">Cena</th>
                                </tr>
                                </thead>
                                <tbody v-for="(price, index) in row.item.accPricePlan" :key="index">

                                <tr>
                                    <td scope="row">{{index}}</td>
                                    <td>{{parseDate(price.priceStartDate)}}</td>
                                    <td>{{parseDate(price.priceEndDate)}}</td>
                                    <td>{{price.priceValue}} RSD</td>
                                </tr>

                                </tbody>
                            </table>
                        </b-col>
                    </b-row>
                    <b-row class="mb-2">
                        <b-col sm="3" class="text-sm-right"><b>Zauzetost smestaja:</b></b-col>
                        <b-col>
                            <table class="table table-sm">
                                <thead>
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Od</th>
                                    <th scope="col">Do</th>
                                </tr>
                                </thead>
                                <tbody v-for="(unav, index) in row.item.accUnavailable" :key="index">

                                <tr>
                                    <td scope="row">{{index}}</td>
                                    <td>{{parseDate(unav.unavailableStart)}}</td>
                                    <td>{{parseDate(unav.unavailableEnd)}}</td>
                                </tr>

                                </tbody>
                            </table>
                        </b-col>
                    </b-row>
                    <b-row class="mb-2">
                        <b-col sm="3" class="text-sm-right"><b>Komentari:</b></b-col>
                        <b-col>
                            <b-button size="sm" @click="retrieveAccommodationReviews(row.item)">Prikazi</b-button>

                            <table class="table table-sm">
                                <thead>
                                <tr>
                                    <th scope="col">Datum:</th>
                                    <th scope="col">Od:</th>
                                    <th scope="col">Komentar:</th>
                                    <th scope="col">Ocena:</th>
                                </tr>
                                </thead>
                                <tbody v-for="(review, index) in reviews" :key="index">

                                <tr>
                                    <td scope="row">{{parseDate(review.accDate)}}</td>
                                    <td>{{review.reviewEndUser.userUsername}}</td>
                                    <td>{{review.reviewComment}}</td>
                                    <td>
                                        <span v-for="(i, index) in review.reviewGrade" :key="index">
                                            ★
                                        </span>
                                    </td>
                                </tr>

                                </tbody>
                            </table>
                        </b-col>
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
        name: "accomodation-list",
        data() {
            return {
                fields: [
                    {
                        key: 'accName',
                        label: 'Naziv smestaja',
                    },
                    {
                        key: 'accDate',
                        label: 'Datum kreiranja',
                        formatter: 'parseDate'
                    },
                    {
                        key: 'show_details',
                        label: '',
                    }

                ],
                accs: [],
                reviews: []

            }
        },
        computed: {

        },
        methods:{
            /* eslint-disable no-console */
            parseDate(value) {
                console.log(value)
                console.log(value.split('T')[0])
                console.log(value.slice(0,10))
                return value.split('T')[0]

            },
            retrieveAccommodations() {
                http
                    .get("/accommodation")
                    .then(response => {
                        this.accs = response.data;
                        console.log(response.data);
                    })
                    .catch(e => {
                        console.log(e);
                    });
            },
            retrieveAccommodationReviews(value) {
                http
                    .get("review/accommodation/" + value.accId)
                    .then(response => {

                        this.reviews = response.data;
                    })
                    .catch(e => {
                        console.log(e);
                    });
            },
            deleteAccommodation(value) {
                http
                    .delete("/accommodation/" + value.accId)
                    .then(response => {
                        console.log(response.data);
                        this.$router.push('/');
                    })
                    .catch(e => {
                        console.log(e);
                    });
            }
        },
        mounted() {
            this.retrieveAccommodations();
        }
    }
</script>