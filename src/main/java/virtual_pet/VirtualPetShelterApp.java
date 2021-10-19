package virtual_pet;

import java.util.ArrayList;
import java.util.Scanner;

public class VirtualPetShelterApp {

    static VirtualPetShelter myShelter = new VirtualPetShelter();
    static Scanner inputScanner = new Scanner(System.in);

    public static void main(String[] args) {
        game();
    }

    public static void game() {

        int score = 0;
        int selection = 0;
        boolean isPetAlive = true;

        myShelter.shelterPic();

        System.out.println("You've accepted a job at your local pet shelter, \"No Bears, Slugs, and More\"! \n" +
        "You are responsible for taking care of the pets, which definitely does not include any bears! \n" +
        "It DOES definitely include both robotic and organic pets, who will require your help to meet their needs.");

        System.out.println("\nPress enter to continue.");

        String enter = inputScanner.nextLine();

        System.out.println("\nHere is the status of the pets in your shelter:\n");
        printStatusOfPets();

        System.out.println("This bar graph will display the needs of your pets." +
        " As time goes on, their needs will increase.\nIt's your job to determine which action"
        + " to take to best care for the pets.");

        myShelter.bearPic();

        System.out.println("\nPress enter to continue.");

        String enter2 = inputScanner.nextLine();

        System.out.println("Each turn you will be shown this readout.");
        System.out.println("Please read what each action will do if this is your first time playing!\n");
        System.out.println("Type \"1\" to play with a pet. (This will decrease the sadness of a pet of your choice!)");
        System.out.println("Type \"2\" to feed/refuel all pets. (This will decrease the \"hunger\" of all of the pets.)");
        System.out.println("Type \"3\" to water/oil all pets. (This will decrease the \"thirst\" of all of the pets.)");
        System.out.println("Type \"4\" to clean the pens/perform maintenance. (This will clean up after/repair the pets.)");
        System.out.println("Type \"5\" to walk the dogs. (This will decreasing sadness to 0 but raise hunger/thirst.)");
        System.out.println("Type \"6\" to adopt a pet. (This means someone will adopt a pet from the shelter!)");
        System.out.println("Type \"7\" to admit a pet. (This means you will take in a new pet to the shelter!)");
        System.out.println("Type \"8\" to quit. (This will exit the game.)\n");

        System.out.println("Remember that the more pets you have in the shelter, the faster your score will go up!");

        myShelter.bearPic2();

        System.out.println("\nPress enter to begin the game!");

        String enter3 = inputScanner.nextLine();

        while (selection != 8 && isPetAlive) {

            System.out.println("\nHere is the status of the pets in your shelter:\n");
            printStatusOfPets();

            System.out.println("Enter selection\n");
            System.out.println("Type \"1\" to play with a pet.");
            System.out.println("Type \"2\" to feed/refuel all pets.");
            System.out.println("Type \"3\" to water/oil all pets.");
            System.out.println("Type \"4\" to clean the pens/perform maintenance.");
            System.out.println("Type \"5\" to walk the dogs.");
            System.out.println("Type \"6\" to adopt a pet.");
            System.out.println("Type \"7\" to admit a pet.");
            System.out.println("Type \"8\" to quit.\n");
            selection = inputScanner.nextInt();
            inputScanner.nextLine();

            switch (selection) {
                case 1:
                    VirtualPet chosenPet1 = selectAPet();
                    myShelter.playsWithOnePet(chosenPet1);
                    break;
                case 2:
                    myShelter.feedsAllThePets();
                    break;
                case 3:
                    myShelter.watersAllThePets();
                    break;
                case 4:
                    myShelter.maintainAllThePets();
                    break;
                case 5:
                    myShelter.walkAllTheDogs();
                    break;
                case 6:
                    VirtualPet chosenPet4 = selectAPet();
                    myShelter.removePetFromShelter(chosenPet4);
                    break;
                case 7:
                    getNameDescription();
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Invalid Selection try again:");
            }
            myShelter.tick();
            isPetAlive = myShelter.aliveCheck();
            if (!myShelter.aliveCheck()){
                System.out.println(myShelter.report());
                myShelter.empty();
            }
            score = score + myShelter.getSize();
        }

        System.out.println("\nYou've ended the game with a final score of " + score + ".");
    }

    public static VirtualPet selectAPet() {
        System.out.print("\nThe current pets in the shelter are:\n");
        for (int i = 0; i < myShelter.virtualPets.size(); i++) {
            System.out.println(myShelter.virtualPets.get(i).getName() + ", " + myShelter.virtualPets.get(i).getDescription());
        }
        System.out.println("");
        System.out.println("Please type the name of the pet you would like to select.\n");

        String petName = inputScanner.nextLine();
        return myShelter.getPetByName(petName);
    }

    public static void printStatusOfPets() {
        System.out.println("|Type        |Name        |Hunger/Gas     |Thirst/Oil     |Sadness        |Clean/Repair   ");
        System.out.println("|------------|------------|---------------|---------------|---------------|---------------");
        ArrayList<VirtualPet> petList = myShelter.returnsCollectionOfPets();
        for (VirtualPet currentPet : petList) {
            if (currentPet instanceof OrganicPet) {
                System.out.println(getAnimalString(currentPet) + ((OrganicPet) currentPet).getOrganicString());
            }
            if (currentPet instanceof RoboticPet) {
                System.out.println(getAnimalString(currentPet) + ((RoboticPet) currentPet).getRoboticString());
            }
        }
        System.out.println();
    }

    public static void getNameDescription() {
        System.out.println("\nA stray pet has been found near the shelter and admitted for care. What type of pet is it?" +
                "\nType 1 for Organic Slug\nType 2 for Robotic Slug\nType 3 for Organic Cat\nType 4 for Robotic Cat\n" +
                "Type 5 for Organic Dog\nType 6 for Robotic Dog\n\n");
        int petType = inputScanner.nextInt();
        inputScanner.nextLine();
        System.out.println("What would you like to name it?");
        String newName = inputScanner.nextLine();
        System.out.println("How would you describe this pet?");
        String newDescription = inputScanner.nextLine();
        myShelter.addPetToShelter(petType, newName, newDescription);
    }

    public static String getAnimalString(VirtualPet pet) {
        if (pet instanceof OrganicDog) {
            return "|Organic Dog ";
        }
        if (pet instanceof OrganicSlug){
            return "|Organic Slug";
        }
        if (pet instanceof OrganicCat) {
            return "|Organic Cat ";
        }
        if (pet instanceof RoboticDog) {
            return "|Robotic Dog ";
        }
        if (pet instanceof RoboticCat) {
            return "|Robotic Cat ";
        }
        else {
            return "|Robotic Slug";
        }
    }
}
