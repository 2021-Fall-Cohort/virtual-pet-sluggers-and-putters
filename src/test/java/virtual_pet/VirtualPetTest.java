package virtual_pet;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VirtualPetTest {
    //should be able to get a pet's name
    @Test
    public void shouldGetAPetsName(){
        VirtualPetShelter underTest = new VirtualPetShelter();
        String testName = underTest.getPet(0).getName();
        assertEquals(testName, "Toofth");
    }
    //should be able to get a pet's description
    @Test
    public void shouldGetAPetsDescription(){
        VirtualPetShelter underTest = new VirtualPetShelter();
        String testDescription = underTest.getPet(0).getDescription();
        assertEquals(testDescription, "a slug who has a portly figure with a long, golden beard.");
    }
}
