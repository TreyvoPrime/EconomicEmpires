import java.util.ArrayList;
import java.util.List;
public class Countries {
    private String name;
    private int population;
    private double GDP;
    private String region;
    Countries(String name, int population, double GDP, String region) {
        this.name = name;
        this.population = population;
        this.GDP = GDP;
        this.region = region; 
    }

    public String getCountriesName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getGDP() {
        return GDP;
    }

    public void setGDP(double GDP) {
        this.GDP = GDP;
    }

    public String getRegions() {
        return region;
    }

    public void setRegions(List<String> regions) {
        this.region = region;
    }
}
