window.addEventListener("load", (event) => {
    const request = new XMLHttpRequest();
    const url='/restservices/recepten';
    request.open("GET", url);
    request.setRequestHeader("Content-Type", "application/json");

    request.send();

    request.onreadystatechange = (response) => {
        const recepten = JSON.parse(response.target.response);

        const receptContainer = document.getElementById("receptenContainer");

        // Maak ruimte voor resultaten in de html
        receptContainer.replaceChildren();

        // Maak elementen voor elk recept
        recepten.forEach(recept => {
            const divElement = document.createElement("div");
            divElement.innerHTML = "Naam: " + recept.receptNaam + ", Beschrijving: "+ recept.beschrijving + ", Ingredienten: " + recept.ingredienten.map(ingredient => ingredient.naam).join(', ')
            receptContainer.appendChild(divElement)
        });
    }
});