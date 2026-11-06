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
    public String getName() {
        return name;
    }
    public double getCost() {
        return cost;
    }
    public String getEffect() {
        return effect;
    }
    public String getInformation() {
        return information;
    }
     
    public void setName(String name) {
        this.name = name;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public void setInformation(String information) {
        this.information = information;
    }

}
