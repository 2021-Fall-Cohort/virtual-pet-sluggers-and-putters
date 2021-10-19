package virtual_pet;

public class RoboticDog extends RoboticPet implements Walks{

    public RoboticDog(String name, String description) {
        super(name, description);
    }

    @Override
    public void walk() {
        sadness = 0;
        broken += 10;
        oil += 10;
        gas += 10;
    }
}
