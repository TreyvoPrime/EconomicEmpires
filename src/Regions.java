import java.util.ArrayList;
public class Regions {
    private String name;
    public ArrayList<String> oceans;


    public Regions(String name, ArrayList<String> oceans) {
        this.name = name;
        this.oceans = new ArrayList<>(oceans);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getOceans() {
        return oceans;
    }

    public void setOceans(ArrayList<String> oceans) {
        this.oceans = oceans;
    }
    public void addOcean(String ocean) {
        oceans.add(ocean);
    }
}
