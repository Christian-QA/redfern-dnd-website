let REQ = new XMLHttpRequest();

let characterTestButton = document.querySelector("#butt1");

function getAllCharacters() {
    REQ.onload = () => {
        if (REQ.status === 200) {
            let responseObject = REQ.response;
            console.log(REQ.response);
            document.querySelector('#charactername').innerHTML = REQ.response[0].name;
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

characterTestButton.addEventListener("click", getAllCharacters);