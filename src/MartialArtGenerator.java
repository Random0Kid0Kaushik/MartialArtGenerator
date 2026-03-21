import java.util.*;

public class MartialArtGenerator {

    public static void main(String[] args) {
        Random rand = new Random();

        List<MartialArt> arts = new ArrayList<>();

        // 🌏 Asia
        arts.add(new MartialArt("Muay Thai", "Striking", "Asia"));
        arts.add(new MartialArt("Karate", "Striking", "Asia"));
        arts.add(new MartialArt("Taekwondo", "Striking", "Asia"));
        arts.add(new MartialArt("Kung Fu", "Striking", "Asia"));
        arts.add(new MartialArt("Judo", "Grappling", "Asia"));
        arts.add(new MartialArt("Brazilian Jiu-Jitsu (Japanese roots)", "Grappling", "Asia"));

        // 🌍 Europe
        arts.add(new MartialArt("Boxing", "Striking", "Europe"));
        arts.add(new MartialArt("Savate", "Striking", "Europe"));
        arts.add(new MartialArt("Kickboxing (Dutch style)", "Striking", "Europe"));
        arts.add(new MartialArt("Wrestling", "Grappling", "Europe"));
        arts.add(new MartialArt("Sambo", "Grappling", "Europe"));

        // 🌎 North America
        arts.add(new MartialArt("American Kickboxing", "Striking", "North America"));
        arts.add(new MartialArt("Jeet Kune Do", "Striking", "North America"));
        arts.add(new MartialArt("Collegiate Wrestling", "Grappling", "North America"));
        arts.add(new MartialArt("Catch Wrestling", "Grappling", "North America"));

        // 🌎 South America
        arts.add(new MartialArt("Capoeira", "Striking", "South America"));
        arts.add(new MartialArt("Luta Livre", "Grappling", "South America"));
        arts.add(new MartialArt("Brazilian Jiu-Jitsu", "Grappling", "South America"));

        // 🌍 Africa
        arts.add(new MartialArt("Dambe", "Striking", "Africa"));
        arts.add(new MartialArt("Laamb (Senegalese Wrestling)", "Grappling", "Africa"));
        arts.add(new MartialArt("Nguni Stick Fighting", "Striking", "Africa"));

        // 🌏 Australia
        arts.add(new MartialArt("Boxing (AUS circuit)", "Striking", "Australia"));
        arts.add(new MartialArt("Freestyle Wrestling (AUS)", "Grappling", "Australia"));
        arts.add(new MartialArt("MMA (AUS hybrid)", "Grappling", "Australia"));

        // 🌌 BEST APPROACH: Pick a real martial art first
        MartialArt selected = arts.get(rand.nextInt(arts.size()));

        String chosenType = selected.getType();
        String chosenContinent = selected.getContinent();
        String chosenArt = selected.getName();

        // ⚖️ Weighted Rarity
        String chosenRarity = getWeightedRarity(rand);

        // 🎯 Output
        System.out.println("=== Martial Art Roll ===");
        System.out.println("Type: " + chosenType);
        System.out.println("Continent: " + chosenContinent);
        System.out.println("Style: " + chosenArt);
        System.out.println("Rarity: " + chosenRarity);
    }

    public static String getWeightedRarity(Random rand) {
        int roll = rand.nextInt(100);

        if (roll < 60) return "Common";
        else if (roll < 90) return "Uncommon";
        else return "Rare";
    }
}