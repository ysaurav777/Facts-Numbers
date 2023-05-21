let factEl = document.getElementById("fact");
let userInputEl = document.getElementById("userInput");
let spinnerEl = document.getElementById("spinner");

function startUp(event) {
    if (event.key == "Enter") {
        if (userInput.value == "") {
            alert("Enter a number");
        } else {
            let options = {
                method: "GET"
            };

            spinnerEl.classList.remove("d-none");
            factEl.classList.add("d-none");

            fetch("https://apis.ccbp.in/numbers-fact?number=" + userInputEl.value, options)
                .then(function(response) {
                    return response.json();
                })
                .then(function(jsonText) {
                    spinnerEl.classList.add("d-none");
                    factEl.classList.remove("d-none");
                    let {
                        fact
                    } = jsonText;
                    factEl.textContent = fact;
                })
        }
    }
}

userInputEl.addEventListener("keydown", startUp);