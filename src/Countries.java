import java.util.ArrayList;
import java.util.List;
public class Countries {
    private String name;
    private int population;
    private double GDP;
    private double treasury;
    private Regions region;
    Countries(String name, int population, double GDP, double treasury, Regions regions) {
        this.name = name;
        this.population = population;
        this.GDP = GDP;
        this.treasury = treasury;
        this.region = regions;
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

    

   public Regions getRegion() {
        return region;
    }

    public void setRegion(Regions region) {
        this.region = region;
    }
    public double getTreasury() {
        return treasury;
    }

    public String getName() {
        return name;
    }
    public String getRegions() {
        return region.getName();
    }

    public void setTreasury(double treasury) {
        this.treasury = treasury;
    }

   
}
