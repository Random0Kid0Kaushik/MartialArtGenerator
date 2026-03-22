import java.util.*;

public class MartialArtApp {

    static final Scanner scanner = new Scanner(System.in);
    static final Random rand = new Random();
    static final LinkedList<String> history = new LinkedList<>();

    public static void main(String[] args) {

        var arts = initializeArts();

        while (true) {
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1. Roll Martial Art");
            System.out.println("2. View Past 5 Rolls");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            var choice = scanner.nextLine();

            switch (choice) {
                case "1" -> rollMenu(arts);
                case "2" -> viewHistory();
                case "3" -> {
                    System.out.println("Exiting... Stay sharp, fighter.");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // 🎲 Rolling Logic
    static void rollMenu(List<MartialArt> arts) {
        while (true) {
            var selected = arts.get(rand.nextInt(arts.size()));
            var rarity = getWeightedRarity();

            var result = "%s | %s | %s | %s"
                    .formatted(selected.name(), selected.type(), selected.continent(), rarity);

            history.addFirst(result);
            if (history.size() > 5) history.removeLast();

            System.out.println("\n=== Martial Art Roll ===");
            System.out.println(result);

            System.out.print("\nRoll again? (y/n): ");
            if (!scanner.nextLine().equalsIgnoreCase("y")) break;
        }
    }

    // 📜 History View
    static void viewHistory() {
        System.out.println("\n=== Last 5 Rolls ===");

        if (history.isEmpty()) {
            System.out.println("No rolls yet.");
        } else {
            for (int i = 0; i < history.size(); i++) {
                System.out.println((i + 1) + ". " + history.get(i));
            }
        }

        System.out.print("\nReturn to main menu? (y): ");
        scanner.nextLine();
    }

    // ⚖️ Weighted Rarity
    static String getWeightedRarity() {
        var roll = rand.nextInt(100);

        return (roll < 60) ? "Common"
             : (roll < 90) ? "Uncommon"
             : "Rare";
    }

    // 🌍 Data Initialization
    static List<MartialArt> initializeArts() {
        return List.of(
            new MartialArt("Muay Thai", "Striking", "Asia"),
            new MartialArt("Karate", "Striking", "Asia"),
            new MartialArt("Judo", "Grappling", "Asia"),

            new MartialArt("Boxing", "Striking", "Europe"),
            new MartialArt("Wrestling", "Grappling", "Europe"),

            new MartialArt("Brazilian Jiu-Jitsu", "Grappling", "South America"),
            new MartialArt("Capoeira", "Striking", "South America"),

            new MartialArt("Jeet Kune Do", "Striking", "North America"),
            new MartialArt("Catch Wrestling", "Grappling", "North America"),

            new MartialArt("Dambe", "Striking", "Africa"),
            new MartialArt("Laamb", "Grappling", "Africa"),

            new MartialArt("MMA (AUS)", "Grappling", "Australia"),
            new MartialArt("Boxing (AUS)", "Striking", "Australia")
        );
    }
}