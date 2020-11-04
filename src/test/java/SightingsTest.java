import org.junit.Test;

import java.text.SimpleDateFormat;

import static org.junit.Assert.*;

public class SightingsTest {

    //helper method
    public Sightings setSightingobject(){
        Sightings testObject = new Sightings("zone_A","kamala");

        return testObject;
    }

    @Test
    public void getLocation() {
        Sightings testSighting= setSightingobject();
        assertEquals("zone_A", testSighting.getLocation());
    }

    @Test
    public void getRanger() {
        Sightings testSighting= setSightingobject();
        assertEquals("kamala", testSighting.getRanger());
    }
}