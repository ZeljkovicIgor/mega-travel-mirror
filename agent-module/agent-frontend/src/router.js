import Vue from "vue";
import Router from "vue-router";
import AccommodationList from "./components/AccommodationList.vue";
import AddAccommodation from "./components/AddAccommodation.vue";
import EditAccommodation from "./components/EditAccommodation";
import AddPricePlan from "./components/AddPricePlan"; 
import LogIn from "./components/LogIn";
import ReservationList from "./components/ReservationList";
import MessageList from "./components/MessageList";
import MessageReply from "./components/MessageReply";
import ReservationMessagesList from "./components/ReservationMessagesList";
import AddReservation from "./components/AddReservation";

Vue.use(Router);
 
export default new Router({
  mode: "history",
  routes: [
    {
      path: "/",
      name: "accommodation",
      alias: "/accommodation",
      component: AccommodationList
    },
    {
      path: "/add-accommodation",
      name: "add-accommodation",
      component: AddAccommodation,
      children: [
        {
          path: "/price",
          name: "accommodation-price",
          component: AddPricePlan,
          props: true
        }
      ]
    },
    {
        path: "/edit/:accId",
        name: "edit-accommodation", 
        component: EditAccommodation,
        props: true
    },
    {
      path: "/login",
      name: "login",
      component: LogIn
    },
    {
      path: "/reservation",
      name: "reservation-list",
      component: ReservationList
    },
    {
      path: "/message",
      name: "message-list",
      component: MessageList,
      props: true
    },
    {
      path: "/messages",
      name: "reservation-message-list",
      component: ReservationMessagesList,
      props: true
    },
    {
      path: "/reply",
      name: "message-reply",
      component: MessageReply,
      props: true
    },
    {
      path: "/add-reservation",
      name: "add-reservation",
      component: AddReservation,
      props: true
    }

  ]
});