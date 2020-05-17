


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
        console.log(response);
    })
    .catch(function (response) {
        console.log(response);
    });


    
    axios({
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