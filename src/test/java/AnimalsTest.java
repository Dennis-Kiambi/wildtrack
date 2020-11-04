import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalsTest {

    //squads helper method
    public Animals testAnimal(){
        return new Animals("lion","young","true","true");

    }



//    @Rule
//    public DatabaseRule database = new DatabaseRule();

    @Test
    public void animal_instantiatesCorrectly_true() {
        Animals testObject = testAnimal();
        assertEquals(true, testObject instanceof Animals);
    }


//    @Test
//    public void getId() {
//    }

    @Test
    public void getName_successfulGet_String() {
        Animals testObject = testAnimal();
        assertEquals("lion", testObject.getName());


    }

    @Test
    public void getAge_successfulGet_String() {
        Animals testObject =testAnimal();
        assertEquals("young",testObject.getAge());
    }

    @Test
    public void getEndangered() {
    }

    @Test
    public void getHealthy() {
    }

    @Test
    public void testEquals() {
    }

    @Test
    public void save() {
    }

    @Test
    public void all() {
    }

    @Test
    public void find() {
    }
}