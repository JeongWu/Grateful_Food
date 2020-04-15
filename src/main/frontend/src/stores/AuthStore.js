import axios from "axios";
import { observable, action } from "mobx";

const _http = axios.create({
  baseURL: "http://localhost:8080",
  /*headers: {
    "content-type": "application/json;charset=utf-8"
  },
  withCredentials: true
*/
});

export default class AuthStore {
  constructor(root) {
    this.root = root;
  }
  @observable
  loginInfo = {
    name: "",
    password: "",
    isLogin: false,
  };
  @observable
  signInfo = {
    name: "정우",
    email: "park",
    picture: "",
    password: 123,
    address: "",
    coupon: "",
    role: "GUEST",
    // isLogin: false,
  };

  @action
  signin = async () => {
    const user = this.signInfo;
    try {
      const data = await _http.post("/guest/singup", user);
      if (data.result === "YES") {
        alert(data.result);
        this.loginInfo = {
          ...this.loginInfo,
          isLogin: true,
        };
        window.localStorage.setItem("user", this.loginInfo);
      } else {
        alert(data.result);
      }
    } catch (e) {
      console.error(e);
      alert(e);
    }
  };

  @action
  login = async () => {
    const user = this.loginInfo;
    try {
      const data = await _http.post("/api/check_login", user);
      if (data.status === 200) {
        this.loginInfo = {
          ...this.loginInfo,
          isLogin: true,
        };
        window.localStorage.setItem("user", this.loginInfo);
      }
    } catch (e) {
      console.error(e);
    }
  };

  @action
  checkLogin = async () => {};

  @action
  logout = async () => {
    const data = await _http.post("/logout");
    try {
      if (data.status === 200) {
        window.localStorage.clear();
        window.location.href = "/";
      }
    } catch (e) {
      console.error(e);
    }
  };
}
