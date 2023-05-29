import './App.css';
import React from "react";
import {Route, Routes} from "react-router-dom";
import ClassroomComponent from "./components/ClassroomComponent";
import SockJsClient from "react-stomp"
import Login from "./components/Login";

function App() {
    return (
        <div>
            <Login></Login>
            <Routes>
                <Route path="/" element={<Login/>}></Route>
                <Route path="/login" element={<Login/>}></Route>
                <Route path="/classroom" element={<ClassroomComponent/>}></Route>
                <Route path="/classroom/:id" element={<ClassroomComponent/>} ></Route>
            </Routes>
            <SockJsClient url='http://localhost:8081/'
                          topics={['/classroom', '/login']}
                          onConnect={() => {
                              console.log("connected");
                          }}
                          onDisconnect={() => {
                              console.log("Disconnected");
                          }}
                          onMessage={(msg) => {
                              console.log(msg);
                          }}/>
        </div>
    );
}

export default App;
