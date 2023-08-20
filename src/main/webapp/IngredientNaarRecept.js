window.addEventListener("load", (event) => {
    const resultsContainer = document.getElementById("results");

    const ingredientForm = document.getElementById("ingredientForm");

    ingredientForm.addEventListener("submit", (e) => {
        // Voorkom dat submit pagina herlaadt
        e.preventDefault();

        const ingredient = document.getElementById("ingredient").value;

        // Maak request
        const request = new XMLHttpRequest();
        var url= '/restservices/recepten';
        url += '?ingredient='+ingredient;
        request.open("GET", url);
        request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

        request.send();

        request.onreadystatechange = (response) => {
            // Leeg vorige resultaten
            resultsContainer.replaceChildren();

            const recepten = JSON.parse(response.target.response);

            // Maak een nieuw element aan voor elk recept
            recepten.forEach(recept => {
                const divElement = document.createElement("div");
                divElement.innerHTML = "Naam: " + recept.receptNaam + ", Beschrijving: "+ recept.beschrijving + ", Ingredienten: " + recept.ingredienten.map(ingredient => ingredient.naam).join(', ')
                resultsContainer.appendChild(divElement)
            });
        }
    });

});