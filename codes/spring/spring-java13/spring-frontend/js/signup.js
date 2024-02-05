function onSaveTeacher(event){
 event.preventDefault();

    //1.inputlardan datalari string olaraq gotur

    let teacherName=document.getElementById('teacher-name').value;
    let teacherSurname=document.getElementById('teacher-surname').value;  //getElemenbyId vasitesile html'de olan name'in id'ne muraciet edilir ve onun deyeri value vasitesile string olaraq goturulur 
    let teacherUsername=document.getElementById('teacher-username').value;
    let teacherPassword=document.getElementById('teacher-password').value;
    let teacherEmail=document.getElementById('teacher-email').value;


    //2.bu melumatlari js obyekti halina sal ve json formasinda goster

let teacherObject={};
teacherObject.name=teacherName;   //teacherObject.name deki name servere gonderilecek name dir. ve onun adina uygun olamalidir
teacherObject.surname=teacherSurname;
teacherObject.username=teacherUsername;
teacherObject.password=teacherPassword;
teacherObject.email=teacherEmail;


let request=JSON.stringify(teacherObject);  //bu forma artiq obyekti setir olaraq yeni json formasinda qaytarir

    //3.bu obyekti apiye gonder
let xml=new XMLHttpRequest();
xml.open('POST','http://localhost:8080/users/teacher',true);
xml.setRequestHeader('Content-type','application/json'); //Bu postman da secdiyimiz raw ve json'un evezine yazdigimiz koddur
xml.send(request);
    
}

