
// ChatGPT vibecoded, AI system for all the other countries in the game
/**
* The AI class Controls all other countries that the player does not control. 
* Choosing what the ai does each turn such as having a chance to build up to 2 factories per turn.
*/
import java.util.ArrayList;
import java.util.Random;

public class AI {

    public static void aiTurn(
    ArrayList<Countries> countries, 
    ArrayList<Resources> resources, 
    ArrayList<ArrayList<Resources>> countryProduction, 
    int playerCountryIndex) {

        Random random = new Random();

        for (int i = 0; i < countries.size(); i++) {

            // Skip the player's country
            if (i == playerCountryIndex) {
                continue;
            }

            Countries country = countries.get(i);
            ArrayList<Resources> production = countryProduction.get(i);

            // AI attempts to build 1-2 factories per turn
            int factoriesToBuild = random.nextInt(2) + 1;

            // 20% chance the AI doesn't build factories this turn
            if (random.nextInt(5) == 0) {
                factoriesToBuild = 0;
            }

            for (int f = 0; f < factoriesToBuild; f++) {

                // Make sure the country can afford a factory
                if (country.getTreasury() >= 6000) {

                    country.setTreasury(country.getTreasury() - 6000);

                    // Choose a random resource to produce
                    int resourceIndex = random.nextInt(resources.size());
                    Resources resource = resources.get(resourceIndex);

                    boolean found = false;

                    // Increase production if resource already exists
                    for (int r = 0; r < production.size(); r++) {

                        if (production.get(r).getName()
                        .equals(resource.getName())) {

                            production.get(r).setProductionDesired(
                            production.get(r).getProductionDesired() + 1);

                            found = true;
                            break;
                        }
                    }

                    // Otherwise start producing a new resource
                    if (!found) {
                        production.add(new Resources(
                        resource.getName(), 
                        resource.getRevenue(), 
                        resource.getCost(), 
                        1));
                    }
                }
            }

            // Calculate total resource revenue each term
            double totalRevenue = 0;

            for (int r = 0; r < production.size(); r++) {
                totalRevenue += production.get(r).getRevenue()
                * production.get(r).getProductionDesired();
            }

            // Add revenue to treasury and set annual GDP
            double taxRevenue = country.getPopulation() / 100.0;

            country.setTreasury(country.getTreasury() + totalRevenue + taxRevenue);
            country.setGDP(totalRevenue + taxRevenue);
        }
    }
}
