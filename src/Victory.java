/**
* Victory class used to calculate if a country has achieved conditions for a victory and print out the victory message
**/
//vibecoded ChatGPT, Victory class for controlling over 25 percent of world GDP
import java.util.ArrayList;

public class Victory {

    public static boolean check(ArrayList<Countries> countries, 
    ArrayList<ArrayList<Resources>> countryProduction) {

        double worldGDP = 0;

        for (int i = 0; i < countries.size(); i++) {
            worldGDP += countries.get(i).getGDP();
        }

        if (worldGDP <= 0) return false;

        for (int i = 0; i < countries.size(); i++) {
            double percentage = countries.get(i).getGDP() / worldGDP * 100;

            if (percentage > 25) {
                System.out.println("🏆 " + countries.get(i).getName()
                + " Wins Economic Empires!");
                return true;
            }
        }

        return false;
    }
}
