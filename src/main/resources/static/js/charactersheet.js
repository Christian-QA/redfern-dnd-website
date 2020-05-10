function toggleEditor() {
    let theText = document.getElementById('charactername');
    let theEditor = document.getElementById('ta1');
    let editorArea = document.getElementById('editor');


    //set text in text div to textarea
    //correct line breaks, prevent HTML injection
    let subject = theText.innerHTML;
    subject = subject.replace(new RegExp("<br />", "gi"), 'n');
    subject = subject.replace(new RegExp("<br />", "gi"), 'n');
    subject = subject.replace(new RegExp("<", "gi"), '<');
    subject = subject.replace(new RegExp(">", "gi"), '>');
    theEditor.value = subject;

    //hide text, show editor
    theText.style.display = 'none';
    editorArea.style.display = 'inline';
}


let REQ = new XMLHttpRequest();

let currentID = 0;

function getAllCharacters() {
    REQ.onload = () => {
        if (REQ.status === 200) {
            let responseObject = REQ.response;
            console.log(REQ.response);
            document.querySelector('#charactername').innerHTML = REQ.response[currentID].name;
        } else {
            console.log(`Handle Error!`);
        }
    }
    REQ.open('GET', 'http://localhost:8181/getAllCharacters', true);
    REQ.setRequestHeader('Content-Type', 'Application/json');
    REQ.setRequestHeader('Access-Control-Allow-Origin', 'http://localhost:8181/html/character.html');
    REQ.responseType = 'json';
    REQ.send();
}
window.addEventListener("load", getAllCharacters);

