import java.util.Scanner;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Collections;


public class RecomendadorJuegosSimple {

    public static void main(String[] args) {
        Map<String, List<String>> recomendaciones = new HashMap<>();

        // BASE DE DATOS DE JUEGOS Y RECOMENDACIONES
        recomendaciones.put("The Witcher 3", Arrays.asList("Skyrim", "Dragon Age: Inquisition", "Assassin's Creed Valhalla"));
        recomendaciones.put("Skyrim", Arrays.asList("The Witcher 3", "Elden Ring", "Dark Souls III"));
        recomendaciones.put("Dark Souls III", Arrays.asList("Sekiro", "Bloodborne", "Elden Ring"));
        recomendaciones.put("Elden Ring", Arrays.asList("Dark Souls III", "Skyrim", "Bloodborne"));
        recomendaciones.put("Minecraft", Arrays.asList("Terraria", "Stardew Valley", "Don't Starve"));
        recomendaciones.put("GTA V", Arrays.asList("Red Dead Redemption 2", "Sleeping Dogs", "Mafia II"));
        recomendaciones.put("Red Dead Redemption 2", Arrays.asList("GTA V", "Horizon Zero Dawn", "The Last of Us"));
        recomendaciones.put("The Last of Us", Arrays.asList("Red Dead Redemption 2", "Days Gone", "Uncharted 4"));
        recomendaciones.put("Uncharted 4", Arrays.asList("The Last of Us", "Tomb Raider", "Assassin's Creed"));
        recomendaciones.put("God of War", Arrays.asList("Horizon Zero Dawn", "The Last of Us", "Ghost of Tsushima"));
        recomendaciones.put("Ghost of Tsushima", Arrays.asList("Sekiro", "Assassin's Creed", "God of War"));
        recomendaciones.put("Cyberpunk 2077", Arrays.asList("Deus Ex: Mankind Divided", "Watch Dogs", "GTA V"));
        recomendaciones.put("Horizon Zero Dawn", Arrays.asList("God of War", "The Last of Us", "Assassin's Creed Odyssey"));
        recomendaciones.put("Assassin's Creed Odyssey", Arrays.asList("Valhalla", "Origins", "Horizon Zero Dawn"));
        recomendaciones.put("Valorant", Arrays.asList("CS:GO", "Overwatch", "Rainbow Six Siege"));
        recomendaciones.put("CS:GO", Arrays.asList("Valorant", "Rainbow Six Siege", "Call of Duty"));
        recomendaciones.put("Overwatch", Arrays.asList("Paladins", "Valorant", "Apex Legends"));
        recomendaciones.put("Apex Legends", Arrays.asList("Overwatch", "Warzone", "Fortnite"));
        recomendaciones.put("Fortnite", Arrays.asList("Apex Legends", "PUBG", "Minecraft"));
        recomendaciones.put("League of Legends", Arrays.asList("Dota 2", "Smite", "Heroes of the Storm"));
        recomendaciones.put("Dota 2", Arrays.asList("League of Legends", "Smite", "Arena of Valor"));
        recomendaciones.put("Among Us", Arrays.asList("Goose Goose Duck", "Town of Salem", "Project Winter"));
        recomendaciones.put("Fall Guys", Arrays.asList("Among Us", "Party Animals", "Human: Fall Flat"));
        recomendaciones.put("FIFA 23", Arrays.asList("eFootball", "NBA 2K", "Rocket League"));
        recomendaciones.put("NBA 2K", Arrays.asList("FIFA 23", "Madden NFL", "WWE 2K"));
        recomendaciones.put("Rocket League", Arrays.asList("FIFA", "Trackmania", "Wipeout"));
        recomendaciones.put("Terraria", Arrays.asList("Minecraft", "Starbound", "Stardew Valley"));
        recomendaciones.put("Stardew Valley", Arrays.asList("Terraria", "Harvest Moon", "Animal Crossing"));
        recomendaciones.put("Animal Crossing", Arrays.asList("Stardew Valley", "The Sims", "My Time at Portia"));
        recomendaciones.put("The Sims", Arrays.asList("Animal Crossing", "SimCity", "Cities Skylines"));

        Scanner sc = new Scanner(System.in);
        Set<String> jugados = new HashSet<>();

        System.out.println("¿Qué juegos has jugado? (escribe 'fin' para terminar)");

        while (true) {
            System.out.print("Juego: ");
            String juego = sc.nextLine();
            if (juego.equalsIgnoreCase("fin")) break;
            jugados.add(juego);
        }
        
        Set<String> sugerencias = new HashSet<>();
        for (String juego : jugados) {
            List<String> lista = recomendaciones.getOrDefault(juego, Collections.emptyList());
            for (String sugerido : lista) {
                if (!jugados.contains(sugerido)) {
                    sugerencias.add(sugerido);
                }
            }
        }
        //MOSTRAR LAS RECOMENDACIONES
        System.out.println("\nTe podrían gustar estos juegos:");
        if (sugerencias.isEmpty()) {
            System.out.println("No se encontraron recomendaciones.");
        } else {
            for (String juego : sugerencias) {
                System.out.println("- " + juego);
            }
        }

        sc.close();
    }
}
