/**
 I have only used resources indicated that are allowable.
The work submitted is my/our, and only my/our work.
Signature: Treyvon Pearson
Date: 11/10/26
*/
/**
 Programmer: Treyvon Pearson
 Program's Name: Economic Empires
 Program's Purpose: The game Economic Empires
 Date: 11/10/26
 */
/**
* Main class runs and puts together the entire program
*/
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.InputMismatchException;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
public class Main {

    public static void main(String[] args) {
        int currentTerm = 1;
        boolean isRunning;
        String startDecision;
        boolean gameStartPhase = true;
        int maxProductionSpace=0;
        Scanner input = new Scanner(System.in);
        ArrayList<Countries> countries = new ArrayList<>();
        ArrayList<Buildings> buildings = new ArrayList<>();
        ArrayList<Resources> resources = new ArrayList<>();
        ArrayList<Infrastructure> infrastructures = new ArrayList<>();
        ArrayList<Production> productions = new ArrayList<>();
        ArrayList<String> northAmericaOceans = new ArrayList<>();
        ArrayList<String> southAmericaOceans = new ArrayList<>();
        ArrayList<String> europeOceans = new ArrayList<>();
        ArrayList<String> africaOceans = new ArrayList<>();
        ArrayList<String> asiaOceans = new ArrayList<>();
        ArrayList<String> oceaniaOceans = new ArrayList<>();

        System.out.println("Welcome to Economic Empires");

        //add oceans to the regions ArrayList;
        northAmericaOceans.add("Atlantic Ocean");
        northAmericaOceans.add("Pacific Ocean");
        northAmericaOceans.add("Arctic Ocean");
        southAmericaOceans.add("Pacific");
        southAmericaOceans.add("Atlantic");
        southAmericaOceans.add("Southern");
        europeOceans.add("Atlantic Ocean");
        europeOceans.add("Artic Ocean");
        africaOceans.add("Atlantic Ocean");
        africaOceans.add("Indian Ocean");
        africaOceans.add("Southern Ocean");
        asiaOceans.add("Pacific Ocean");
        asiaOceans.add("Indian Ocean");
        asiaOceans.add("Artic Ocean");
        oceaniaOceans.add("Southern Ocean");
        oceaniaOceans.add("Pacific Ocean");
        oceaniaOceans.add("Indian Ocean");
        //add regions
        Regions northAmerica = new Regions("North America", northAmericaOceans);
        Regions southAmerica = new Regions("South America", southAmericaOceans);
        Regions europe = new Regions("Europe", europeOceans);
        Regions asia = new Regions("Asia", asiaOceans);
        Regions africa = new Regions("Africa", africaOceans);
        Regions oceania = new Regions("Oceania", oceaniaOceans);
        //add countries to the countries ArrayList:

        countries.add(new Countries("Canada", 17000, 0.0, 25000.0, northAmerica, 1.02));
        countries.add(new Countries("USA", 33000, 0.0, 25000.0, northAmerica, 1.03));
        countries.add(new Countries("Mexico", 26000, 0.0, 25000.0, northAmerica, 1.04));
        countries.add(new Countries("Cuba", 14000, 0.0, 22000.0, northAmerica, 1.01));
        countries.add(new Countries("Brazil", 22000, 0.0, 25000.0, southAmerica, 1.03));
        countries.add(new Countries("Chile", 14000, 0.0, 25000.0, southAmerica, 1.03));
        countries.add(new Countries("Argentina", 17000, 0.0, 24000.0, southAmerica, 1.02));
        countries.add(new Countries("Colombia", 16000, 0.0, 23000.0, southAmerica, 1.03));
        countries.add(new Countries("Germany", 18000, 0.0, 26000.0, europe, 1.02));
        countries.add(new Countries("France", 17000, 0.0, 25000.0, europe, 1.03));
        countries.add(new Countries("United Kingdom", 17000, 0.0, 25000.0, europe, 1.02));
        countries.add(new Countries("Italy", 16000, 0.0, 24000.0, europe, 1.02));
        countries.add(new Countries("China", 34000, 0.0, 25000.0, asia, 1.03));
        countries.add(new Countries("India", 35000, 0.0, 25000.0, asia, 1.04));
        countries.add(new Countries("Japan", 20000, 0.0, 26000.0, asia, 1.02));
        countries.add(new Countries("South Korea", 16000, 0.0, 24000.0, asia, 1.02));
        countries.add(new Countries("Nigeria", 25000, 0.0, 23000.0, africa, 1.04));
        countries.add(new Countries("South Africa", 17000, 0.0, 24000.0, africa, 1.03));
        countries.add(new Countries("Egypt", 19000, 0.0, 24000.0, africa, 1.03));
        countries.add(new Countries("Australia", 18000, 0.0, 25000.0, oceania, 1.02));
        countries.add(new Countries("New Zealand", 13000, 0.0, 23000.0, oceania, 1.02));

        //add Buildings to the buildings ArrayList:
        buildings.add(new Buildings("Farm", 3000, "famine", "Farms produce crops and maximum supported population + a additional population growth benefit."));
        Buildings farm = buildings.get(0);
        //add production buildings to the productions ArrayList;
        productions.add(new Production("Factory", 6000, "explosion", "Factories produce resources that fuel your economy", 0));
        Production factory = productions.get(0);
        //add Resources to the resources ArrayList:
        resources.add(new Resources("Wood", 150.0, 1000.0, 0));
        resources.add(new Resources("Textiles", 200.0, 1500.0, 0));
        resources.add(new Resources("Stone", 250.0, 2000.0, 0));
        resources.add(new Resources("Coal", 350.0, 3000.0, 0));
        resources.add(new Resources("Iron", 450.0, 4000.0, 0));
        resources.add(new Resources("Steel", 650.0, 6000.0, 0));
        resources.add(new Resources("Oil", 800.0, 8000.0, 0));
        resources.add(new Resources("Electronics", 1100.0, 12000.0, 0));
        Resources wood = resources.get(0);
        Resources textiles = resources.get(1);
        Resources stone = resources.get(2);
        Resources coal = resources.get(3);
        Resources iron = resources.get(4);
        Resources steel = resources.get(5);
        Resources oil = resources.get(6);
        Resources electronics = resources.get(7);
        //country production nested ArrayList, found from StackOverflow. creates a sepearated list of used resources from each country.
        ArrayList<ArrayList<Resources>> countryProduction = new ArrayList<>();

        for (int i = 0; i < countries.size(); i++) {
            countryProduction.add(new ArrayList<Resources>());
        }

        //add infrastructure to infrastructures ArrayList
        infrastructures.add(new Infrastructure("Road", 3000.0, 1.0));
        infrastructures.add(new Infrastructure("Port", 20000.0, 1.0));
        Infrastructure road = infrastructures.get(0);
        Infrastructure port = infrastructures.get(1);
        //decision to start the game.
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
            System.out.println(i + ": " + countries.get(i).getCountriesName() + " - " + countries.get(i).getRegion().getName());
        }

