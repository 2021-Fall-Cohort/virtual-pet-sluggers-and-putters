package virtual_pet;

public abstract class OrganicPet extends VirtualPet{

    protected int hunger;
    protected int thirst;
    protected int dirty;

    public OrganicPet(String name, String description) {
        super(name, description);
        this.hunger = 0;
        this.thirst = 0;
        this.dirty = 0;
    }

    public void feed() {
        hunger -= 10;
        if (hunger < 0){
            hunger = 0;
        }
    }

    public void water(){
        thirst -= 10;
        if (thirst < 0){
            thirst = 0;
        }
    }

    public void maintain(){
        dirty -= 10;
        if (dirty < 0){
            dirty = 0;
        }
    }

    public int getHunger() {
        return hunger;
    }

    public int getThirst() {
        return thirst;
    }

    public int getMaintenance(){
        return dirty;
    }

    public String getOrganicString(){
        return String.format("|%-12s|%8d|%8d|%8d|%11d|", getName(), hunger, thirst, sadness, dirty);
    }

    public void tick(){
        sadness = Math.min(100, sadness + 10);
        thirst = Math.min(100, thirst + 10);
        hunger = Math.min(100, hunger + 10);
        dirty = Math.min(100, dirty + 10);
    }

}
