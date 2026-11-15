import java.util.ArrayList;
public class Regions {
    private String name;
    public ArrayList<String> oceans;
    /**
     * Creates a regions using the given name, oceans.
     *
     * @param name the name (String)
     * @param oceans the oceans (list of String)
     */
    public Regions(String name, ArrayList<String> oceans) {
        this.name = name;
        this.oceans = new ArrayList<>(oceans);

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
     * @param name the name (String)
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Returns the oceans.
     * @return the oceans
     */
    public ArrayList<String> getOceans() {
        return oceans;
    }
    /**
     * Sets the oceans to the given ocean.
     *
     * @param oceans the oceans (list of String)
     */
    public void setOceans(ArrayList<String> oceans) {
        this.oceans = oceans;
    }
    /**
     * Adds ocean.
     *
     * @param ocean the ocean (String)
     */
    public void addOcean(String ocean) {
        oceans.add(ocean);
    }
}
