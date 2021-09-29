package virtual_pet;

public class OrganicDog extends OrganicPet implements Walks{

    public OrganicDog(String name, String description) {
        super(name, description);
    }

    @Override
    public void walk() {
        sadness = 0;
        dirty -= 10;
        thirst += 10;
        hunger += 10;
    }
}
