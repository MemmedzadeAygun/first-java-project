var API_URL = "http://localhost:9999";
var username = localStorage.getItem('username');
var password = localStorage.getItem('password');
var token = "Basic " + window.btoa(username + ":" + password);


function onSaveStudent(event) {
    event.preventDefault();

    var studentUsername = document.getElementById('student-username').value;
    var studentPassword = document.getElementById('student-password').value;
    var studentName = document.getElementById('student-name').value;
    var studentSurname = document.getElementById('student-surname').value;
    var studentPhone = document.getElementById('student-phone').value;
    var studentAddres = document.getElementById('student-addres').value;


    var http = new XMLHttpRequest();

    http.onload = function () {
        alert('Success');
    }

    var studentObject = {};
    studentObject.username = studentUsername;
    studentObject.password = studentPassword;
    studentObject.name = studentName;
    studentObject.surname = studentSurname;
    studentObject.phone = studentPhone;
    studentObject.addres = studentAddres;

    http.open("POST", API_URL + "/users/student", true);
    http.setRequestHeader("Content-Type", "application/json");
    http.setRequestHeader("Authorization", token);
    http.send(JSON.stringify(studentObject));

}

function loadAllStudents(){
    var http=new XMLHttpRequest();

    http.onload=function(){
        var response=this.responseText;
        var studentsArray=JSON.parse(response);
        fillStudentsTable
    }
}