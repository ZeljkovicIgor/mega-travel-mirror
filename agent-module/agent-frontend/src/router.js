import Vue from "vue";
import Router from "vue-router";
import AccommodationList from "./components/AccommodationList.vue";
import AddAccommodation from "./components/AddAccommodation.vue";
import Accommodation from "./components/Accommodation.vue";
import EditAccommodation from "./components/EditAccommodation";
import AddPricePlan from "./components/AddPricePlan"; 
import LogIn from "./components/LogIn";

Vue.use(Router);
 
export default new Router({
  mode: "history",
  routes: [
    {
      path: "/",
      name: "home",
      alias: "/accommodation",
      component: AccommodationList,
      children: [
        {
          path: "/accommodation/:accId",
          name: "accommodation-details",
          component: Accommodation,
          props: true
        }
      ]
    },
    {
      path: "/add",
      name: "add",
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
    }
  ]
});