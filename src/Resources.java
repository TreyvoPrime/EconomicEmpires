public class Resources {
    private String name;
    private double cost;
    private double revenue;

    Resources(String name, double revenue, double cost) {
        this.name = name;
        this.revenue = revenue;
        this.cost = cost;

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
}
