<template>
    <b-row class="mb-3">
        <b-col>
        <b-card>{{content}}</b-card>
    </b-col>
        <b-col sm="2" class="text-sm-right"><b>Ja:</b></b-col>
        <br>{{date}}
        <br>{{time}}

    </b-row>
</template>

<script>

    export default {
        name: 'MessageOwn',

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
            }
        }
    }
</script>

<style>
</style>