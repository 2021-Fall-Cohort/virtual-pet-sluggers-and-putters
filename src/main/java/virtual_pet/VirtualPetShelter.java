package virtual_pet;

import java.util.ArrayList;

public class VirtualPetShelter {

    ArrayList<VirtualPet> virtualPets;

    //this method cleanly creates an array list of pets
    public VirtualPetShelter(){
        virtualPets = new ArrayList<>();
        virtualPets.add(new Slug("Toofth", "a slug who has a portly figure with a long, golden beard."));
        virtualPets.add(new Slug("Rutherford", "a slug who breathes fire and has a sharp tongue."));
        virtualPets.add(new Slug("Lil Baby", "a slug who has quite the appetite for something."));
        virtualPets.add(new Slug("Dave", "a slug who wants to rule the world some day."));
        virtualPets.add(new Slug("Queen A", "a slug who brushes her teeth twice a day."));
    }

    //cleanly retrieves names of all the slugs in the shelter
    public ArrayList<String> retrievePetNames(){
        ArrayList<String> names = new ArrayList<>();
        for (VirtualPet pet: virtualPets){
            names.add(pet.getName());
        }
        return names;
    }


    //method that returns a collection of all pets in the shelter in a clean manner
    public ArrayList<VirtualPet> returnsCollectionOfPets(){
        return virtualPets;
    }

    //method that returns a specific virtual pet given its name
    public VirtualPet getPetByName(String petName){
        for (int i = 0; i < virtualPets.size(); i++){
            if (virtualPets.get(i).getName().equalsIgnoreCase(petName)) {
                return virtualPets.get(i);
            }
        }
        return null;
    }

    //method that allows intake of a pet to the shelter
    public void addPetToShelter(String name, String description){
        virtualPets.add(new Slug(name, description));
    }


    //method that allows adoption that removes pet
    public void removePetFromShelter(VirtualPet chosenPet){
        if (chosenPet instanceof Slug) {
            ((Slug) chosenPet).adopt();
        }
        for (int i = 0; i < virtualPets.size(); i++){
            if(virtualPets.get(i) == chosenPet){
                virtualPets.remove(i);
            }
        }
    }

    //method to feed all pets
    public void feedsAllThePets(){
        for (VirtualPet currentPet : virtualPets) {
            if (currentPet instanceof Slug) {
                ((Slug) currentPet).feed();
            }
        }
    }

    //method to water all pets
    public void watersAllThePets(){
        for (VirtualPet currentPet : virtualPets) {
            if (currentPet instanceof Slug) {
                ((Slug) currentPet).water();
            }
        }

    }

    //method that plays with an individual pet
    public void playsWithOnePet(VirtualPet chosenPet) {
        if (chosenPet instanceof Slug) {
            ((Slug) chosenPet).play();
        }

    }

    //tick method that calls a tick method for each of the pets in the shelter
    public void tick(){
        for (VirtualPet currentPet : virtualPets) {
            if (currentPet instanceof Slug) {
                ((Slug) currentPet).tickSlug();
            }
        }
    }

    //gets size of arraylist
    public int getSize(){
        return virtualPets.size();
    }

    public VirtualPet getPet(int num){
        return virtualPets.get(num);
    }

}
