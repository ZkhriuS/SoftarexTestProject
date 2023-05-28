import {Component} from "react";

export default class ClassroomComponent extends Component{
    constructor(props) {
        super(props);
        this.state = {
            students: [Student]
        }
    }

    render() {
        return(
            <div className="ListStudents">
            <label>Class members</label>
                <StudentList></StudentList>
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

function Student(props){
    const {id, firstName, lastName, handUp}=props
    return(props)
}