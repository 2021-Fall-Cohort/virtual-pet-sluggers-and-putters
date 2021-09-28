package virtual_pet;

public abstract class VirtualPet {
    private String name;
    private String description;

    public VirtualPet(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {return name;}

    public String getDescription() {
        return description;
    }

    public abstract void play();

    public abstract void feed();

    public abstract void water();

    public abstract void adopt();

    public abstract int getHunger();

    public abstract int getThirst();

    public abstract int getSadness();

}
