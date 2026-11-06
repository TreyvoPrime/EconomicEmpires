import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.InputMismatchException;
public class Main {

    public static void main(String[] args) {
        int currentTerm = 0;
        boolean isRunning;
        String startDecision;
        boolean gameStartPhase = true;
        Scanner input = new Scanner(System.in);
        ArrayList<Countries> countries = new ArrayList<>();
        ArrayList<Events> events = new ArrayList<>();
        //add countries to the countries ArrayList
        countries.add(new Countries("USA", 33000, 25000.0, "North America"));
        System.out.println("Welcome to Economic Empires");
        while (gameStartPhase) {
            System.out.println("Start the game Y/N:");
            startDecision = input.nextLine().toUpperCase().trim();
            if (startDecision.equals("Y")) {
                System.out.println("Starting game");
                //exit the while loop once the game condition is started
                gameStartPhase = false;

            } else if (startDecision.equals("N")) {
                System.out.println("Game will not be starting");
            } else {
                System.out.println("Invalid input, try again");
            }
        }
        System.out.println("Now it is time to choose your country, please select a country");
        //returns the number of countries currently stored in the ArrayList
        for (int i=0; i < countries.size(); i++) {
            //get the index of the country inside the countries ArrayList and then retrieve the name of the index of the                current country
            System.out.println(i + ": " + countries.get(i).getCountriesName());
        }
        int choice = input.nextInt();
        //get the country classs, and assign the player chosen country as the object to be used.
        Countries country = countries.get(choice);
        boolean countriesSelection = true;
        boolean countyBeenSelected = false;
        while (countriesSelection) {
            try {
                System.out.println("Selected country: " + countries.get(choice).getCountriesName());
                //exit the while loop once the country has been verified as legit
                countriesSelection = false;
                countyBeenSelected = true;
                //raise IndexoutOfBoundsException if the country is not listed
            } catch (IndexOutOfBoundsException e) {
                System.out.println("That country is not listed below, try again");
                countriesSelection = true;
            }

        }
        if (countyBeenSelected) {
        //country control panel used as the base menu throughout the game
            System.out.println("Welcome Advisor, you're now in control of the economy of " + country.getCountriesName());
            System.out.println("Your starting GDP is " + country.getGDP() + "Annually");
            System.out.println("Your region is " + country.getRegions());
            System.out.println("--Country Control Panel--");
            System.out.println("1. 🔨Buildings");
            System.out.println("2. 🛣️Infrastructure");
            System.out.println("4. ⛵Trade");
            System.out.println("5. 📊Statistics");
            System.out.println("6. 🌍World Stage");
            System.out.println("Choose a option");
            try {
                int decisionChoice  = input.nextInt();
            } catch(InputMismatchException e) {
                System.out.println("Invalid input detected, try again");
                input.nextLine();
            }
            
        }
       

    }
}
