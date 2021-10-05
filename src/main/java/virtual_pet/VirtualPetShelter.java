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
                slugPic();
                break;
            case 2:
                virtualPets.add(new RoboticSlug(name, description));
                slugPic();
                break;
            case 3:
                virtualPets.add(new OrganicCat(name, description));
                catPic();
                break;
            case 4:
                virtualPets.add(new RoboticCat(name, description));
                catPic();
                break;
            case 5:
                virtualPets.add(new OrganicDog(name, description));
                dogPic();
                break;
            case 6:
                virtualPets.add(new RoboticDog(name, description));
                dogPic();
                break;
        }
    }


    //method that allows adoption that removes pet
    public void removePetFromShelter(VirtualPet chosenPet){
        for (int i = 0; i < virtualPets.size(); i++){
            if(virtualPets.get(i) == chosenPet){
                if (chosenPet instanceof RoboticDog){
                    dogPic();
                }
                else if (chosenPet instanceof RoboticCat){
                    catPic();
                }
                else if (chosenPet instanceof RoboticSlug){
                    slugPic();
                }
                else if (chosenPet instanceof OrganicDog){
                    dogPic();
                }
                else if (chosenPet instanceof OrganicCat){
                    catPic();
                }
                else if (chosenPet instanceof OrganicSlug){
                    slugPic();
                }
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
        dogWalk();
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
    //checks if pets are alive
    public boolean aliveCheck(){
        for (VirtualPet currentPet : virtualPets) {
            if (!currentPet.isAlive()) {
                return false;
            }
        }
        return true;
    }

    //gets size of arraylist
    public int getSize(){
        return virtualPets.size();
    }

    //get pets
    public VirtualPet getPet(int num){
        return virtualPets.get(num);
    }
    //clears pets out of the shelter
    public void empty() {
        virtualPets.clear();
    }

    public String report() {
        String listOfDeadPets = "";
        System.out.println();
        for (VirtualPet currentPet : virtualPets) {
            if (!currentPet.isAlive()) {
                listOfDeadPets += currentPet.getName() + ", ";
            }
        }
        listOfDeadPets += "\b\b fainted.";
        return listOfDeadPets;
    }

    public void slugPic(){
        System.out.println("              (Yay!!)\n" +
                "     ^     ^  /\n" +
                "    /|____/| /\n" +
                "   (    3   )\n" +
                "    ( Y  y )\n" +
                "     \\    /\n" +
                "      \\  / \n" +
                "       ()\n");
    }

    public void dogPic(){
        System.out.println("     |\\_/|                  \n" +
                "     | @ @   Woof! \n" +
                "     |   <>              _  \n" +
                "     |  _/\\------____ ((| |))\n" +
                "     |               `--' |   \n" +
                " ____|_       ___|   |___.' \n" +
                "/_/_____/____/_______|");
    }

    public void catPic(){
        System.out.println("    |\\__/,|   (`\\Yay!\n" +
                "  _.|o o  |_   ) )\n" +
                "-(((---(((--------");
    }

    public void dogWalk(){
        System.out.println("          __\n" +
                " \\ ______/ V`-,\n" +
                "  }        /~~\n" +
                " /_)^ --,r'\n" +
                "|b      |b");
    }

    public void shelterPic(){
        System.out.println("                           (   )\n" +
                "                          (    )\n" +
                "                           (    )\n" +
                "                          (    )\n" +
                "                            )  )\n" +
                "                           (  (                  /\\\n" +
                "                            (_)                 /  \\  /\\\n" +
                "                    ________[_]________      /\\/    \\/  \\\n" +
                "           /\\      /\\        ______    \\    /   /\\/\\  /\\/\\\n" +
                "          /  \\    //_\\       \\    /\\    \\  /\\/\\/    \\/    \\\n" +
                "   /\\    / /\\/\\  //___\\       \\__/  \\    \\/\n" +
                "  /  \\  /\\/    \\//_____\\       \\ |[]|     \\\n" +
                " /\\/\\/\\/       //_______\\       \\|__|      \\\n" +
                "/      \\      /XXXXXXXXXX\\                  \\\n" +
                "        \\    /_I_II  I__I_\\__________________\\\n" +
                "               I_I|  I__I_____[]_|_[]_____I\n" +
                "               I_II  I__I_____[]_|_[]_____I\n" +
                "               I II__I  I     XXXXXXX     I\n" +
                "            ~~~~~\"   \"~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public void bearPic(){
        System.out.println(" __         __\n" +
                "/  \\.-\"\"\"-./  \\\n" +
                "\\    -   -    /\n" +
                " |   o   o   |  Shoo Bear!\n" +
                " \\  .-'''-.  /\n" +
                "  '-\\__Y__/-'\n" +
                "     `---`");
    }

    public void bearPic2(){
        System.out.println("  _,-\"\"`\"\"-~`)\n" +
                "(`~_,=========\\\n" +
                " |---,___.-.__,\\\n" +
                " |        o     \\ ___  _,,,,_     _.--.\n" +
                "  \\      `^`    /`_.-\"~      `~-;`     \\\n" +
                "   \\_      _  .'                 `,     |\n" +
                "     |`-                           \\'__/ \n" +
                "    /                      ,_       \\  `'-. \n" +
                "   /    .-\"\"~~--.            `\"-,   ;_    /\n" +
                "  |              \\               \\  | `\"\"`\n" +
                "   \\__.--'`\"-.   /_               |'\n" +
                "              `\"`  `~~~---..,     |\n" +
                " What are you doing here!    \\ _.-'`-.\n" +
                "        Shoo!                 \\       \\\n" +
                "                               '.     /\n" +
                "                                 `\"~\"`");
    }
}
