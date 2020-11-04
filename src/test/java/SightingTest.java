import org.junit.*;
import static org.junit.Assert.*;

public class SightingTest {

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void sighting_instantiatesCorrectly_true() {
        Sighting testSighting = new Sighting("zone_A", "kimani");
        assertEquals(true, testSighting instanceof Sighting);
    }

    @Test
    public void getLocation_sightingInstantiatesWithZone_A() {
        Sighting testSighting = new Sighting("zone_A", "kimani");
        assertEquals("zone_A", testSighting.getLocation());
    }

    @Test
    public void getRanger_sightingRangerInstantiatesCorrect_String() {
        Sighting testSighting = new Sighting("zone_A", "kimani");
        assertEquals("kimani", testSighting.getRanger());
    }

    @Test
    public void equals_returnsTrueIfRangerAndLocationAreSame_true() {
        Sighting firstSighting = new Sighting("zone_A", "kimani");
        Sighting anotherSighting = new Sighting("zone_A", "kimani");
        assertTrue(firstSighting.equals(anotherSighting));
    }

    //db tests
    @Test
    public void save_insertsObjectIntoDatabase_Sightings() {
        Sighting testSighting = new Sighting("zone_A", "kimani");
        testSighting.save();
        assertTrue(Sighting.all().get(0).equals(testSighting));
    }

    @Test
    public void all_returnsAllInstancesOfSighting_true() {
        Sighting firstSighting = new Sighting("zone_A", "kimani");
        firstSighting.save();
        Sighting secondSighting = new Sighting("zone_A", "kimani");
        secondSighting.save();
        assertEquals(true, Sighting.all().get(0).equals(firstSighting));
        assertEquals(true, Sighting.all().get(1).equals(secondSighting));
    }

    @Test
    public void save_assignsIdToSighting() {
        Sighting testSighting = new Sighting("zone_A", "kimani");
        testSighting.save();
        Sighting savedSighting = Sighting.all().get(0);
        assertEquals(testSighting.getId(), savedSighting.getId());
    }

    @Test
    public void find_returnsSightingWithSameId_secondSighting() {
        Sighting firstSighting = new Sighting("zone_A", "kimani");
        firstSighting.save();
        Sighting secondSighting = new Sighting("zone_A", "kimani");
        secondSighting.save();
        assertEquals(Sighting.find(secondSighting.getId()), secondSighting);
    }

}
