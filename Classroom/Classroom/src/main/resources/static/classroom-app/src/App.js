import './App.css';
import React from "react";
import {Route, Routes} from "react-router-dom";
import LoginComponent from "./components/LoginComponent";
import ClassroomComponent from "./components/ClassroomComponent";

function App() {
    return (
        <div>
            <Routes>
                <Route path="/" element={<LoginComponent/>}></Route>
                <Route path="/login" element={<LoginComponent/>}></Route>
                <Route path="/classroom" element={<ClassroomComponent/>}></Route>
                <Route path="/classroom/:id" element={<ClassroomComponent/>}></Route>
            </Routes>
        </div>
    );
}

export default App;
