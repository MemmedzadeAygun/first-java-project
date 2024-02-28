var selectedStudentId = 0;
var API_URL = "http://localhost:8084";

var studentNameInput = document.getElementById('student-name');
var studentSurnameInput = document.getElementById('student-surname');

var studentsTbodyElement = document.getElementById('students-tbody');
var notesTbodyElement = document.getElementById('notes-tbody');
var headerTextElement = document.getElementById('header-text');

var nameErrorElement=document.getElementById('error-name');
var surnameErrorElement=document.getElementById('error-surname');

var studentNoteInput = document.getElementById('student-note')

function onSaveStudent(event) {
    event.preventDefault();
    var studentName = studentNameInput.value;
    var studentSurname = studentSurnameInput.value;

    var studentObject = {};
    studentObject.id = selectedStudentId;
    studentObject.name = studentName;
    studentObject.surname = studentSurname;

    var http = new XMLHttpRequest();

    http.onload = function () {
        var nameError="";
        var surnameError="";
        if(this.status==400){
           var errorObject=JSON.parse(this.responseText);
           errorObject.validations.forEach(error => {
            if(error.field=='name'){
              
               nameError+=error.message+"<br>";
            }

            if(error.field=='surname'){
               surnameError+=error.message+"<br>";
            }
           });

            nameErrorElement.innerHTML=nameError;
            surnameErrorElement.innerHTML=surnameError;
        }
        else{
            clearErrorMessages();
            setHeaderText("Yeni Telebe qeydiyyati");
            selectedStudentId = 0;
            loadAllStudents();
        }
       
    }

    http.open("POST", API_URL + "/students", true);
    http.setRequestHeader("Content-Type", "application/json");
    http.send(JSON.stringify(studentObject));
}


function loadAllStudents() {
    var http = new XMLHttpRequest();

    http.onload = function () {
        var response = this.responseText;
        var studentsArray = JSON.parse(response);
        fillStudentsTable(studentsArray);
    }

    http.open("GET", API_URL + "/students", true);
    http.send();
}

function fillStudentsTable(students) {



    var studentsTbodyHtml = "";
    for (var i = 0; i < students.length; i++) {
        var student = students[i];
        studentsTbodyHtml += "<tr><td>" + student.id + "</td>";
        studentsTbodyHtml += "<td>" + student.name + "</td>";
        studentsTbodyHtml += "<td>" + student.surname + "</td>";

        studentsTbodyHtml += "<td><button class='btn btn-danger' onclick='onDeleteStudent(" + student.id + ")'>Sil</button>  ";
        studentsTbodyHtml += "<button class='btn btn-primary' onclick='onEditStudent(" + student.id + ")'>Redakte</button> ";

        studentsTbodyHtml += "<button class='btn btn-warning' onclick='onShowStudentNotes(" + student.id + ")' type='button' data-toggle='modal' data-target='#notesListModal'>Qeydler</button> ";

        studentsTbodyHtml += "<button class='btn btn-secondary' onclick='onNoteStudent(" + student.id + ")' type='button' data-toggle='modal' data-target='#noteModal' "+" >Qeyd yaz</button></td></tr>";
    }
    studentsTbodyElement.innerHTML = studentsTbodyHtml;
}

loadAllStudents();

function onDeleteStudent(studentId) {
    if (confirm("Silmeye eminsiniz?")) {
        var http = new XMLHttpRequest();
        http.onload = function () {
            loadAllStudents();
        }
        http.open("DELETE", API_URL + "/students/" + studentId, true);
        http.send();
    }
}

function onEditStudent(studentId) {
    selectedStudentId = studentId;
    setHeaderText('Telebe redaktesi,id=' + studentId);  
    var http = new XMLHttpRequest();
    http.onload = function () {
        var response = this.responseText;
        var studentobject = JSON.parse(response);
        studentNameInput.value = studentobject.name;
        studentSurnameInput.value = studentobject.surname;
    }
    http.open("GET", API_URL + "/students/" + studentId, true);
    http.send();
}

function setHeaderText(text) {
    headerTextElement.innerHTML = text;
}

setHeaderText("Yeni Telebe qeydiyyati");

function clearErrorMessages() {
    nameErrorElement.innerHTML="";
    surnameErrorElement.innerHTML="";
}


function onNoteStudent(studentId) {
    selectedStudentId = studentId;
  
}



function onSaveStudentNote(event) {
    event.preventDefault();
    var studentNote = studentNoteInput.value;
  
    var studentNoteObject = {}; 
    studentNoteObject.note = studentNote;
    studentNoteObject.studentId=selectedStudentId;


    var http = new XMLHttpRequest();

    http.onload = function () {
        var nameError="";
        var surnameError="";
        if(this.status==400){
            alert('Qeyd elave edile bilmedi!');
        }
        else{
           
           alert('Qeyd elave edildi');
        }
       
    }

    http.open("POST", API_URL + "/student-notes", true);
    http.setRequestHeader("Content-Type", "application/json");
    http.send(JSON.stringify(studentNoteObject));
}


function onShowStudentNotes(studentId){
    loadAllStudentsNotes(studentId); 
}


function fillStudentNotesTable(notes) {

    var notesTbodyHtml = "";
    for (var i = 0; i < notes.length; i++) {
        var note = notes[i];
        notesTbodyHtml += "<tr><td>" + note.id + "</td>";
        notesTbodyHtml += "<td>" + note.note + "</td>";
        notesTbodyHtml += "</tr>";
    }
    notesTbodyElement.innerHTML = notesTbodyHtml;
}


function loadAllStudentsNotes(studentId) {
    var http = new XMLHttpRequest();

    http.onload = function () {
        var response = this.responseText;
        var notesArray = JSON.parse(response);
        fillStudentNotesTable(notesArray);
    }

    http.open("GET", API_URL + "/student-notes/student/"+studentId, true);
    http.send();
}