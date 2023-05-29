import {useState} from "react";
import {Link} from "react-router-dom";
import {over} from "stompjs";
import SockJS from "sockjs-client"

var stompClient=null;
const Login = () =>{
    const [classroom, setClassroom] = useState([])
    const [studentData, setStudentData] = useState({
        id:null,
        firstName:"",
        lastName:"",
        handUp:false
    })
    const handleInputName = (event)=>{
        const {value}=event.target;
        const name = value.split(" ");
        setStudentData({...studentData, firstName:name[0], lastName:name[1]})
    }
    const addStudent = ()=>{
        let Sock = new SockJS('http://localhost:8081/')
        stompClient=over(Sock)
        stompClient.connect({}, onConnected, onError);
    }
    const onConnected = ()=>{
        stompClient.subscribe("/classroom", onClassroomMessage);
        stompClient.subscribe("/classroom/"+studentData.id, onStudentMessage);
    }
    const onClassroomMessage = (payload)=> {
        let payloadData = JSON.parse(payload.body);
        classroom.push(payloadData)
        setClassroom([...classroom])
    }
    const  onStudentMessage =(payload)=>{
        let payloadData = JSON.parse(payload.body)
        setStudentData({
            id:payloadData.id,
            firstName: payloadData.firstName,
            lastName: payloadData.lastName,
            handUp: payloadData.handUp
        })
    }
    const onError = (err) =>{
        console.log(err);
    }
    return (
        <div className="App">
            <header className="App-header">
                Your Name:
            </header>
            <p>
                <input
                    name="studentName"
                    minLength={5}
                    type="text"
                    //value={name}
                    onChange={handleInputName}
                />
            </p>
            <p className="Login-button">
                <button
                    type="button"
                    onClick={addStudent}>
                    <Link to="/classroom">
                        Log In
                    </Link>
                </button>
            </p>
        </div>
    )
}

export default Login;