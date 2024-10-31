
document.addEventListener('DOMContentLoaded', function () {
    const foodCategoryContainer = document.getElementById('foodCategoryContainer');

    async function loadFoods() {
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
        foodCategoryContainer.innerHTML = ""; // Supprime le contenu existant

        const rowDiv = document.createElement("div");
        rowDiv.classList.add("row", "row-cols-1", "row-cols-md-2", "g-4");

        foods.forEach((food) => {
            const foodCol = document.createElement("div");
            foodCol.classList.add("col");

            foodCol.innerHTML = `
            <div class="card ">
                <img src="/img/${food.image1}" class="card-img-top card-img-size" alt="${food.titleHome} image">
                <div class="card-body">
                    <h5 class="card-title">${food.titleHome}</h5>
                    <p class="card-text">${food.descHome}</p>
                    <p class="card-text"><strong>Category:</strong> ${food.category}</p>
                    <a class="icon-link icon-link-hover" href="#"> Read more </a>    
                </div>
            </div>`;

            // Ajoute l'élément de colonne à la rangée
            rowDiv.appendChild(foodCol);
        });

        // Ajoute la rangée entière au conteneur
        foodCategoryContainer.appendChild(rowDiv);
    }


    // Charger les aliments initiaux
    loadFoods();
});


