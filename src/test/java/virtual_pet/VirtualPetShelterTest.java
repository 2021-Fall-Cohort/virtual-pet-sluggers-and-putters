package virtual_pet;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VirtualPetShelterTest {
    //should have a variable that stores the pets in the shelter
    @Test
    public void shouldHaveVariableStoresPets (){
        VirtualPetShelter underTest = new VirtualPetShelter();
        underTest.addPetToShelter(1,"Dingo", "dango dongo");
        int numberOfPets = underTest.getSize();
        assertEquals(7, numberOfPets);
    }
    @Test
    public void shouldReturnNamesAllPets(){
        VirtualPetShelter underTest = new VirtualPetShelter();
        assertTrue(underTest.retrievePetNames().toString().contains("Toofth"));
        assertTrue(underTest.retrievePetNames().toString().contains("Rutherford"));
        assertTrue(underTest.retrievePetNames().toString().contains("Lil Baby"));
        assertTrue(underTest.retrievePetNames().toString().contains("Dave"));
        assertTrue(underTest.retrievePetNames().toString().contains("Queen A"));
    }
    //should be able to return a collection of all the pets in the shelter
    @Test
    public void shouldReturnCollectionOfPets(){
        VirtualPetShelter underTest = new VirtualPetShelter();
        ArrayList testTest = underTest.returnsCollectionOfPets();
        assertEquals(testTest.size(), underTest.getSize());
    }
    //should be able to return specific pet given name
    @Test
    public void shouldReturnPetGivenName(){
        VirtualPetShelter underTest = new VirtualPetShelter();
        underTest.addPetToShelter(1,"Dingo", "dango dongo");
        assertEquals(underTest.getPet(6), underTest.getPetByName("Dingo"));

    }
    //should allow intake of homeless pet
    @Test
    public void shouldAllowIntakeOfPets (){
        VirtualPetShelter underTest = new VirtualPetShelter();
        underTest.addPetToShelter(1,"Dingo", "dango dongo");
        int numberOfPets = underTest.getSize();
        assertEquals(7, numberOfPets);
    }
    //should allow adoption of a pet
    @Test
    public void shouldAllowAdoptionOfPet (){
        VirtualPetShelter underTest = new VirtualPetShelter();
        underTest.addPetToShelter(1,"Dingo", "dango dongo");
        underTest.removePetFromShelter(underTest.getPetByName("Dingo"));
        int numberOfPets = underTest.getSize();
        assertEquals(6, numberOfPets);
    }
    //should have a method to feed the pets in the shelter
    @Test
    public void shouldFeedAllPets(){
        VirtualPetShelter underTest = new VirtualPetShelter();
        underTest.tick();
        underTest.feedsAllThePets();
        assertEquals(0,underTest.getPet(0).getHunger());
    }
    //should have a method to water the pets in the shelter
    @Test
    public void shouldWaterAllPets(){
        VirtualPetShelter underTest = new VirtualPetShelter();
        underTest.tick();
        underTest.watersAllThePets();
        assertEquals(0, underTest.getPet(0).getThirst());
    }
    //should play with one pet
    @Test
    public void shouldPlayWithSpecificPet(){
        VirtualPetShelter underTest = new VirtualPetShelter();
        underTest.tick();
        underTest.playsWithOnePet(underTest.getPet(0));
        assertEquals(0, underTest.getPet(0).getSadness());
    }
    //should check if pets are alive
    @Test
    public void shouldCheckIfPetsAreAlive(){
        VirtualPetShelter underTest = new VirtualPetShelter();
        assertEquals(true, underTest.aliveCheck());
    }
    //should get size of array list
    @Test
    public void shouldGetSizeOfArrayList(){
        VirtualPetShelter underTest = new VirtualPetShelter();
        assertEquals(6, underTest.getSize());
    }
    //should empty the array list of all pets
    @Test
    public void shouldClearTheArrayList(){
        VirtualPetShelter underTest = new VirtualPetShelter();
        underTest.empty();
        underTest.addPetToShelter(1,"Dag","davis");
        assertEquals(1, underTest.getSize());
    }
    //should check tick makes pets die
    @Test
    public void shouldCheckIfTickKillsPets(){
        VirtualPetShelter underTest = new VirtualPetShelter();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        assertEquals(false, underTest.aliveCheck());
    }
    //should report that pet has died
    @Test
    public void shouldReportPetDead() {
        VirtualPetShelter underTest = new VirtualPetShelter();
        underTest.empty();
        underTest.addPetToShelter(1, "dag", "davis");
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        underTest.tick();
        assertEquals("dag, \b\b fainted.", underTest.report());
    }
}
