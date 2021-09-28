package virtual_pet;

import java.util.ArrayList;
import java.util.Scanner;

public class VirtualPetShelterApp {

    static VirtualPetShelter myShelter = new VirtualPetShelter();
    static Scanner inputScanner = new Scanner(System.in);

    public static void main(String[] args) {
        game();
    }

    public static void game(){
        String selection = "";

        while (selection != "6") {

            System.out.println("Here is the status of the pets in your shelter:\n");
            printStatusOfPets();

            System.out.println("Enter selection");
            System.out.println("Type \"1\" to play with a pet.");
            System.out.println("Type \"2\" to feed all pets.");
            System.out.println("Type \"3\" to water all pets.");
            System.out.println("Type \"4\" to adopt a pet.");
            System.out.println("Type \"5\" to admit a pet.");
            System.out.println("Type \"6\" to quit.\n");
            selection = inputScanner.nextLine();
            selection = selection.toLowerCase();

            switch (selection) {
                case "1":
                    VirtualPet chosenPet1 = selectAPet();
                    myShelter.playsWithOnePet(chosenPet1);
                    break;
                case "2":
                    myShelter.feedsAllThePets();
                    break;
                case "3":
                    myShelter.watersAllThePets();
                    break;
                case "4":
                    VirtualPet chosenPet4 = selectAPet();
                    myShelter.removePetFromShelter(chosenPet4);
                    break;
                case "5":
                    getNameDescription();
                    break;
                case "6":
                    break;
                default:
                    System.out.println("Invalid Selection try again:");
            }
            myShelter.tick();
        }
    }
    public static VirtualPet selectAPet(){
        System.out.print("The current pets in the shelter are:\n");
        for (int i = 0; i < myShelter.virtualPets.size(); i++){
            System.out.println(myShelter.virtualPets.get(i).getName() + ", " + myShelter.virtualPets.get(i).getDescription());
        }
        System.out.println("");
        System.out.println("Please type the name of the pet you would like to select.\n");

        String petName = inputScanner.nextLine();
        return myShelter.getPetByName(petName);
    }

    public static void printStatusOfPets(){
        System.out.println("|Name        |Hunger  |Thirst  |Sadness |");
        System.out.println("|------------|--------|--------|--------|");
        ArrayList<VirtualPet> petList = myShelter.returnsCollectionOfPets();
        for (VirtualPet currentPet : petList) {
            if (currentPet instanceof Slug) {
                System.out.println(((Slug)currentPet).getPetString());
            }
        }
        System.out.println();
    }
    public static void getNameDescription(){
        System.out.println("A stray slug has been found and admitted to the shelter.\n\nWhat would you like to name it?");
        String newName = inputScanner.nextLine();
        System.out.println("How would you describe this slug?");
        String newDescription = inputScanner.nextLine();
        myShelter.addPetToShelter(newName, newDescription);
    }

}
