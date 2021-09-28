package virtual_pet;

public class Slug extends VirtualPet{

    private int hunger;
    private int thirst;
    private int sadness;

    public Slug(String name, String description) {
        super(name,description);
        this.hunger = 0;
        this.thirst = 0;
        this.sadness = 0;
    }
    @Override
    public void play(){
        sadness -= 10;
        if (sadness < 0){
            sadness = 0;
        }
    }

    @Override
    public void feed() {
        hunger -= 10;
        if (hunger < 0){
            hunger = 0;
        }
    }

    @Override
    public void water(){
        thirst -= 10;
        if (thirst < 0){
            thirst = 0;
        }
    }

    @Override
    public void adopt() {
        System.out.println("The slug does a happy little dance!");
    }
    @Override
    public int getHunger() {

        return hunger;
    }
    @Override
    public int getThirst() {

        return thirst;
    }
    @Override
    public int getSadness() {

        return sadness;
    }

    public void tickSlug(){
        sadness = Math.min(100, sadness + 10);
        thirst = Math.min(100, thirst + 10);
        hunger = Math.min(100, hunger + 10);
    }
    public String getPetString(){
        return String.format("|%-12s|%8d|%8d|%8d|", getName(), hunger, thirst, sadness);
    }
}
