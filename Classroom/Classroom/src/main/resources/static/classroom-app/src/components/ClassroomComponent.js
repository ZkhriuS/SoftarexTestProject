import {Component} from "react";
import {Menu} from "@mui/material";
import {MenuItem} from "@mui/material";
import * as React from "react";
import {Client} from "@stomp/stompjs";

const SOCKET_URL = 'ws://localhost:8080/';
export function MenuLogout() {
    const [selectedElement, setSelectedElement] = React.useState(null);
    const [open, setOpen] = React.useState(false);

    function handleOpenMenu() {
        setOpen(true);
    }

    function handleCloseMenu(event) {
        setOpen(false);
        setSelectedElement(event.target);
    }
    return(
        <div className="Logout">
            <div
                style={{
                    height: "2rem",
                    padding: "5px 10px",
                    backgroundColor: "grey",
                    width: "7rem",
                    margin: "10px 10px 30px 10px",
                    fontSize: "1.2rem",
                    color: "white",
                    borderRadius: "12px",
                    cursor: "pointer",
                }}
                onClick={handleOpenMenu}>
                John Smith
            </div>
            <Menu
                id="basic-menu"
                selectedElement={selectedElement}
                open={open}
                onClose={handleCloseMenu}>
                <MenuItem className="LogoutMenuItem"
                    onClick={handleCloseMenu}>
                    Log Out
                </MenuItem>
            </Menu>
        </div>
    )
}
export default class ClassroomComponent extends Component{

    constructor(props) {
        super(props);
        this.state = {
            students: []
        }
    }

    componentDidMount(){
        let onConnected = () => {
            console.log("Connected!")
            client.subscribe('/classroom', function (list) {
                if (list.body) {
                    var jsonBody = JSON.parse(list.body);
                    if (jsonBody.students) {
                        this.setState({students: jsonBody.students})
                    }
                }
            });
        }
        let onDisconnected = () => {
            console.log("Disconnected!")
        }
        const client = new Client({
            brokerURL: SOCKET_URL,
            reconnectDelay: 5000,
            heartbeatIncoming: 4000,
            heartbeatOutgoing: 4000,
            onConnect: onConnected,
            onDisconnect: onDisconnected
        });

        client.activate();
    }

    render() {
        return(
            <div>
                <nav>
                <MenuLogout></MenuLogout>
                </nav>
                <p className="ListStudents">
                <label >Class members</label>
                <StudentList students={this.state.students}>
                    {this.state.students}
                </StudentList>
            </p>
            </div>
        )
    }
}

function StudentList(props){
    const students = props.students;
    const listItems = students.map(student =>
        <li key={student.id}>
            {student.firstName},
            {student.lastName},
            <if {...student.handUp}>
                <img src="/classroom-app/public/logo512.png" alt="hand"></img>
            </if>
        </li>)
    return(
        <ul>{listItems}</ul>
    )
}