var API_URL = "http://localhost:8084";
var usernameInput=document.getElementById('username');
var passwordInput=document.getElementById('password');

function onLogin(event){
    event.preventDefault();
    var username=usernameInput.value;
    var password=passwordInput.value;
var http=new XMLHttpRequest();
http.onload=function(){
console.log(this.status)
if(this.status==200){
localStorage.setItem('username',username);
localStorage.setItem('password',password);
window.location.href="student.html.html";
}
else{
alert("Melumatlar sehvdir!!!");
}

}
http.open("GET",API_URL+"/users/login",true);
http.setRequestHeader("Authorization","Basic "+window.btoa(username+":"+password));
http.send();
}

function onOpenSignupPage(){
    window.location.href='signup.html';
}