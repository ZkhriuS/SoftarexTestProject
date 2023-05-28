import {Component} from "react";
import LoginService from "../services/LoginService";

export default class LoginComponent extends Component{
    constructor(props) {
        super(props);
        this.onInputName=this.onInputName.bind(this);
        this.saveStudent=this.saveStudent.bind(this);
        this.newStudent=this.newStudent.bind(this);
        this.state = {
            id: null,
            firstName: "",
            lastName: "",
            handUp: false
        };
    };
    onInputName(fn, ln){
        this.setState(
            {
                firstName: fn,
                lastName: ln
            }
        )
    };
    saveStudent(){
        let data = {
            firstName: this.state.firstName,
            lastName: this.state.lastName
        };
        LoginService.add(data).then(response => {
            this.setState({
                id: response.data.id,
                firstName: response.data.firstName,
                lastName: response.data.lastName,
                handUp: response.data.handUp
            });
            console.log(response.data);
        }).catch(e => {
            console.log(e);
        });
        LoginService.displayList().then(() =>
            Response.redirect("/classroom/"+this.state.id)
        ).catch(e => {
            console.log(e);
        })
    };

    newStudent(){
        this.setState({
            id: null,
            firstName: "",
            lastName: "",
            handUp: false
        })
        LoginService.findAll().then()
    }

    render() {
        return(
        <div className="App">
            <header
                className="App-header"
                onLoadStart={this.newStudent}>
                <text>Your Name:</text>
            </header>
            <p>
                <input
                    minLength={5}
                    type={"text"}
                    onChange={this.onInputName}
                />
            </p>
            <p className="Login-button">
                <button
                    onClick={this.saveStudent}>
                    Log In
                </button>
            </p>
        </div>
    )
    }
}