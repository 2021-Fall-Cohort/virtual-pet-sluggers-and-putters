package virtual_pet;

import java.util.ArrayList;

public class VirtualPetShelter {

    ArrayList<VirtualPet> virtualPets;

    //this method cleanly creates an array list of pets
    public VirtualPetShelter(){
        virtualPets = new ArrayList<>();
        virtualPets.add(new OrganicSlug("Toofth", "a slug who has a portly figure with a long, golden beard."));
        virtualPets.add(new RoboticSlug("Rutherford", "a robotic slug who breathes fire and has a sharp tongue."));
        virtualPets.add(new OrganicDog("Lil Baby", "a dog who has quite the appetite for something."));
        virtualPets.add(new OrganicCat("Dave", "a cat who wants to rule the world some day."));
        virtualPets.add(new RoboticCat("Queen A", "a robotic cat who brushes her teeth twice a day."));
        virtualPets.add(new RoboticDog("Cinderella", "a robotic dog who has a penchant for rhinestones."));

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
    public void addPetToShelter(int petType,String name, String description){
        switch (petType) {
            case 1:
                virtualPets.add(new OrganicSlug(name, description));
                break;
            case 2:
                virtualPets.add(new RoboticSlug(name, description));
                break;
            case 3:
                virtualPets.add(new OrganicCat(name, description));
                break;
            case 4:
                virtualPets.add(new RoboticCat(name, description));
                break;
            case 5:
                virtualPets.add(new OrganicDog(name, description));
                break;
            case 6:
                virtualPets.add(new RoboticDog(name, description));
                break;
        }
    }


    //method that allows adoption that removes pet
    public void removePetFromShelter(VirtualPet chosenPet){
        for (int i = 0; i < virtualPets.size(); i++){
            if(virtualPets.get(i) == chosenPet){
                virtualPets.remove(i);
            }
        }
    }

    //method to feed all pets
    public void feedsAllThePets(){
        for (VirtualPet currentPet : virtualPets) {
            currentPet.feed();
        }
    }

    //method to water all pets
    public void watersAllThePets(){
        for (VirtualPet currentPet : virtualPets) {
            currentPet.water();
        }
    }

    //method to maintain all the pets
    public void maintainAllThePets(){
        for (VirtualPet currentPet : virtualPets) {
            currentPet.maintain();
        }
    }

    //method to walk all the dogs
    public void walkAllTheDogs(){
        for (VirtualPet currentPet : virtualPets) {
            if (currentPet instanceof RoboticDog) {
                ((RoboticDog) currentPet).walk();
            }
            else if (currentPet instanceof OrganicDog) {
                ((OrganicDog) currentPet).walk();
            }
        }
    }

    //method that plays with an individual pet
    public void playsWithOnePet(VirtualPet chosenPet) {
        chosenPet.play();
    }

    //tick method that calls a tick method for each of the pets in the shelter
    public void tick() {
        for (VirtualPet currentPet : virtualPets) {
            currentPet.tick();
        }
    }

    //gets size of arraylist
    public int getSize(){
        return virtualPets.size();
    }

    //gets pets
    public VirtualPet getPet(int num){
        return virtualPets.get(num);
    }

}
