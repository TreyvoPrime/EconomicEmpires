import java.util.ArrayList;
import java.util.List;
public class Countries {
    private String name;
    private int population;
    private double GDP;
    private double treasury;
    private Regions region;
    private double popGrowthRate;
    private int farmsBuilt;
    /**
     * Creates a country using the given name, population, gdp, treasury, regions, pop growth rate.
     *
     * @param name the name (text)
     * @param population the population (integer)
     * @param GDP the gdp (number)
     * @param treasury the treasury (number)
     * @param regions the regions
     * @param popGrowthRate the pop growth rate (number)
     */
    Countries(String name, int population, double GDP, double treasury, Regions regions, double popGrowthRate) {
        this.name = name;
        this.population = population;
        this.GDP = GDP;
        this.treasury = treasury;
        this.region = regions;
        this.popGrowthRate = popGrowthRate;
    }
    /**
     * Returns the countries name.
     * @return the countries name
     */
    public String getCountriesName() {
        return name;
    }
    /**
     * Sets the name to the given name.
     *
     * @param name the name (text)
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Returns the population.
     * @return the population
     */
    public int getPopulation() {
        return population;
    }
    /**
     * Sets the population to the given population.
     *
     * @param population the population (integer)
     */
    public void setPopulation(int population) {
        this.population = population;
    }
    /**
     * Returns the gdp.
     * @return the gdp
     */
    public double getGDP() {
        return GDP;
    }
    /**
     * Sets the gdp to the given gdp.
     *
     * @param GDP the gdp (number)
     */
    public void setGDP(double GDP) {
        this.GDP = GDP;
    }


    /**
     * Returns the region.
     * @return the region
     */
    public Regions getRegion() {
        return region;
    }
    /**
     * Sets the region to the given region.
     *
     * @param region the region (regions)
     */
    public void setRegion(Regions region) {
        this.region = region;
    }
    /**
     * Returns the treasury.
     * @return the treasury
     */
    public double getTreasury() {
        return treasury;
    }
    /**
     * Returns the name.
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * Returns the regions.
     * @return the regions
     */
    public String getRegions() {
        return region.getName();
    }
    /**
     * Sets the treasury to the given treasury.
     *
     * @param treasury the treasury (number)
     */
    public void setTreasury(double treasury) {
        this.treasury = treasury;

    }
    /**
     * Returns the farms built.
     * @return the farms built
     */
    public int getFarmsBuilt() {
        return farmsBuilt;
    }
    /**
     * Applies pop growth.
     *
     * @param population the population (integer)
     * @param farmsBuilt the farms built (integer)
     * @param popGrowthRate the pop growth rate (number)
     * @return the pop growth (integer)
     */
    public int applyPopGrowth(int population, int farmsBuilt, double popGrowthRate) {

        double farmBonus = farmsBuilt * 0.01;

        double adjustedGrowthRate = popGrowthRate + farmBonus;

        this.population = (int) (population * adjustedGrowthRate);

        return this.population;
    }

    /**
     * Returns the pop growth rate.
     * @return the pop growth rate
     */
    public double getPopGrowthRate() {
        return popGrowthRate;
    }
    /**
     * Sets the pop growth rate to the given pop growth rate.
     *
     * @param popGrowthRate the pop growth rate (number)
     */
    public void setPopGrowthRate(double popGrowthRate) {
        this.popGrowthRate = popGrowthRate;
    }
    /**
     * Sets the farms built to the given farms built.
     *
     * @param farmsBuilt the farms built (integer)
     */
    public void setFarmsBuilt(int farmsBuilt) {
        this.farmsBuilt = farmsBuilt;
    }
}
