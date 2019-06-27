<template>
    <b-row class="mb-3">
        <b-col sm="2" class="text-sm-left">
            <b>{{user}}</b>
            <br>{{date}}
            <br>{{time}}
        </b-col>
        <b-col>
            <b-card>{{ content }}</b-card>
        </b-col>
    </b-row>
</template>

<script>
    export default {
        name: "MessageUser",
        props: {
            date: {
                type: String,
                default: '',
                required: false
            },
            time: {
                type: String,
                default: '',
                required: false
            },
            content: {
                type: String,
                default: '',
                required: false
            },
            user: {
                type: String,
                default: '',
                required: false
            }
        }
    }
</script>

<style scoped>

</style>