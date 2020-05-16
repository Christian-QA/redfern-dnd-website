
let charname = document.getElementById('#name')


const postCharacterSheet = () => {
    document.getElementById("name").innerHTML = charname;
    axios({
        method: 'post',
        url: 'http://localhost:8181/createCharacter',
        data: `{
            "name" : ${charname},
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
                    "abilitiesId": 2,
                    "strength": 14,
                    "dexterity": 12,
                    "constitution": 13,
                    "intelligence": 14,
                    "wisdom": 6,
                    "charisma": 14
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