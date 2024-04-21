var API_URL="http://localhost:9999";
var usernameInput=document.getElementById('username');
var passwordInput=document.getElementById('password');
var nameInput=document.getElementById('name');
var surnameInput=document.getElementById('surname');
var phoneInput=document.getElementById('phone');
var addresInput=document.getElementById('addres');

function onSignup(event){
    event.preventDefault();
    var username=usernameInput.value;
    var password=passwordInput.value;
    var name=nameInput.value;
    var surname=surnameInput.value;
    var phone=phoneInput.value;
    var addres=addresInput.value;

    var http = new XMLHttpRequest();

    http.onload=function(){
        alert('Success');
    }

    var userObject={};
    userObject.username=username;
    userObject.password=password;
    userObject.name=name;
    userObject.surname=surname;
    userObject.phone=phone;
    userObject.addres=addres;

    http.open("POST",API_URL+"/users/librarian",true);
    http.setRequestHeader("Content-Type","application/json ");
    http.send(JSON.stringify(userObject));
    
}

function onOpenLoginPage(){
    window.location.href='login.html';
}