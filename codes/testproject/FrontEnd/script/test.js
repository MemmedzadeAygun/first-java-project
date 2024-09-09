var API_URL="http://localhost:5555";

function onSaveTest(event){
    event.preventDefault();
    var testName=document.getElementById('test-name').value;
    var testQuestion=document.getElementById('test-question').value;
    var testOption1=document.getElementById('test-option1').value;
    var testOption2=document.getElementById('test-option2').value;
    var testOption3=document.getElementById('test-option3').value;
    var testOption4=document.getElementById('test-option4').value;
    var testAnswer=document.getElementById('test-answer').value;


    var testObject={};
    testObject.testName=testName;
    testObject.question=testQuestion;
    testObject.option_1=testOption1;
    testObject.option_2=testOption2;
    testObject.option_3=testOption3;
    testObject.option_4=testOption4;
    testObject.answer=testAnswer;

    var http=new XMLHttpRequest();

    http.onload=function(){
        alert("Success!");
    }

    http.open("POST", API_URL+"/tests",true);
    http.setRequestHeader("Content-Type","application/json");
    http.send(JSON.stringify(testObject));

}