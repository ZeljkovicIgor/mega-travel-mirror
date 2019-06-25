<template>
    <div>
        <b-form @submit="addReservation" @reset="onReset">
            <b-form-group
                    id="input-group-1"
                    label="Email address:"
                    label-for="input-1"
                    description="We'll never share your email with anyone else."
            >
                <b-form-input
                        id="input-1"
                        v-model="reservation.rstartDate"
                        type="date"
                        required
                        placeholder="Izaberite datum pocetka"
                ></b-form-input>
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
                        type="date"
                        required
                        placeholder="Unesite broj osoba"
                ></b-form-input>
            </b-form-group>

            <b-button type="submit" variant="primary">Rezervisi</b-button>
            <b-button type="reset" variant="danger">Reset</b-button>
        </b-form>

    </div>
</template>

<script>

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
                //http zahtev
                //ako je vec rezervisano u glavnoj bazi treba da vrati gresku
            },
            onReset(evt) {
                evt.preventDefault()
                // Reset our form values

            }
        }
    }
</script>

<style scoped>

</style>