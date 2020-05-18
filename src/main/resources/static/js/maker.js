let configGet = {
    headers: { 'Content-Type': 'application/json', 'Access-Control-Allow-Origin': 'http://localhost:8181/html/character.html' },
    responseType: 'json'
  };

const postCharacterSheet = () => {
    let charname = document.getElementById("name").value;
    let strength = document.getElementById("strength").value;
    let dexterity = document.getElementById("dexterity").value;
    let constitution = document.getElementById("constitution").value;
    let intelligence = document.getElementById("intelligence").value;
    let wisdom = document.getElementById("wisdom").value;
    let charisma = document.getElementById("charisma").value;


    /*
    let skilllist = "";

    if (document.getElementById("skill").checked = true) {
        let skilllist = document.getElementById("skill").value;
    }
    */
    

   axios({
    method: 'post',
    url: 'http://localhost:8181/createAbilities',
    data: `{
        "strength": ${strength},
        "dexterity": ${dexterity},
        "constitution": ${constitution},
        "intelligence": ${intelligence},
        "wisdom": ${wisdom},
        "charisma": ${charisma}
    }`,
    headers: {'Content-Type': 'application/json' }
    })
    .then(function (response) {
        let newId = response.data.abilitiesId;
        console.log(newId);
        return axios({
            method: 'post',
            url: 'http://localhost:8181/createCharacter',
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
                        "abilitiesId": ${newId}
                    }
                ]
            }`,
            headers: {'Content-Type': 'application/json' }
            })
            .then(function (response) {
                console.log(response.data);
                console.log(newId);
            })
            .catch(function (response) {
                console.log(response.data);
                console.log(newId);
            });
    })
    .catch(function (response) {
        console.log(response.data);
    });

    
    
    
    }

let postButton = document.querySelector('#postButton');
postButton.addEventListener('click', postCharacterSheet);