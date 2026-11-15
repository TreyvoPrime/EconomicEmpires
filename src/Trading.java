
import java.util.ArrayList;
import java.util.Scanner;
// ChatGPT vibecoded: Trading class I added the emojis, and changed around some output text. Modified to also print out the region with the countrie being listed. 
public class Trading {

    static ArrayList<Integer> partners = new ArrayList<>();
    static ArrayList<String> exports = new ArrayList<>();
    /**
     * Trades an input.
     *
     * @param input the Scanner used to read input
     * @param countries the countries (list of countries)
     * @param playerCountryIndex the player country index (integer)
     * @param resources the resources (list of resources)
     * @param oceanBoolList the ocean bool list (list of true/false value)
     * @param tradeEfficiency the trade efficiency (number)
     * @param countryProduction the country production (list of list of resources)
     */
    public static void trade(Scanner input, ArrayList<Countries> countries, 
    int playerCountryIndex, ArrayList<Resources> resources, 
    ArrayList<Boolean> oceanBoolList, double tradeEfficiency, 
    ArrayList<ArrayList<Resources>> countryProduction) {

        System.out.println("\n---⛵ International Trading---");
        System.out.println("1. 🤝 Establish Trade");
        System.out.println("2. 📋 View/Cancel Trades");
        int option = input.nextInt();

        if (option == 2) {
            if (partners.isEmpty()) {
                System.out.println("No active trades!");
                return;
            }

            for (int i = 0; i < partners.size(); i++) {
                System.out.println(i + ". " + countries.get(partners.get(i)).getName()
                + " | " + exports.get(i));
            }

            System.out.println("Enter trade index to cancel, or -1 to go back:");
            int cancel = input.nextInt();

            if (cancel >= 0 && cancel < partners.size()) {
                partners.remove(cancel);
                exports.remove(cancel);
                System.out.println("❌ Trade agreement cancelled!");
            }
            return;
        }

        if (option != 1) return;

        // Choose trading country
        for (int i = 0; i < countries.size(); i++) {
            if (i != playerCountryIndex)
            System.out.println(i + ". " + countries.get(i).getName() + " - " + countries.get(i).getRegion().getName());
        }

        System.out.println("What country would you like to trade with?");
        int partnerIndex = input.nextInt();

        if (partnerIndex < 0 || partnerIndex >= countries.size()
        || partnerIndex == playerCountryIndex) {
            System.out.println("❌ Invalid country!");
            return;
        }

        Countries player = countries.get(playerCountryIndex);
        Countries partner = countries.get(partnerIndex);

        boolean sameRegion = player.getRegion().getName()
        .equalsIgnoreCase(partner.getRegion().getName());

        boolean hasPort = false;
        for (int i = 0; i < oceanBoolList.size(); i++) {
            if (oceanBoolList.get(i)) hasPort = true;
        }

        if (!sameRegion && !hasPort) {
            System.out.println("❌ You need a port to trade outside your region!");
            return;
        }

        // Choose a resource currently in production
        System.out.println("\n---📦 Available Exports---");
        for (int i = 0; i < resources.size(); i++) {
            if (resources.get(i).getProductionDesired() > 0)
            System.out.println(i + ". " + resources.get(i).getName());
        }

        System.out.println("Choose a resource index:");
        int resourceIndex = input.nextInt();

        if (resourceIndex < 0 || resourceIndex >= resources.size()
        || resources.get(resourceIndex).getProductionDesired() <= 0) {
            System.out.println("❌ Invalid resource!");
            return;
        }

        String resourceName = resources.get(resourceIndex).getName();

        for (int i = 0; i < partners.size(); i++) {
            if (partners.get(i) == partnerIndex && exports.get(i).equals(resourceName)) {
                System.out.println("⚠️ This agreement already exists!");
                return;
            }
        }

        partners.add(partnerIndex);
        exports.add(resourceName);

        System.out.println("✅ Trade established with " + partner.getName());
        System.out.println("📦 Exporting: " + resourceName);
        System.out.println("💵 Revenue will be collected every term!");
    }

    public static void processTurn(ArrayList<Countries> countries, 
    int playerCountryIndex, ArrayList<Resources> resources, 
    ArrayList<ArrayList<Resources>> countryProduction, 
    double tradeEfficiency) {

        Countries player = countries.get(playerCountryIndex);
        double totalRevenue = 0;

        for (int i = 0; i < partners.size(); i++) {
            double revenue = 0;
            boolean alreadyProduces = false;
            String resourceName = exports.get(i);

            for (int r = 0; r < resources.size(); r++) {
                if (resources.get(r).getName().equals(resourceName)) {
                    revenue = resources.get(r).getRevenue()
                    * resources.get(r).getProductionDesired();
                    break;
                }
            }

            ArrayList<Resources> partnerProduction =
            countryProduction.get(partners.get(i));

            for (int r = 0; r < partnerProduction.size(); r++) {
                if (partnerProduction.get(r).getName().equals(resourceName)
                && partnerProduction.get(r).getProductionDesired() > 0) {
                    alreadyProduces = true;
                    break;
                }
            }

            revenue *= (alreadyProduces ? -0.5 : 1.5) * tradeEfficiency;

            if (revenue < 0 && player.getTreasury() + totalRevenue + revenue < 0) {
                System.out.println("⚠️ Cannot afford trade loss: " + resourceName);
                continue;
            }

            totalRevenue += revenue;
            System.out.println("🤝 " + countries.get(partners.get(i)).getName()
            + " | " + resourceName + " | 💵 $" + revenue);
        }

        player.setTreasury(player.getTreasury() + totalRevenue);
        player.setGDP(player.getGDP() + totalRevenue);

        System.out.println("⛵ Total Trade Revenue: $" + totalRevenue);
    }
}
