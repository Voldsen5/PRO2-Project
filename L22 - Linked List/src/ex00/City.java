package ex00;

public class City {
    private final String name;
    private final int inhabitants;

    public City(String name, int inhabitants) {
        this.name = name;
        this.inhabitants = inhabitants;
    }

    @Override
    public String toString() {
        return name + ": " + inhabitants;
    }

    public String getName() {
        return name;
    }

    public int getInhabitants() {
        return inhabitants;
    }
}
