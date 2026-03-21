public class MartialArt {
    private final String name;
    private final String type;
    private final String continent;

    public MartialArt(String name, String type, String continent) {
        this.name = name;
        this.type = type;
        this.continent = continent;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getContinent() {
        return continent;
    }
}