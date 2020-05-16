


const postCharacterSheet = () => {
    let charname = document.getElementById("name").value;
    let strength = document.getElementById("strength").value;
    let dexterity = document.getElementById("dexterity").value;
    let constitution = document.getElementById("constitution").value;
    let intelligence = document.getElementById("intelligence").value;
    let wisdom = document.getElementById("wisdom").value;
    let charisma = document.getElementById("charisma").value;
    axios({
        method: 'post',
        url: 'http://localhost:8181/createCharacter',
        data: `{
            "name" : "${charname}",
            "maxHp" : 1,
            "currentHp" : 1,
            "exp" : 0,
            "skills": [
                {
                    "skillsId": 1,
                    "skillName": "History",
                    "statModifier": "Intelligence",
                    "fullProficiency": true
                },
                {
                    "skillsId": 2,
                    "skillName": "Deception",
                    "statModifier": "Charisma",
                    "fullProficiency": false
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
        headers: {'Content-Type': 'application/json' }
        })
        .then(function (response) {
            console.log(response);
        })
        .catch(function (response) {
            console.log(response);
        });
    }

let postButton = document.querySelector('#postButton');
postButton.addEventListener('click', postCharacterSheet);