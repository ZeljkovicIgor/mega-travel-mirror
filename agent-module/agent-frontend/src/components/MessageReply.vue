<!--
<template>
    <div>
        <b-card>
            <b>Za: {{replyMessage.messageRecieverUsername}}}</b>
            <b-form-textarea
                    id="textarea"
                    v-model="replyMessage.messageContent"
                    placeholder="Unesite odgovor..."
                    rows="3"
                    max-rows="6"
            ></b-form-textarea>
            <b-button @click="sendMessage">Posalji</b-button>
        </b-card>
    </div>
</template>
-->
<template>
    <div>
        <b-form @submit="sendMessage" >
            <b-form-group
                    id="input-group-1"
                    label="Za:"
                    label-for="input-1"
            >
                <b-form-input
                        id="input-1"
                        v-model="messageDto.messageRecieverUsername"
                        type="text"
                        required
                        placeholder="Unesite primaoca"
                ></b-form-input>
            </b-form-group>

            <b-form-group id="input-group-2" label="Poruka:" label-for="input-2">
                <b-form-textarea
                        id="textarea"
                        v-model="messageDto.messageContent"
                        placeholder="Unesite odgovor..."
                        rows="3"
                        max-rows="6"
                ></b-form-textarea>

            </b-form-group>


            <b-button type="submit" variant="primary">Posalji</b-button>
        </b-form>
        <b-card class="mt-3" header="Form Data Result">
            <pre class="m-0">{{ messageDto }}</pre>
        </b-card>
    </div>
</template>

<script>
    import http from "../http-common";

    export default {

        name: "message-reply",
        props: ["messageData"],
        data(){
            return{
                messageDto:{
                    messageRecieverId: this.messageData.messageSender.userId,
                    messageRecieverUsername: this.messageData.messageSender.userUsername,
                    messageSenderId: this.messageData.messageReciever.userId,
                    messageSenderUsername: this.messageData.messageReciever.userUsername,
                    messageReservationId: this.messageData.messageReservation.rid,
                    messageDate: '',
                    messageContent: ''
                }
            }
        },
        methods:{
            /* eslint-disable no-console */

            sendMessage(event){
                event.preventDefault();
                this.messageDto.messageDate = new Date();
                http
                    .post("/message/send", this.messageDto )
                    .then(response => {
                        console.log(response);
                        this.$router.push('/reservation');

                    })
                    .catch(e => {
                        console.log(e);
                    })

                console.log(this.replyMessage);
                console.log(this.messageData);
            }
        }
    }
</script>

<style scoped>

</style>