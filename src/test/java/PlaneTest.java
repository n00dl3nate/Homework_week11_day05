import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class PlaneTest {

    Plane plane;
    Type type;
    Passenger passenger1;

    @Before
    public void before() {
        plane = new Plane("Emerates", Type.AirbusA220);
        passenger1 = new Passenger("Scott Ferguson",100);
    }

    @Test
    public void getAirline() {
        assertEquals("Emerates",plane.getAirline());
    }


    @Test
    public void getType() {
        assertEquals(Type.AirbusA220,plane.getType());
    }

    @Test
    public void checkPlaneStartsEmpty(){
        ArrayList<Passenger> passengers = plane.getPassengers();
        assertEquals(0,passengers.size());
    }

    @Test
    public void canAddPassenger(){
        plane.addPassenger(passenger1);
        ArrayList<Passenger> passengers = plane.getPassengers();
        assertEquals(1,passengers.size());
    }

    @Test
    public void canRemovePassenger(){
        plane.addPassenger(passenger1);
        plane.removePassenger(passenger1);
        ArrayList<Passenger> passengers = plane.getPassengers();
        assertEquals(0,passengers.size());
    }



}