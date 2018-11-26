import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightTest {

    Flight flight;
    Plane plane;
    Type type;
    Passenger passenger1;


    @Before
    public void before(){
            plane = new Plane("Emerates", Type.AirbusA220);
            passenger1 = new Passenger("Scott Ferguson",100);
            flight = new Flight(1, Destination.Germany);
    }

    @Test
    public void getPlaneOnFlightNoPlane(){
    assertEquals(null,flight.getPlane());
    }

    @Test
    public void getPlaneOnFlight(){
        flight.addPlaneToFlight(plane);
        assertEquals(plane,flight.getPlane());
    }




}
