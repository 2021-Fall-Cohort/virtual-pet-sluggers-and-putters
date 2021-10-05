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
        String hungerCount = "";
        String thirstCount = "";
        String sadnessCount = "";
        String dirtyCount = "";
        for (int i = 0; i <= hunger; i += 7){
            hungerCount += "|";
        }
        for (int i = 0; i <= thirst; i += 7){
            thirstCount += "|";
        }
        for (int i = 0; i <= sadness; i += 7){
            sadnessCount += "|";
        }
        for (int i = 0; i <= dirty; i += 7){
            dirtyCount += "|";
        }
        return String.format("|%-12s|%-15s|%-15s|%-15s|%-15s|", getName(), hungerCount, thirstCount, sadnessCount, dirtyCount);
    }

    public void tick(){
        sadness = Math.min(100, (int) (sadness + Math.floor(Math.random() * 10)));
        thirst = Math.min(100, (int) (thirst + Math.floor(Math.random() * 10)));
        hunger = Math.min(100, (int) (hunger + Math.floor(Math.random() * 10)));
        dirty = Math.min(100, (int) (dirty + Math.floor(Math.random() * 10)));
        if (sadness >= thirst && sadness >= hunger && sadness >= dirty){
            sadness = Math.max(0, sadness-10);
        }
        else if (thirst >= sadness && thirst >= hunger && thirst >= dirty){
            thirst = Math.max(0, thirst-10);
        }
        else if (dirty >= sadness && dirty >= thirst && dirty >= hunger){
            dirty = Math.max(0, dirty-10);
        }
        else{
            hunger = Math.max(0, hunger-10);
        }
    }

}
