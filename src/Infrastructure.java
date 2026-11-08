public class Infrastructure {
    String name;
    double cost;
    double tradeEfficiencyBenefit;
    Infrastructure(String name, double cost, double tradeEfficiencyBenefit) {
        this.name = name;
        this.cost = cost;
        this.tradeEfficiencyBenefit = tradeEfficiencyBenefit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getTradeEfficiencyBenefit() {
        return tradeEfficiencyBenefit;
    }

    public void setTradeEfficiencyBenefit(double tradeEfficiencyBenefit) {
        this.tradeEfficiencyBenefit = tradeEfficiencyBenefit;
    }
}
