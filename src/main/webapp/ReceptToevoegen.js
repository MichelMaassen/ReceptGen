window.addEventListener("load", (event) => {
    const receptForm = document.getElementById("receptForm");

    receptForm.addEventListener("submit", (e) => {
        // Voorkom dat submit pagina herlaadt
        e.preventDefault();

        // Haal values uit de elementen
        const ingredient = document.getElementById("ingredient").value;
        const receptNaam = document.getElementById("receptNaam").value;
        const beschrijving = document.getElementById("beschrijving").value;

        // Maak request met form data
        const request = new XMLHttpRequest();
        const url='/restservices/recepten/nieuwrecept';
        request.open("POST", url);
        request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

        // Maak formdata om te verzenden
        var formData = 'receptNaam=' + receptNaam;
        formData += '&ingredienten='+ ingredient;
        formData += '&beschrijving=' + beschrijving;

        request.send(formData);

        request.onreadystatechange = (e) => {
            // Bij antwoord van de server, pagina herladen
            location.reload();
        }
    });
});