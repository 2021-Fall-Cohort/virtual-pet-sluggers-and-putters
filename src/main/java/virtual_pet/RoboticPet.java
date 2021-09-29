package virtual_pet;

public abstract class RoboticPet extends VirtualPet{

    protected int oil;
    protected int gas;
    protected int broken;

    public RoboticPet(String name, String description) {
        super(name, description);
        this.oil = 0;
        this.gas = 0;
        this.broken = 0;
    }

    public int getThirst() {
        return oil;
    }

    public int getHunger() {
        return gas;
    }

    public int getMaintenance() {
        return broken;
    }

    public void feed() {
        gas -= 10;
        if (gas < 0){
            gas = 0;
        }
    }

    public void water() {
        oil -= 10;
        if (oil < 0){
            oil = 0;
        }
    }

    public void maintain() {
        broken -= 10;
        if (broken < 0){
            broken = 0;
        }
    }

    public void tick(){
        sadness = Math.min(100, sadness + 10);
        oil = Math.min(100, oil + 10);
        gas = Math.min(100, gas + 10);
        broken = Math.min(100, broken + 10);
    }

    public String getRoboticString(){
        return String.format("|%-12s|%8d|%8d|%8d|%11d|", getName(), gas, oil, sadness, broken);
    }
}
