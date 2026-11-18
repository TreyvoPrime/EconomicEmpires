/**
*Infrastructure class includes buildings that involve supporting the country's efficiency and trade access.
**/
public class Infrastructure extends Buildings {

    private double tradeEfficiencyBenefit;
    /**
     * Creates an infrastructure using the given name, cost, trade efficiency benefit.
     *
     * @param name the name (text)
     * @param cost the cost (number)
     * @param tradeEfficiencyBenefit the trade efficiency benefit (number)
     */
    Infrastructure(String name, double cost, double tradeEfficiencyBenefit) {
        super(name, cost, "Trade Efficiency", "Infrastructure improves trading.");
        this.tradeEfficiencyBenefit = tradeEfficiencyBenefit;
    }

    // Overriding a method from Buildings
    @Override
    /**
     * Returns the information.
     * @return the information about a infrastructure
     */
    public String getInformation() {
        return super.getInformation() + " Trade efficiency benefit: " + tradeEfficiencyBenefit;
    }
    /**
     * Returns the trade efficiency benefit.
     * @return the trade benefit of a instrastructure
     */
    public double getTradeEfficiencyBenefit() {
        return tradeEfficiencyBenefit;
    }
    /**
     * Sets the trade efficiency benefit to the given trade efficiency benefit.
     *
     * @param tradeEfficiencyBenefit the trade efficiency benefit (number)
     */
    public void setTradeEfficiencyBenefit(double tradeEfficiencyBenefit) {
        this.tradeEfficiencyBenefit = tradeEfficiencyBenefit;
    }
}
