package virtual_pet;

public abstract class VirtualPet {
    protected String name;
    protected String description;
    protected int sadness;

    public VirtualPet(String name, String description) {
        this.name = name;
        this.description = description;
        this.sadness = 0;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getSadness() {
        return sadness;
    }

    public void play(){
        sadness -= 10;
        if (sadness < 0){
            sadness = 0;
        }
    }

    public abstract void feed(); //food or gas

    public abstract void water(); //water or oil

    public abstract void maintain(); //cage or mechanical

    public abstract int getHunger(); //show gas or food

    public abstract int getThirst(); //show water or oil

    public abstract int getMaintenance(); //show dirty or mech

    public abstract void tick();

    public abstract boolean isAlive();
}
