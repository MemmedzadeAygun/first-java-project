var API_URL="http://localhost:8032";

function onSignup(event){
    event.preventDefault();
    var username=document.getElementById('username').value;
    var password=document.getElementById('password').value;
    var name=document.getElementById('name').value;
    var surname=document.getElementById('surname').value;
    var email=document.getElementById('email').value;

    var http=new XMLHttpRequest();

    http.onload=function(){
        alert('Succes!');
    }

    var userObject={};
    userObject.username=username;
    userObject.password=password;
    userObject.name=name;
    userObject.surname=surname;
    userObject.email=email;

    http.open("POST",API_URL+"/users",true);
    http.setRequestHeader("Content-Type","application/json");
    http.send(JSON.stringify(userObject));

}

function onOpenLoginPage(){
    window.location.href = 'login.html';
}


