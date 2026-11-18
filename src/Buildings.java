/**
*The buildings class contains the attributes of every building. Buildings are used to help provide the necesities needed 
* to  improve a countries economy.
*/
public class Buildings {
    private String name;
    private double cost;
    public String effect;
    public String information;
    /**
     * Creates a buildings using the given name, cost, effect, information.
     *
     * @param name the name of the building (text)
     * @param cost the cost of the building  (number)
     * @param effect the effect t he building has (text)
     * @param information the information about the building (text)
     */
    Buildings(String name, double cost, String effect, String information) {
        this.name = name;
        this.cost = cost;
        this.effect = effect;
        this.information = information;

    }
    /**
     * Returns the name.
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * Returns the cost.
     * @return the cost
     */
    public double getCost() {
        return cost;
    }
    /**
     * Returns the effect.
     * @return the effect
     */
    public String getEffect() {
        return effect;
    }
    /**
     * Returns the information.
     * @return the information
     */
    public String getInformation() {
        return information;
    }
    /**
     * Sets the name to the given name.
     *
     * @param name the name of a building (text)
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Sets the cost to the given cost.
     *
     * @param cost the cost of a building (number)
     */
    public void setCost(double cost) {
        this.cost = cost;
    }
    /**
     * Sets the effect to the given effect.
     *
     * @param effect the effect of a building (text)
     */
    public void setEffect(String effect) {
        this.effect = effect;
    }
    /**
     * Sets the information to the given information.
     *
     * @param information the information about a building (text)
     */
    public void setInformation(String information) {
        this.information = information;
    }

}
