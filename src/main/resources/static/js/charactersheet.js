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

let currentID = document.getElementById("characterfind").value;
console.log(currentID);

function changeCharacter() {
    let currentID = document.getElementById("characterfind").value;
    console.log(currentID);
    window.addEventListener("load", getCharacterSheets);
}

let configGet = {
    headers: { 'Content-Type': 'application/json', 'Access-Control-Allow-Origin': 'http://localhost:8181/html/character.html' },
    responseType: 'json'
  };


  function getCharacterById(){
    axios.get('http://localhost:8181/getAllCharacters', configGet)
    .then(function (response) {
    let dropdown = document.getElementById('characterfind');
    //dropdown.options[0] = new Option("Sinnis");
    //dropdown.options[1] = new Option("Sinnis");
    let i = 0;
    const arrayDrop = response.data;
    arrayDrop.forEach(element => {
        console.log(element.name);
        dropdown.options.length=element.length;
        dropdown.options[i] = new Option(response.data[0].name, 0, true, true);
        i++;
      }); 
    });
  }


const getCharacterSheets = () => {
    axios.get('http://localhost:8181/getAllCharacters', configGet)
    .then(function (response) {
        let currentID = document.getElementById("characterfind").value;
        document.querySelector('#charactername').innerHTML = response.data[currentID].name
        document.querySelector('#strength').innerHTML = response.data[currentID].abilities[0].strength;
        document.querySelector('#dexterity').innerHTML = response.data[currentID].abilities[0].dexterity;
        document.querySelector('#constitution').innerHTML = response.data[currentID].abilities[0].constitution;
        document.querySelector('#intelligence').innerHTML = response.data[currentID].abilities[0].intelligence;
        document.querySelector('#wisdom').innerHTML = response.data[currentID].abilities[0].wisdom;
        document.querySelector('#charisma').innerHTML = response.data[currentID].abilities[0].charisma;


        document.querySelector('#dropdown2').innerHTML = response.data[1].name
        document.querySelector('#dropdown3').innerHTML = response.data[2].name
        document.querySelector('#dropdown4').innerHTML = response.data[3].name
        const arraySkills = response.data[currentID].skills
        arraySkills.forEach(element => {
            console.log(element.skillName);
            document.querySelector('#skillname').innerHTML = element.skillName;
        }); 
    })
    .catch(function (error) {
        console.log(error);
    });
}
window.addEventListener("load", getCharacterSheets);

let refreshCharacter = document.querySelector('#refreshCharacter');
refreshCharacter.addEventListener('click', getCharacterSheets);

const deleteCharacterSheet = () => {
    currentID = document.getElementById("characterfind").value;
    let idCorrection = Number(currentID) + 1;
    axios({
        method: 'delete',
        url: `http://localhost:8181/deleteCharacter/${idCorrection}`,
        headers: { 'Content-Type': 'application/json' },
    }).then(function (response) {
        console.log(response);
    })
    .catch(function (response) {
        console.log(response);
    });
}

let deleteCharacter = document.querySelector('#deleteCharacter');
deleteCharacter.addEventListener('click', deleteCharacterSheet);


const updateCharacterSheet = () => {
    currentID = document.getElementById("characterfind").value;
    let idCorrection = Number(currentID) + 1;
    let charname = document.getElementById("charactername").value;
    let strength = document.getElementById("strength").value;
    let dexterity = document.getElementById("dexterity").value;
    let constitution = document.getElementById("constitution").value;
    let intelligence = document.getElementById("intelligence").value;
    let wisdom = document.getElementById("wisdom").value;
    let charisma = document.getElementById("charisma").value;
    axios({
        method: 'put',
        url: `localhost:8181/updateCharacter/${idCorrection}`,
        data: `{
            "name": "${charname}",
            "maxHp": 21,
            "currentHp": 21,
            "exp": 3000,
            "skills": [
                {
                    "skillsId": 1,
                    "skillName": "History",
                    "statModifier": "Wisdom"
                }
            ], 
            "abilities": [
                {
                    "abilitiesId": 1,
                    "strength": ${strength},
                    "dexterity": ${dexterity},
                    "constitution": ${constitution},
                    "intelligence": ${intelligence},
                    "wisdom": ${wisdom},
                    "charisma": ${charisma}
                }
            ]
        }`,
        headers: { 'Content-Type': 'application/json', 'Access-Control-Allow-Origin': '*', 'Access-Control-Allow-Methods': '*', "Access-Control-Allow-Headers": 'Origin, X-Requested-With, Content-Type, Accept, Z-Key' },
        pact: {
            cors: true
          }
    }).then(function (response) {
        console.log(response);
    })
    .catch(function (response) {
        console.log(response);
    });
}
let updateCharacter = document.querySelector('#updateCharacter');
updateCharacter.addEventListener('click', updateCharacterSheet);
