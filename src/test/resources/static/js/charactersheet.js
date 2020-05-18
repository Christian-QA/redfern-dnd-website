
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


let currentID = 0;

let config = {
    headers: { 'Content-Type': 'application/json', 'Access-Control-Allow-Origin': 'http://localhost:8181/html/character.html' },
    responseType: 'json'
};

const getCharacterSheets = () => {
    axios.get('http://localhost:8181/getAllCharacters', config)
        .then(function (response) {

            document.querySelector('#charactername').innerHTML = response.data[currentID].name

            document.querySelector('#strength').innerHTML = response.data[currentID].abilities[0].strength;
            document.querySelector('#dexterity').innerHTML = response.data[currentID].abilities[0].dexterity;
            document.querySelector('#constitution').innerHTML = response.data[currentID].abilities[0].constitution;
            document.querySelector('#intelligence').innerHTML = response.data[currentID].abilities[0].intelligence;
            document.querySelector('#wisdom').innerHTML = response.data[currentID].abilities[0].wisdom;
            document.querySelector('#charisma').innerHTML = response.data[currentID].abilities[0].charisma;

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

/*
const updateCharacters = axios.put(`localhost:8181/updateCharacter/${currentID}`, config, {
    name: 'Gohso'
})
    .then(response => {
        console.log(response);
    })
    .catch(error => {
        console.log(err);
    });
window.addEventListener("load", updateCharacters);
*/

