import http from "../http-common";

class LoginService {
  static add(data){
      return http.post("/login", data)
  }
  static findAll(){
      return http.get("/login")
  }
  static displayList(){
      return http.get("/classroom")
  }
}

export default LoginService;