        int choice = -1;
        Countries country = null;
        //error checking, to make sure user inputs a number or is in index range when selecting a country
        while (country == null) {
            try {
                System.out.println("Select your country:");
                choice = input.nextInt();
                country = countries.get(choice);

            } catch (IndexOutOfBoundsException e) {
                System.out.println("Invalid country index! Try again.");

            } catch (InputMismatchException e) {
                System.out.println("Please enter a number!");
                input.nextLine();
            }
        }

        //get the country classs, and assign the player chosen country as the object to be used.
        countryProduction.set(choice, resources);
        boolean countriesSelection = true;
        boolean countyBeenSelected = false;
        boolean gameRunning = true;
        //Arraylist declared to get the oceans that border a country
        ArrayList<String> oceans = country.getRegion().getOceans();
        //Boolean list to mark true/false if a port is built  on a specific ocean's index
        ArrayList<Boolean> oceanBoolList = new ArrayList<>();
        //set everything in the Arraylist to false
        for (int i = 0; i < oceans.size(); i++) {
            oceanBoolList.add(false);
        }
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
        int farmsBuilt=1;
        int factoriesBuilt=0;
        int roadsBuilt = 0;
        if (countyBeenSelected) {
            System.out.println("Welcome Advisor, you're now in control of the economy of " + country.getCountriesName());
            double tradeEfficiency = 1.0;

            while (gameRunning) {
                //country control panel used as the base menu throughout the game
                int totalBuildings = 0;
                System.out.println("💵Annual GDP: " + country.getGDP()); //total revenue per turn the player country generates
                System.out.println("🪙Treasury: " + country.getTreasury()); //treasury(total money) the country has
                System.out.println("🥸" + country.getName() + " Population: " + country.getPopulation()); //population of the player  country
                System.out.println("📈Pop Growth Rate: " + country.getPopGrowthRate()); //growth rate of the player country
                System.out.println("🌐Region: " + country.getRegion().getName()); //region name of the player country
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
                            System.out.println(country.getName() + " currently has " + factoriesBuilt + " factories and " + country.getFarmsBuilt() + " farms");
                            System.out.println("Current Treasury: " + country.getTreasury());
                            System.out.println("--Managing Buildings--");
                            System.out.println("0. Back to the country control panel");
                            System.out.println("1. 🌽 Farm - 3000");
                            System.out.println("2. 🏭Factory - 6000");
                            System.out.println("Choose a option.");
                            int buildingChoice = input.nextInt();

                            if (buildingChoice==0) {
                                System.out.println("Exited building management");
                                isBuilding=false;
                                //building farms
                            } else if (buildingChoice==1) {

                                System.out.print("🌽How many farms would you like to build:");
                                int farmsBuilding = input.nextInt();
                                //loop through to get build farms, and cap at the maximum the player can purchase
                                for (int a= 0; a < farmsBuilding; a++) {
                                    if (country.getTreasury() >= farm.getCost()) {
                                        country.setTreasury(country.getTreasury() - farm.getCost());

                                        country.setFarmsBuilt(country.getFarmsBuilt() + 1);
                                        country.setPopGrowthRate(country.getPopGrowthRate() + 0.01);
                                        totalBuildings++;
                                        System.out.println("Farm built:" + country.getFarmsBuilt());
                                    } else {
                                        System.out.println("Not enough money in the treasury to build another farm!");
                                        break;
                                    }
                                }
                                //building farms
                            } else if (buildingChoice==2) {

                                System.out.println("🏭How many factories would you like to build:");
                                int factoriesBuilding = input.nextInt();
                                //loop through to get build factories, and cap at the maximum the player can purchase

                                for (int f= 0; f < factoriesBuilding; f++) {
                                    if (country.getTreasury() >= factory.getCost()) {
                                        country.setTreasury(country.getTreasury() - factory.getCost());

                                        factoriesBuilt++;
                                        totalBuildings++;
                                        maxProductionSpace++;
                                        factory.setProductionSlots(maxProductionSpace);
                                        System.out.println("🏭Factories built: " + factoriesBuilt);
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
                            System.out.println("Roads built " + roadsBuilt);
                            System.out.println(country.getCountriesName() + " Trade efficientcy:" + tradeEfficiency);
                            System.out.println(country.getCountriesName() + "--Martime trade access--");
                            for (int e = 0; e < oceans.size(); e++) {
                                System.out.println(e + " " + oceans.get(e));
                            }

                            System.out.println("Your region is " + country.getRegion().getName());

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
                                //loop to build the amount of roads requested and makes sure the player has enough money to build the requestesd amount of roads.
                                for (int r= 0; r < roadsBuilding; r++) {
                                    if (country.getTreasury() >= road.getCost()) {
                                        country.setTreasury(country.getTreasury() - road.getCost());

                                        roadsBuilt++;
                                        tradeEfficiency += 0.01;
                                    }
                                    else {
                                        System.out.println("Not enough money in the treasury to build another road!");
                                        break;
                                    }
                                }
                                System.out.println("🛣️built +:" + roadsBuilt + " roads");
                                //ports, ports are built to trade with other countries in other regions.
                            } else if (infrastructureChoice==2) {
                                System.out.println("--Port Investments--");
                                System.out.println("Building a port, adjacent to an ocean your country borders, gives you access to international markets that borders the specific ocean.");
                                System.out.println("Port building cost - 🪙20000");
                                System.out.println("The oceans" + country.getName() + "borders");
                                for (int i = 0; i < oceans.size(); i++) {
                                    System.out.println(i + " ⚓ " + oceans.get(i));
                                }
                                System.out.print("What ocean to build port on:");
                                //the index of the oceanDecided
                                int oceanDecided = input.nextInt();
                                if (oceanDecided >= 0 && oceanDecided < oceans.size()) {
                                    //check to see if player's country has enough treasury.
                                    if (country.getTreasury() >= port.getCost()) {
                                        //make sure the ocean decided is in
                                        country.setTreasury(country.getTreasury() - port.getCost());
                                        if (oceanDecided >= 0 && oceanDecided < oceanBoolList.size()) {
                                            //set the specific index of the ocean decided, boolean List to true
                                            oceanBoolList.set(oceanDecided, true);
                                        } else {
                                            System.out.println("Invalid port index");
                                        }
                                        System.out.println("⚓Successfully built port on⚓ " + oceans.get(oceanDecided));

                                    } else {
                                        System.out.println("❌Not enough money in the treasury");
                                    }
                                } else {
                                    System.out.println("Invalid Index selected, try again");
                                }
                            } else {
                                System.out.println("Invalid choice, try again");
                            }

                        }

                    } else if (decisionChoice==3) {

                        System.out.println("🛢️--Managing Production--🛢️");
                        System.out.println("Max factory production " + maxProductionSpace);
                        //display treasury of country
                        System.out.println(country.getCountriesName() + " Treasury: " + country.getTreasury());
                        //display all resources cost, name, revenue.
                        for (int r=0; r < resources.size(); r++) {
                            System.out.println(r + " " + resources.get(r).getName() + " cost: " + resources.get(r).getCost() + " base annual revenue: " + resources.get(r).getRevenue() + " 💵 ");
                        }
                        System.out.println("Select a resource to manage production, select 8 to edit the production of a resource");
                        int resourceDecided = input.nextInt();
                        int productionDesired;
                        if (resourceDecided == 0) {
                            System.out.println("Allocate how much " + resources.get(0).getName() + " to production");
                            productionDesired = input.nextInt();

                            if (productionDesired > 0 && productionDesired <= maxProductionSpace && country.getTreasury() >= wood.getCost()) {
                                //subract from the maximum production space. The production amount desired
                                maxProductionSpace -= productionDesired;
                                //print out the allocated amount of the resource
                                System.out.println("Allocated: " + productionDesired + " production to " + resources.get(0).getName());

                                System.out.println("Remaining factory spaces: " + maxProductionSpace);
                                wood.setProductionDesired(wood.getProductionDesired() + productionDesired);
                                //subtract the cost of the resource from the treasury
                                country.setTreasury(country.getTreasury() - wood.getCost());
                            } else {
                                System.out.println("Not enough factory spaces, not enough money in treasury, or invalid amount.");

                            }
                        } else if (resourceDecided== 1) {
                            System.out.println("Allocate how much " + resources.get(1).getName() + " to production");
                            productionDesired = input.nextInt();

                            if (productionDesired > 0 && productionDesired <= maxProductionSpace && country.getTreasury() >= textiles.getCost()) {
                                //subract from the maximum production space. The production amount desired
                                maxProductionSpace -= productionDesired;
                                //print out the allocated amount of the resource
                                System.out.println("Allocated: " + productionDesired + " production to " + resources.get(1).getName());

                                System.out.println("Remaining factory spaces: " + maxProductionSpace);
                                textiles.setProductionDesired(textiles.getProductionDesired() + productionDesired);
                                country.setTreasury(country.getTreasury() - textiles.getCost());

                            } else {
                                System.out.println("Not enough factory spaces, not enough money in treasury, or invalid amount.");

                            }
                        } else if (resourceDecided==2) {
                            System.out.println("Allocate how much " + resources.get(2).getName() + " to production");
                            productionDesired = input.nextInt();

                            if (productionDesired > 0 && productionDesired <= maxProductionSpace && country.getTreasury() >= stone.getCost()) {
                                //subract from the maximum production space. The production amount desired
                                maxProductionSpace -= productionDesired;
                                //print out the allocated amount of the resource
                                System.out.println("Allocated: " + productionDesired + " production to " + resources.get(2).getName());

                                System.out.println("Remaining factory spaces: " + maxProductionSpace);
                                stone.setProductionDesired(stone.getProductionDesired() + productionDesired);
                                country.setTreasury(country.getTreasury() - stone.getCost());
                            } else {
                                System.out.println("Not enough factory spaces, not enough money in treasury, or invalid amount.");

                            }
                        } else if (resourceDecided==3) {
                            System.out.println("Allocate how much " + resources.get(3).getName() + " to production");
                            productionDesired = input.nextInt();

                            if (productionDesired > 0 && productionDesired <= maxProductionSpace && country.getTreasury() >= coal.getCost()) {
                                //subract from the maximum production space. The production amount desired
                                maxProductionSpace -= productionDesired;

                                //print out the allocated amount of the resource
                                System.out.println("Allocated: " + productionDesired + " production to " + resources.get(3).getName());

                                System.out.println("Remaining factory spaces: " + maxProductionSpace);
                                coal.setProductionDesired(coal.getProductionDesired() + productionDesired);
                                country.setTreasury(country.getTreasury() - coal.getCost());

                            } else {
                                System.out.println("Not enough factory spaces, not enough money in treasury, or invalid amount.");

                            }
                        } else if (resourceDecided==4) {
                            System.out.println("Allocate how much " + resources.get(4).getName() + " to production");
                            productionDesired = input.nextInt();

                            if (productionDesired > 0 && productionDesired <= maxProductionSpace && country.getTreasury() >= iron.getCost()) {
                                //subract from the maximum production space. The production amount desired
                                maxProductionSpace -= productionDesired;

                                //print out the allocated amount of the resource
                                System.out.println("Allocated: " + productionDesired + " production to " + resources.get(4).getName());

                                System.out.println("Remaining factory spaces: " + maxProductionSpace);
                                iron.setProductionDesired(iron.getProductionDesired() + productionDesired);
                                country.setTreasury(country.getTreasury() - iron.getCost());

                            } else {
                                System.out.println("Not enough factory spaces, not enough money in treasury, or invalid amount.");

                            }
                        } else if (resourceDecided==5) {
                            System.out.println("Allocate how much " + resources.get(5).getName() + " to production");
                            productionDesired = input.nextInt();

                            if (productionDesired > 0 && productionDesired <= maxProductionSpace && country.getTreasury() >= steel.getCost()) {
                                //subract from the maximum production space. The production amount desired
                                maxProductionSpace -= productionDesired;

                                //print out the allocated amount of the resource
                                System.out.println("Allocated: " + productionDesired + " production to " + resources.get(5).getName());

                                System.out.println("Remaining factory spaces: " + maxProductionSpace);
                                steel.setProductionDesired(steel.getProductionDesired() + productionDesired);
                                country.setTreasury(country.getTreasury() - steel.getCost());

                            } else {
                                System.out.println("Not enough factory spaces, not enough money in treasury, or invalid amount.");

                            }
                        } else if (resourceDecided==6) {
                            System.out.println("Allocate how much " + resources.get(6).getName() + " to production");
                            productionDesired = input.nextInt();

                            if (productionDesired > 0 && productionDesired <= maxProductionSpace && country.getTreasury() >= oil.getCost() ) {
                                //subract from the maximum production space. The production amount desired
                                maxProductionSpace -= productionDesired;

                                //print out the allocated amount of the resource
                                System.out.println("Allocated: " + productionDesired + " production to " + resources.get(6).getName());

                                System.out.println("Remaining factory spaces: " + maxProductionSpace);
                                oil.setProductionDesired(oil.getProductionDesired() + productionDesired);
                                country.setTreasury(country.getTreasury() - oil.getCost());

                            } else {
                                System.out.println("Not enough factory spaces, not enough money in treasury, or invalid amount.");

                            }
                        } else if (resourceDecided==7) {
                            System.out.println("Allocate how much " + resources.get(7).getName() + " to production");
                            productionDesired = input.nextInt();

                            if (productionDesired > 0 && productionDesired <= maxProductionSpace && country.getTreasury() >= electronics.getCost()) {
                                //subract from the maximum production space. The production amount desired
                                maxProductionSpace -= productionDesired;

                                //print out the allocated amount of the resource
                                System.out.println("Allocated: " + productionDesired + " production to " + resources.get(7).getName());

                                System.out.println("Remaining factory spaces: " + maxProductionSpace);
                                electronics.setProductionDesired(electronics.getProductionDesired() + productionDesired);
                                country.setTreasury(country.getTreasury() - electronics.getCost());

                            } else {
                                System.out.println("Not enough factory spaces or invalid amount.");

                            }
                        }
                        //chatGPT vibecoded, specific resource production editing
                        else if (resourceDecided == 8) {
                            System.out.println("Which resource would you like to edit production?");

                            for (int r = 0; r < resources.size(); r++) {
                                System.out.println(r + " " + resources.get(r).getName()
                                + " | Current Production: "
                                + resources.get(r).getProductionDesired());
                            }

                            int resourceChoice = input.nextInt();

                            if (resourceChoice >= 0 && resourceChoice < resources.size()) {

                                Resources selectedResource = resources.get(resourceChoice);

                                int currentProduction = selectedResource.getProductionDesired();

                                System.out.println("Current production: " + currentProduction);
                                System.out.println("Enter the NEW production amount:");

                                int newProduction = input.nextInt();

                                int difference = newProduction - currentProduction;

                                if (newProduction >= 0 && difference <= maxProductionSpace) {

                                    maxProductionSpace -= difference;

                                    selectedResource.setProductionDesired(newProduction);

                                    System.out.println("Production updated!");
                                    System.out.println("New production: "
                                    + selectedResource.getProductionDesired());
                                    System.out.println("Remaining factory spaces: "
                                    + maxProductionSpace);

                                } else {
                                    System.out.println("Invalid production amount or not enough factory spaces!");
                                }

                            } else {
                                System.out.println("Invalid resource selected!");
                            }
                        }
                        //end of vibe.
                        else {
                            System.out.println("Invalid resource, try again");
                        }
                    }//vibecoded, Trading class method calling
                    else if (decisionChoice == 4) {

                        Trading.trade(
                        input, 
                        countries, 
                        choice, 
                        resources, 
                        oceanBoolList, 
                        tradeEfficiency, 
                        countryProduction
                    );

                    } else if (decisionChoice==5) {
                        System.out.println("Statistics");
                        System.out.println("👥Population: " + country.getPopulation());
                        System.out.println("💵Annual GDP: " + country.getGDP());
                        System.out.println("🪙treasury: " + country.getTreasury());
                        System.out.println("🌍Region: " + country.getRegion().getName());
                        System.out.println("🌽Farms Built:" + country.getFarmsBuilt());
                        System.out.println("🏭Factories Built:" + factoriesBuilt);
                        System.out.println("🧑Population Growth Rate: " + country.getPopGrowthRate());
                        System.out.println("Would you like to print your statistics to a textfile(0) or exit statistics(1)?");
                        int statsChoice = input.nextInt();
                        if (statsChoice==0) {
                            System.out.println("Printing Statistics");
                            File statFile = new File("stats.txt");
                            //write to the textfile called statfile
                            try (PrintWriter writer = new PrintWriter(statFile)) {
                                writer.println(" --Country Stats-- ");
                                writer.println("👥 Population: " + country.getPopulation());
                                writer.println("💵 GDP: " + country.getGDP());
                                writer.println("🪙 Treasury: " + country.getTreasury());
                                writer.println("🌍 Region: " + country.getRegion().getName());
                                writer.println("🌽 Farms Built: " + country.getFarmsBuilt());
                                writer.println("🏭 Factories Built: " + factoriesBuilt);
                                writer.println("🧑 Population Growth Rate: " + country.getPopGrowthRate());
                                System.out.println("Text File printed success");
                            } catch (FileNotFoundException e) {
                                System.out.println("Error, when writing the statistics:");
                            }

                        } else if (statsChoice==1) {
                            System.out.println("Exited, stat viewing");
                        } else {
                            System.out.println("Invalid Choice selected, try again");
                        }
                    } else if (decisionChoice==6) {
                        System.out.println("World Stage");
                        double worldGDP =0;
                        for (int i=0; i < countries.size(); i++) {
                            worldGDP = worldGDP + countries.get(i).getGDP();
                        }
                        ArrayList<Countries> countryRankings = new ArrayList<>(countries);
                        //vibecoded, this line of code to rank all the countries in the world
                        countryRankings.sort((a, b) -> Double.compare(b.getGDP(), a.getGDP()));
                        //end of vibecode
                        System.out.println("Worlds Total GDP: " + worldGDP);
                        for (int i=0; i < countryRankings.size(); i++) {
                            Countries rankedCountry = countryRankings.get(i);
                            double percentage = 0;
                            if (worldGDP > 0) {
                                percentage = (rankedCountry.getGDP() / worldGDP) * 100;
                            }
                            percentage = Math.round(percentage * 100.0) / 100.0;
                            //print out attributes of all country GDP, and the percentage they make up of world GDP
                            System.out.println(i + 1 + "- " + rankedCountry.getName() + " 💵GDP: " + rankedCountry.getGDP() + " controls " + percentage + " 🌍of the worlds GDP ");

                        }
                    } else if (decisionChoice == 7) {
                        System.out.println("❗Next Term");
                        currentTerm++;
                        country.setPopulation(country.applyPopGrowth(country.getPopulation(), country.getFarmsBuilt(), country.getPopGrowthRate()));
                        double totalRevenue = 0;
                        //vibecoded ChatGPT, loop through to print out all the revenue from each resource
                        for (int r = 0; r < resources.size(); r++) {
                            double resourceRevenue = resources.get(r).getRevenue()
                            * resources.get(r).getProductionDesired();

                            totalRevenue += resourceRevenue;

                            System.out.println(resources.get(r).getName()
                            + " generated $" + resourceRevenue);
                        }
                        //tax revenue from population
                        double taxRevenue = country.getPopulation() / 100.0;
                        //add the totalRevenue made from resources to the players treasury.
                        country.setTreasury(country.getTreasury() + totalRevenue + taxRevenue);
                        //set the total revenue to the GDP
                        country.setGDP(totalRevenue + taxRevenue);
                        System.out.println("Total revenue from resources: $" + totalRevenue);
                        //run the AI turn.
                        AI.aiTurn(countries, resources, countryProduction, choice);
                        //run the trading
                        Trading.processTurn(countries, choice, resources, countryProduction, tradeEfficiency);

                        if (currentTerm >= 10 && Victory.check(countries, countryProduction)) {
                            gameRunning = false;
                        }
                        //end of vibecode.
                    } else {
                        System.out.println("Invalid Choice, please try again");
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Invalid input detected, try again");
                    input.nextLine();
                }
            }
        }
    }
}
