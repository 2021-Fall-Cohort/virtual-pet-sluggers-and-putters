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
        sadness = Math.min(100, (int) (sadness + Math.floor(Math.random() * 10)));
        oil = Math.min(100, (int) (oil + Math.floor(Math.random() * 10)));
        gas = Math.min(100, (int) (gas + Math.floor(Math.random() * 10)));
        broken = Math.min(100, (int) (broken + Math.floor(Math.random() * 10)));
        if (sadness >= oil && sadness >= gas && sadness >= broken){
            sadness = Math.max(0, sadness - 10);
        }
        else if (oil >= sadness && oil >= gas && oil >= broken){
            oil = Math.max(0, oil - 10);
        }
        else if (broken >= sadness && broken >= oil && broken >= gas){
            broken = Math.max(0, broken - 10);
        }
        else{
            gas = Math.max(0, gas - 10);
        }

    }

    public String getRoboticString(){
        String gasCount = "";
        String oilCount = "";
        String sadnessCount = "";
        String brokenCount = "";
        for (int i = 0; i <= gas; i += 7){
            gasCount += "▒";
        }
        for (int i = 0; i <= oil; i += 7){
            oilCount += "▒";
        }
        for (int i = 0; i <= sadness; i += 7){
            sadnessCount += "▒";
        }
        for (int i = 0; i <= broken; i += 7){
            brokenCount += "▒";
        }
        return String.format("|%-12s|%c-15s|%c-15s|%c-15s|%c-15s|", getName() , gasCount, oilCount, sadnessCount, brokenCount);
    }
}

