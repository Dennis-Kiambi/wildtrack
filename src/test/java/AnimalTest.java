import org.junit.Rule;
import org.junit.Test;

import static models.DB.sql2o;
import static org.junit.Assert.*;

public class AnimalTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void animal_instantiatesCorrectly_true() {
        Animal testAnimal = new Animal("lion", "young","true","true", sql2o);
        assertEquals(true, testAnimal instanceof Animal);
    }

    @Test
    public void getName_animalInstantiatesWithName_lion() {
        Animal testAnimal = new Animal("lion", "young","true","true", sql2o);
        assertEquals("lion", testAnimal.getName());

    }

    @Test
    public void getAge_animalInstantiatesWithAge_young() {
        Animal testAnimal = new Animal("lion", "young","true","true", sql2o);
        assertEquals("young", testAnimal.getAge());

    }

    @Test
    public void getEndangered_animalInstantiatesWithEndangered_true() {
        Animal testAnimal = new Animal("lion", "young","true","true", sql2o);
        assertEquals("true", testAnimal.getEndangered());

    }

    @Test
    public void getHealthy_animalInstantiatesWithHealthy_true() {
        Animal testAnimal = new Animal("lion", "young","true","true", sql2o);
        assertEquals("true", testAnimal.getHealthy());

    }

    @Test
    public void equals_returnsTrueIfAnimalAreSame_true() {
        Animal firstAnimal = new Animal("lion", "young","true","true", sql2o);
        Animal anotherAnimal = new Animal("lion", "young","true","true", sql2o);
        assertTrue(firstAnimal.equals(anotherAnimal));
    }

    //db tests
    @Test
    public void save_insertsObjectIntoDatabase_Animals() {
        Animal testAnimal = new Animal("lion", "young","true","true", sql2o);
        testAnimal.save();
        assertTrue(Animal.all().get(0).equals(testAnimal));
    }

    @Test
    public void all_returnsAllInstancesOfAnimal_true() {
        Animal firstAnimal= new Animal("lion", "young","true","true", sql2o);
        firstAnimal.save();
        Animal secondAnimal = new Animal("lion", "young","true","true", sql2o);
        secondAnimal.save();
        assertEquals(true, Sighting.all().get(0).equals(firstAnimal));
        assertEquals(true, Sighting.all().get(1).equals(secondAnimal));
    }

    @Test
    public void save_assignsIdToAnimal() {
        Animal testAnimal = new Animal("lion", "young","true","true", sql2o);
        testAnimal.save();
        Animal savedAnimal = Animal.all().get(0);
        assertEquals(testAnimal.getId(), savedAnimal.getId());
    }

    @Test
    public void find_returnsAnimalWithSameId_secondAnimal() {
        Animal firstAnimal = new Animal("lion", "young","true","true", sql2o);
        firstAnimal.save();
        Animal secondAnimal = new Animal("lion", "young","true","true", sql2o);
        secondAnimal.save();
        assertEquals(Animal.find(secondAnimal.getId()), secondAnimal);
    }


}