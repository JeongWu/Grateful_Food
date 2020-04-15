import AuthStore from "./AuthStore";
import FoodStore from "./FoodStore";

class RootStore {
  constructor() {
    this.authStore = new AuthStore(this);
    this.foodStore = new FoodStore(this);
  }
}

export default RootStore;
