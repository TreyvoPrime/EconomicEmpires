public class Resources {
    private String name;
    private double cost;
    private double revenue;
    private int productionDesired;

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

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }
    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getProductionDesired() {
        return productionDesired;
    }

    public void setProductionDesired(int productionDesired) {
        this.productionDesired = productionDesired;
    }
}
