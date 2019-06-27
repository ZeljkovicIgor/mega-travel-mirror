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
                        v-model="reservation.rstartDate"
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
                        v-model="reservation.rendDate"
                        type="date"
                        required
                        placeholder="Izaberite datum kraja"
                ></b-form-input>
            </b-form-group>

            <b-form-group id="input-group-2" label="Broj osoba:" label-for="input-2">
                <b-form-input
                        id="input-2"
                        v-model="reservation.rpeope"
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
                    raccommodationId: this.accommodation.accId,
                    rpeope: 0,
                    rstartDate:'',
                    rendDate:'',
                    rdate: ''
                }
            }
        },
        methods: {
            addReservation(evt) {
                evt.preventDefault()
                this.reservation.rdate = new Date();
                alert(JSON.stringify(this.reservation))
                http
                    .post("")
                    .then()
                    .catch()
                /*
                this.$bvModal.msgBoxOk('Rezervacija uspesna', {
                    title: 'Rezervacija',
                    size: 'sm',
                    buttonSize: 'sm',
                    okVariant: 'success',
                    headerClass: 'p-2 border-bottom-0',
                    footerClass: 'p-2 border-top-0',
                    centered: true
                })
                */
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