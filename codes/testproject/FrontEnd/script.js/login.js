var API_URL="http://localhost:8032";
var usernameInput=document.getElementById('username');
var passwordInput=document.getElementById('password');

function onLogin(event){
    event.preventDefault();
    var username=usernameInput.value;
    var password=passwordInput.value;

    
    var http = new XMLHttpRequest();

    http.onload=function(){
        if(this.status==401){
            alert("Melumatlar sehvdir!");
        }else if(this.status==200){
            localStorage.setItem('username',username);
            localStorage.setItem('password',password);
            window.location.href="Home.html";
        }
    }
    http.open("GET",API_URL+"/users/login",true);
    http.setRequestHeader("Authorization","Basic " + window.btoa(username+":"+password));
    http.send();
    
}
















function onOpenSignupPage(){
    window.location.href='signup.html';
}