/**
*The production class includes buildings that involve economic productions
*
*/
public class Production {
    private String name;
    private double cost;
    private String effect;
    private String information;
    private int productionSlots;
    /**
     * Creates a production using the given name, cost, effect, information, production slots.
     *
     * @param name the name (text)
     * @param cost the cost (number)
     * @param effect the effect (text)
     * @param information the information (text)
     * @param productionSlots the production slots (integer)
     */
    Production(String name, double cost, String effect, String information, int productionSlots) {
        this.name = name;
        this.cost = cost;
        this.effect = effect;
        this.information = information;
        this.productionSlots = productionSlots;
    }
    /**
     * Returns the name.
     * @return the name
     */
    public String getName() {
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
     * Returns the effect.
     * @return the effect
     */
    public String getEffect() {
        return effect;
    }
    /**
     * Sets the effect to the given effect.
     *
     * @param effect the effect (text)
     */
    public void setEffect(String effect) {
        this.effect = effect;
    }
    /**
     * Returns the information.
     * @return the information
     */
    public String getInformation() {
        return information;
    }
    /**
     * Sets the information to the given information.
     *
     * @param information the information about a object of production class (text)
     */
    public void setInformation(String information) {
        this.information = information;
    }
    /**
     * Returns the production slots.
     * @return the production slots
     */
    public int getProductionSlots() {
        return productionSlots;
    }
    /**
     * Sets the production slots to the given production slots.
     *
     * @param productionSlots the production slots (integer)
     */
    public void setProductionSlots(int productionSlots) {
        this.productionSlots = productionSlots;
    }

}
