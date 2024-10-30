document.addEventListener("DOMContentLoaded", () => {
    const foodContainer = document.querySelector("#foodListContainer");

    // Fonction pour charger les aliments initiaux
    async function loadInitialFood() {
        try {
            // Requête GET pour récupérer tous les aliments
            const response = await fetch("/api/foods");

            // Vérifie si la requête a échoué
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }

            // Convertit la réponse en format JSON
            const foods = await response.json();

            // Met à jour le contenu de la section alimentaire avec les données récupérées
            updateFoodContent(foods);
        } catch (err) {
            // Affiche une erreur si la requête échoue
            console.log("Failed to fetch foods: ", err);
        }
    }

    // Fonction pour mettre à jour le contenu de la section alimentaire
    function updateFoodContent(foods) {
        foodContainer.innerHTML = ""; // Supprime le contenu existant

        foods.forEach((food, index) => {
            const foodDiv = document.createElement("div");
            foodDiv.classList.add("row", "mb-4", "align-items-center");

            // Si l'index est pair, le texte est à gauche, sinon il est à droite
            if (index % 2 === 0) {
                // Texte à gauche, image à droite
                foodDiv.innerHTML = `
                <div class="col-md-6">
                    <h2>${food.titleHome}</h2>
                    <p>${food.descHome}</p>
                    <p><strong>Category:</strong> ${food.category}</p>
                    <p><strong>Date:</strong> ${food.date}</p>
                </div>
                <div class="col-md-6 d-flex justify-content-center">
                    <img src="/img/${food.image1}" class="img-fluid" alt="${food.titleHome} image">
                </div>
            `;
            } else {
                // Image à gauche, texte à droite
                foodDiv.innerHTML = `
                <div class="col-md-6 d-flex justify-content-center">
                    <img src="/img/${food.image1}" class="img-fluid" alt="${food.titleHome} image">
                </div>
                <div class="col-md-6">
                    <h2>${food.titleHome}</h2>
                    <p>${food.descHome}</p>
                    <p><strong>Category:</strong> ${food.category}</p>
                    <p><strong>Date:</strong> ${food.date}</p>
                </div>
            `;
            }

            // Ajoute l'élément au conteneur
            foodContainer.appendChild(foodDiv);
        });
    }



    // Charger les aliments initiaux
    loadInitialFood();
});
