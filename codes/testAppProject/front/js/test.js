var API_URL="http://localhost:8787/tests";

var topicsTbodyElement = document.getElementById('topics-tbody');
var testUlElement=document.getElementById('testsList');

var questionErrorElement=document.getElementById('question-error');
var option1ErrorElement=document.getElementById('option1-error');
var option2ErrorElement=document.getElementById('option2-error');
var option3ErrorElement=document.getElementById('option3-error');
var option4ErrorElement=document.getElementById('option4-error');
var answerErrorElement=document.getElementById('correctAnswer-error');

function onSaveTest(event){
    event.preventDefault();
    var topicId=document.getElementById('topic-id').value;
    var testQuestion=document.getElementById('test-question').value;
    var testOption1=document.getElementById('test-option1').value;
    var testOption2=document.getElementById('test-option2').value;
    var testOption3=document.getElementById('test-option3').value;
    var testOption4=document.getElementById('test-option4').value;
    var testAnswer=document.getElementById('test-answer').value;


    var testObject={};
    testObject.topic={ id: parseInt(topicId) };
    testObject.question=testQuestion;
    testObject.option_1=testOption1;
    testObject.option_2=testOption2;
    testObject.option_3=testOption3;
    testObject.option_4=testOption4;
    testObject.correct_answer=testAnswer;

    var http=new XMLHttpRequest();

    http.onload=function(){
        if(this.status==400){
            var questionError="";
            var option1Error="";
            var option2Error="";
            var option3Error="";
            var option4Error="";
            var answerError="";
           var errorObject=JSON.parse(this.responseText);
           errorObject.validations.forEach(error => {
                if(error.field=='question'){  
                   questionError+=error.message+"<br>";
                }

                if(error.field=='option_1'){  
                    option1Error+=error.message+"<br>";
                }

                if(error.field=='option_2'){ 
                   option2Error+=error.message+"<br>";
                }

                if(error.field=='option_3'){  
                   option3Error+=error.message+"<br>";
                }

                if(error.field=='option_4'){ 
                   option4Error+=error.message+"<br>";
                }

                if(error.field=='correct_answer'){  
                    answerError+=error.message+"<br>";
                }
           });
            questionErrorElement.innerHTML=questionError;
            option1ErrorElement.innerHTML=option1Error;
            option2ErrorElement.innerHTML=option2Error;
            option3ErrorElement.innerHTML=option3Error;
            option4ErrorElement.innerHTML=option4Error;
            answerErrorElement.innerHTML=answerError;
        }
        else{
            clearErrorMessages();
        }
    }

    http.open("POST", API_URL+"/add/test",true);
    http.setRequestHeader("Content-Type","application/json");
    http.send(JSON.stringify(testObject));

}


function loadAllTopics() {
    var http = new XMLHttpRequest();

    http.onload = function () {
        var response = this.responseText;
        var topicsArray = JSON.parse(response);
        fillTopicsTable(topicsArray);
    }

    http.open("GET", API_URL + "/topics", true);
    http.send();
}

function fillTopicsTable(topics) {

    var topicsTbodyHtml = "";
    for (var i = 0; i < topics.length; i++) {
        var topic = topics[i];
        topicsTbodyHtml += "<tr><td>" + topic.id + "</td>";
        topicsTbodyHtml += "<td>" + topic.topicName + "</td>";
        topicsTbodyHtml += "<td>" + topic.topicLevel + "</td>"; 
    
        topicsTbodyHtml += "<td><button class='btn btn-secondary' onclick='onSelectTopic(" + topic.id + ")'>Select</button></td></tr>";
    }
    topicsTbodyElement.innerHTML = topicsTbodyHtml;

}

loadAllTopics();

function onSelectTopic(topicId) {

    window.location.href = "selecttopic.html?topicId=" + topicId;
    var http=new XMLHttpRequest();

    http.onload=function(){
        if (http.status === 200) {
            var tests = JSON.parse(http.responseText);
            fillTestsUl(tests); 
        } else {
            console.error("Error fetching topic tests. Status code: " + http.status);
        }
    }
    http.open("GET",API_URL+"/topic/"+topicId,true);
    http.send();
}

function fillTestsUl(tests){
    var testsHtml="";
    for(var i=0; i<tests.length; i++){
        var test=tests[i];
        testsHtml += "<ul><li>"+test.question+"</li>";
        testsHtml += "<li>"+test.option_1+"</li>";
        testsHtml += "<li>"+test.option_2+"</li>";
        testsHtml += "<li>"+test.option_3+"</li>";
        testsHtml += "<li>"+test.option_4+"</li></ul>";
    }
    testUlElement.innerHTML=testsHtml;
}

onSelectTopic(topicId)

function clearErrorMessages(){
    questionErrorElement.innerHTML="";
    option1ErrorElement.innerHTML="";
    option2ErrorElement.innerHTML="";
    option3ErrorElement.innerHTML="";
    option4ErrorElement.innerHTML="";
    answerErrorElement.innerHTML="";
}