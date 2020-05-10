var XMLHttpRequest = require('xhr2');
var REQ = new XMLHttpRequest();

function getAllCharacters() {
    REQ.onload = () => {
        if (REQ.status === 200) {
            // console.log(REQ);
            console.log(REQ.response);
            console.log(REQ.response.name);
            document.querySelector('#charactername').innerHTML = REQ.response[0].name;
        } else {
            console.log(`Handle Error!`);
        }
    }
    REQ.open('GET', 'localhost:8181/getAllCharacters');
    REQ.setRequestHeader('Content-Type', 'Application/json');
    REQ.setRequestHeader('Access-Control-Allow-Origin', '*');
    REQ.responseType = 'json';
    REQ.send();
}

let butt1 = document.querySelector('#butt1');
butt1.addEventListener('click', getAllCharacters);