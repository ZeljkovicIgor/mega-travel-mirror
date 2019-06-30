<template>
    <div class="submitform">
        <b-form @submit="addReservation" >
            <h2>{{accommodation.accName}}</h2>
            <b-form-group
                    id="input-group-1"
                    label="Datum pocetka:"
                    label-for="input-1"
            >
                <b-form-input
                        id="input-1"
                        v-model="reservation.rStartDate"
                        type="date"
                        required
                        placeholder="Izaberite datum pocetka"
                ></b-form-input>
            </b-form-group>
            <b-form-group
                    id="input-group-1"
                    label="Datum kraja:"
                    label-for="input-1"
            >
                <b-form-input
                        id="input-1"
                        v-model="reservation.rEndDate"
                        type="date"
                        required
                        placeholder="Izaberite datum kraja"
                ></b-form-input>
            </b-form-group>

            <b-form-group id="input-group-2" label="Broj osoba:" label-for="input-2">
                <b-form-input
                        id="input-2"
                        v-model="reservation.rPeople"
                        type="number"
                        required
                        placeholder="Unesite broj osoba"
                ></b-form-input>
            </b-form-group>

            <b-button type="submit" variant="primary">Rezervisi</b-button>
        </b-form>

    </div>
</template>

<script>

    import http from "../http-common";

    export default {
        name: "add-reservation",
        props: ["accommodation"],
        data() {
            return {
                reservation:{
                    rAccommodationId: this.accommodation.accId,
                    rPeople:0,
                    rStartDate:'',
                    rEndDate:'',
                    rDate: ''
                }
            }
        },
        methods: {
            /* eslint-disable no-console */

            addReservation(evt) {
                evt.preventDefault()
                this.reservation.rDate = new Date();
                //JSON.stringify(this.reservation)
                http
                    .post("/reservation", this.reservation)
                    .then(response => {
                        console.log(response.data);
                        this.$bvModal.msgBoxOk('Rezervacija uspesna', {
                            title: 'Rezervacija',
                            size: 'sm',
                            buttonSize: 'sm',
                            okVariant: 'success',
                            headerClass: 'p-2 border-bottom-0',
                            footerClass: 'p-2 border-top-0',
                            centered: true
                        })
                    })
                    .catch(e => {
                        console.log(e);
                        this.$bvModal.msgBoxOk('Rezervacija nije uspesna', {
                            title: 'Rezervacija',
                            size: 'sm',
                            buttonSize: 'sm',
                            okVariant: 'danger',
                            headerClass: 'p-2 border-bottom-0 danger',
                            footerClass: 'p-2 border-top-0',
                            headerBgVariant: 'danger',
                            centered: true
                        })
                    })


                //http zahtev
                //ako je vec rezervisano u glavnoj bazi treba da vrati gresku
            }
        }
    }
</script>

<style>
    .submitform {
        max-width: 600px;
        margin: auto;
    }
</style>