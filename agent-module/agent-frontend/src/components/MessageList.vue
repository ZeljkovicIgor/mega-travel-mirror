
<template>
    <div>
        <h4>Poruke</h4>
        <b-table :items="messages" :fields="fields" striped>
            <template slot="show_details" slot-scope="row">
                <b-button size="sm" @click="row.toggleDetails" class="mr-2">
                    {{ row.detailsShowing ? 'Sakrij' : 'Prikazi'}}
                </b-button>
                <b-button size="sm" class=" mr-2"  @click="confirmReservation(row.item)">Potvrdi</b-button>

                <!-- As `row.showDetails` is one-way, we call the toggleDetails function on @change
                <b-form-checkbox v-model="row.detailsShowing" @change="row.toggleDetails">
                    Details via check
                </b-form-checkbox>
                -->
            </template>

            <template slot="row-details" slot-scope="row">
                <b-card>
                    <div>
                    <message-agent v-if="row.item.messageSender.userId === row.item.messageReservation.raccommodation.accAgent.userId" :date="parseDate(row.item.messageDate)" :time="parseTime(row.item.messageDate)" :content="row.item.messageContent"/>
                    <message-nesto v-else :date="parseDate(row.item.messageDate)" :time="parseTime(row.item.messageDate)" :content="row.item.messageContent"/>
                    </div>
                    <b-button size="sm" @click="row.toggleDetails">Sakrij detalje</b-button>

                    <router-link :to="{
                        name: 'message-reply',
                        params: {messageData: row.item}
                        }">
                        <b-button type="button" class="btn btn-sm btn-outline-secondary">Odgovori</b-button>
                    </router-link>
                    <b-button size="sm" @click="reply(row.item)">Odgovori</b-button>
                </b-card>
            </template>
        </b-table>
    </div>
</template>

<script>
    import http from "../http-common";
    export default {
        name: "message-list",
        props: ["reservationData"],
        data() {
            return {
                fields: [
                    {
                        key: 'messageReservation.raccommodation.accName',
                        label: 'Smestaj',
                    },
                    {
                        key: 'messageDate',
                        label: 'Poslata',
                        formatter: 'parseDate'
                    },
                    {
                        key: 'messageSender.userUsername',
                        label: 'Posiljalac',
                    },
                    {
                        key: 'status',
                        label: 'Status',
                    },
                    {
                        key: 'show_details',
                        label: 'Detalji',
                    }

                ],
                messages: [],
                messageContent: ""
            }
        },

        methods:{
            /* eslint-disable no-console */
            parseDate(value) {
                return `${value.split('T')[0]}`
            },
            parseTime(value) {
                return `${value.split('T')[1].slice(0,5)}`
            },
            checkStatus(value) {
                let status = '';
                if (value == true)
                    status = 'Da';
                else
                    status = 'Ne';
                return `${status}`
            },
            retrieveReservationMessages(){
                http
                    .get("/message/reservation/" + this.reservationData.rid)
                    .then(response => {
                        this.messages = response.data;
                        console.log(response.data);
                    })
                    .catch(e => {
                        console.log(e);
                    });
            },
            retrieveMessages() {
                http
                    .get("/message")
                    .then(response => {
                        this.messages = response.data;
                        console.log(response.data);
                    })
                    .catch(e => {
                        console.log(e);
                    });
            },
            reply(value) {
               console.log(this);
                console.log(this.$attrs);
                console.log(value);

            },

        },
        mounted() {
            this.retrieveReservationMessages();
        }
    }
</script>