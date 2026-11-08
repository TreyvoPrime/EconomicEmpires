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
        ArrayList<Buildings> buildings = new ArrayList<>();
        ArrayList<Resources> resources = new ArrayList<>();
        ArrayList<Infrastructure> infrastructures = new ArrayList<>();

        //add countries to the countries ArrayList:
        countries.add(new Countries("USA", 33000, 25000.0, 25000.0, "North America"));
        System.out.println("Welcome to Economic Empires");
        //add Buildings to the buildings ArrayList:
        buildings.add(new Buildings("Farm", 3000, "famine", "Farms produce crops and maximum supported population + a additional population growth benefit."));
        Buildings farm = buildings.get(0);
        //add Resources to the resources ArrayList:
        resources.add(new Resources("Wood", 150.0, 1000.0));
        resources.add(new Resources("Food", 200.0, 1500.0));
        resources.add(new Resources("Stone", 250.0, 2000.0));
        resources.add(new Resources("Coal", 350.0, 3000.0));
        resources.add(new Resources("Iron", 450.0, 4000.0));
        resources.add(new Resources("Steel", 650.0, 6000.0));
        resources.add(new Resources("Oil", 800.0, 8000.0));
        resources.add(new Resources("Electronics", 1100.0, 12000.0));
        //add infrastructure to infrastructures ArrayList
        infrastructures.add(new Infrastructure("Road", 2000.0, 1.0));
        infrastructures.add(new Infrastructure("Port", 2000.0, 1.0));
        Infrastructure road = infrastructures.get(0);
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
            //get the index of the country inside the countries ArrayList and then retrieve the name of the index of the current country
            System.out.println(i + ": " + countries.get(i).getCountriesName());
        }
        int choice = input.nextInt();
        //get the country classs, and assign the player chosen country as the object to be used.
        Countries country = countries.get(choice);
        boolean countriesSelection = true;
        boolean countyBeenSelected = false;
        boolean gameRunning = true;

        //country selected error checking and output
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
            while (gameRunning) {
                //country control panel used as the base menu throughout the game
                int totalBuildings = 0;
                double tradeEfficiency = 0.0;
                System.out.println("Welcome Advisor, you're now in control of the economy of " + country.getCountriesName());
                System.out.println("Your starting Annual GDP is " + country.getGDP());
                System.out.println("Your region is " + country.getRegions());

                System.out.println("--Country Control Panel--");
                System.out.println("1. 🔨Buildings");
                System.out.println("2. 🛣️Infrastructure");
                System.out.println("3. 🏭Production");
                System.out.println("4. ⛵Trade");
                System.out.println("5. 📊Statistics");
                System.out.println("6. 🌍World Stage");
                System.out.println("7. 🛞Next Turn");
                System.out.println("Choose a option");
                System.out.println("The current term is term " + currentTerm);
                try {
                    int decisionChoice = input.nextInt();
                    if (decisionChoice==1) {
                        boolean isBuilding = true;
                        while (isBuilding) {
                            //building control panel
                            System.out.println(country.getName() + " currently has " + totalBuildings + " buildings");
                            System.out.println("Current Treasury: " + country.getTreasury());
                            System.out.println("--Managing Buildings--");
                            System.out.println("0. Back to the country control panel");
                            System.out.println("1. 🌽 Farm - 3000");
                            System.out.println("2. 🏭Factory - 6000");
                            System.out.println("Choose a option.");
                            int buildingChoice = input.nextInt();
                            int farmsBuilt = 0;
                            int factoriesBuilt = 0;
                            if (buildingChoice==0) {
                                System.out.println("Exited building management");
                                isBuilding=false;
                                //farms:building
                            } else if (buildingChoice==1) {

                                System.out.print("🌽How many farms would you like to build:");
                                int farmsBuilding = input.nextInt();
                                //loop through to get build farms, and cap at the maximum the player can purchase
                                for (int a= 0; a < farmsBuilding; a++) {
                                    if (country.getTreasury() >= farm.getCost()) {
                                        country.setTreasury(country.getTreasury() - farm.getCost());

                                        farmsBuilt++;
                                        totalBuildings++;
                                        System.out.println("Farm built:" + farmsBuilt);
                                    } else {
                                        System.out.println("Not enough money in the treasury to build another farm!");
                                        break;
                                    }
                                }
                                //factories:building
                            } else if (buildingChoice==2) {

                                System.out.println("🏭How many factories would you like to build:");
                                int factoriesBuilding = input.nextInt();
                                //loop through to get build factories, and cap at the maximum the player can purchase

                                for (int f= 0; f < factoriesBuilding; f++) {
                                    if (country.getTreasury() >= farm.getCost()) {
                                        country.setTreasury(country.getTreasury() - farm.getCost());

                                        factoriesBuilt++;
                                        totalBuildings++;
                                        System.out.println("🏭Factories built:" + farmsBuilt);
                                    } else {
                                        System.out.println("Not enough money in the treasury to build another factory!");
                                        break;
                                    }
                                }
                            } else {
                                System.out.println("Invalid choice, try again");
                            }
                        }

                    } //Infrastructure control
                    else if (decisionChoice==2) {
                        boolean infrastructureManaged = true;
                        //management panel for infrastructure
                        while (infrastructureManaged) {
                            System.out.println(country.getCountriesName() + " Trade efficientcy:" + tradeEfficiency);
                            System.out.println(country.getCountriesName() + "Martime trade access");
                            System.out.println("--Manage Infrastructure--");
                            System.out.println("0. Back to country control panel");
                            System.out.println("1. 🛣️ Road investments");
                            System.out.println("2. 🛳️ port investments");
                            System.out.println("Choose a option.");
                            int infrastructureChoice = input.nextInt();
                            if (infrastructureChoice==0) {
                                System.out.println("Exited infrastructure management");
                                infrastructureManaged=false;
                                //road investments
                            } else if (infrastructureChoice==1) {
                                System.out.println("--Road Investments--");
                                System.out.println("Every road built = +1% trade efficientcy");
                                System.out.println("Road cost - 🪙2000");
                                System.out.println("How many roads would you like to build:");
                                int roadsBuilding = input.nextInt();
                                int roadsBuilt = 0;
                                for (int r= 0; r < roadsBuilding; r++) {
                                    if (country.getTreasury() >= road.getCost()) {
                                        country.setTreasury(country.getTreasury() - road.getCost());

                                        roadsBuilt++;
                                        tradeEfficiency++;
                                        System.out.println("🛣️Roads built:" + roadsBuilt);
                                    } else {
                                        System.out.println("Not enough money in the treasury to build another road!");
                                        break;
                                    }
                                }
                            } else if (infrastructureChoice==2) {
                                System.out.println("--Port Investments--");

                            }

                        }

                    }


                } catch (InputMismatchException e) {
                    System.out.println("Invalid input detected, try again");
                    input.nextLine();
                }
            }
        }
    }
}
