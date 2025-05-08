const recomendaciones = {
    "The Witcher 3": ["Skyrim", "Dragon Age: Inquisition", "Assassin's Creed Valhalla"],
    "Skyrim": ["The Witcher 3", "Elden Ring", "Dark Souls III"],
    "Dark Souls III": ["Sekiro", "Bloodborne", "Elden Ring"],
    "Elden Ring": ["Dark Souls III", "Skyrim", "Bloodborne"],
    "Minecraft": ["Terraria", "Stardew Valley", "Don't Starve"],
    "GTA V": ["Red Dead Redemption 2", "Sleeping Dogs", "Mafia II"],
    "Red Dead Redemption 2": ["GTA V", "Horizon Zero Dawn", "The Last of Us"],
    "The Last of Us": ["Red Dead Redemption 2", "Days Gone", "Uncharted 4"],
    "Uncharted 4": ["The Last of Us", "Tomb Raider", "Assassin's Creed"],
    "God of War": ["Horizon Zero Dawn", "The Last of Us", "Ghost of Tsushima"],
    "Ghost of Tsushima": ["Sekiro", "Assassin's Creed", "God of War"],
    "Cyberpunk 2077": ["Deus Ex: Mankind Divided", "Watch Dogs", "GTA V"],
    "Horizon Zero Dawn": ["God of War", "The Last of Us", "Assassin's Creed Odyssey"],
    "Assassin's Creed Odyssey": ["Valhalla", "Origins", "Horizon Zero Dawn"],
    "Valorant": ["CS:GO", "Overwatch", "Rainbow Six Siege"],
    "CS:GO": ["Valorant", "Rainbow Six Siege", "Call of Duty"],
    "Overwatch": ["Paladins", "Valorant", "Apex Legends"],
    "Apex Legends": ["Overwatch", "Warzone", "Fortnite"],
    "Fortnite": ["Apex Legends", "PUBG", "Minecraft"],
    "League of Legends": ["Dota 2", "Smite", "Heroes of the Storm"],
    "Dota 2": ["League of Legends", "Smite", "Arena of Valor"],
    "Among Us": ["Goose Goose Duck", "Town of Salem", "Project Winter"],
    "Fall Guys": ["Among Us", "Party Animals", "Human: Fall Flat"],
    "FIFA 23": ["eFootball", "NBA 2K", "Rocket League"],
    "NBA 2K": ["FIFA 23", "Madden NFL", "WWE 2K"],
    "Rocket League": ["FIFA", "Trackmania", "Wipeout"],
    "Terraria": ["Minecraft", "Starbound", "Stardew Valley"],
    "Stardew Valley": ["Terraria", "Harvest Moon", "Animal Crossing"],
    "Animal Crossing": ["Stardew Valley", "The Sims", "My Time at Portia"],
    "The Sims": ["Animal Crossing", "SimCity", "Cities Skylines"]
};

const form = document.getElementById("form-juegos");
const inputJuego = document.getElementById("juego");
const listaJugados = document.getElementById("lista-jugados");
const listaRecomendaciones = document.getElementById("lista-recomendaciones");
const contenedorRecomendaciones = document.getElementById("recomendaciones");

const juegosIngresados = new Set();

inputJuego.addEventListener("keypress", function (e) {
    if (e.key === "Enter") {
        e.preventDefault();
        const juego = inputJuego.value.trim();
        if (juego && !juegosIngresados.has(juego)) {
            juegosIngresados.add(juego);
            const li = document.createElement("li");
            li.textContent = juego;
            listaJugados.appendChild(li);
        }
        inputJuego.value = "";
    }
});

form.addEventListener("submit", function (e) {
    e.preventDefault();
    const sugerencias = new Set();

    juegosIngresados.forEach(juego => {
        const sugeridos = recomendaciones[juego];
        if (sugeridos) {
            sugeridos.forEach(sugerido => {
                if (!juegosIngresados.has(sugerido)) {
                    sugerencias.add(sugerido);
                }
            });
        }
    });

    listaRecomendaciones.innerHTML = "";

    if (sugerencias.size > 0) {
        sugerencias.forEach(juego => {
            const li = document.createElement("li");
            li.textContent = juego;
            listaRecomendaciones.appendChild(li);
        });
        contenedorRecomendaciones.classList.remove("oculto");
    } else {
        const li = document.createElement("li");
        li.textContent = "No se encontraron recomendaciones.";
        listaRecomendaciones.appendChild(li);
        contenedorRecomendaciones.classList.remove("oculto");
    }
});
