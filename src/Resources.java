/**
* Resources class includes all the resources that can be produced by factories.
**/
public class Resources {
    private String name;
    private double cost;
    private double revenue;
    private int productionDesired;
    /**
     * Creates a resources using the given name, revenue, cost, production desired.
     *
     * @param name the name (text)
     * @param revenue the revenue (number)
     * @param cost the cost (number)
     * @param productionDesired the production desired (integer)
     */
    Resources(String name, double revenue, double cost, int productionDesired) {
        this.name = name;
        this.revenue = revenue;
        this.cost = cost;
        this.productionDesired = productionDesired;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    /**
     * Returns the revenue.
     * @return the revenue
     */
    public double getRevenue() {
        return revenue;
    }
    /**
     * Sets the revenue to the given revenue.
     *
     * @param revenue the revenue (number)
     */
    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }
    /**
     * Returns the cost.
     * @return the cost
     */
    public double getCost() {
        return cost;
    }
    /**
     * Sets the cost to the given cost.
     *
     * @param cost the cost (number)
     */
    public void setCost(double cost) {
        this.cost = cost;
    }
    /**
     * Returns the production desired.
     * @return the production desired
     */
    public int getProductionDesired() {
        return productionDesired;
    }
    /**
     * Sets the production desired to the given production desired.
     *
     * @param productionDesired the production desired (integer)
     */
    public void setProductionDesired(int productionDesired) {
        this.productionDesired = productionDesired;
    }
    /**
     * Calculates revenue.
     * @return the revenue (number)
     */
    public double calculateRevenue() {
        return revenue * productionDesired;
    }
}
