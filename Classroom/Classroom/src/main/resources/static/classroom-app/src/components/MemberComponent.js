import {Component} from "react";
import SockJsClient from "react-stomp"
import { Client } from '@stomp/stompjs';
import client from "rest/util/pubsub";

const SOCKET_URL = 'ws://localhost:8080/';

export default class MemberComponent extends Component{
    constructor(props) {
        super(props);
        this.state = {
            firstName: "",
            lastName: "",
            handUp: false
        }
    }
    componentDidMount() {
        let onConnected = () => {
            console.log("Connected!")
            client.subscribe('/classroom/{id}', function (list) {
                if (list.body) {
                    var jsonBody = JSON.parse(list.body);
                    if (jsonBody.firstName) {
                        this.setState({firstName: jsonBody.firstName})
                    }
                }
            });
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
}