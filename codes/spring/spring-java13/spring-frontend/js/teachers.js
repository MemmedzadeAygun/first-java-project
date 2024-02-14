function loadTeachers(){
    
   
    let xml=new XMLHttpRequest();
 
     xml.onload=function(){
        let massiv=JSON.parse(this.responseText);
        massiv.teachers.forEach(s => {
         document.getElementById('teachers').innerHTML+="<tr><td>"+s.id+"</td><td>"+s.name+"</td><td>"+s.surname+"</td><td>"+s.username+"</td></tr>";
        });
     }
 
    xml.open('GET','http://localhost:8084/teachers',true);
    xml.send();
        
    }
    
     loadTeachers();
    