import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class AirportTest {

    Plane plane1;
    Plane plane2;
    Plane plane3;
    Plane plane4;
    Plane plane5;
    Passenger passenger1;
    Passenger passenger2;
    Airport airport;
    Flight flight1;
    Flight flight2;
    Flight flight3;
    Flight flight4;
    Flight flight5;

    @Before
    public void before(){
        plane1 = new Plane("Emerates", Type.AirbusA220);
        plane2 = new Plane("Virgin", Type.AirbusA350);
        plane3 = new Plane("Ryan Air", Type.Boeing737);
        plane4 = new Plane("Easy Jet", Type.Boeing747);
        plane5 = new Plane("Air Force 1", Type.AirbusA220);

        passenger1 = new Passenger("Scott Ferguson",100);
        passenger2 = new Passenger("Jack Daniels",80);

        flight1 = new Flight(1,Destination.Germany);
        flight2 = new Flight(2,Destination.Belfast);
        flight3 = new Flight(3,Destination.Hawaii);
        flight4 = new Flight(4,Destination.Liverpool);
        flight5 = new Flight(5,Destination.Spain);

        airport = new Airport("E25");
    }

    @Test
    public void checkNoPlanes(){
        assertEquals(0,airport.getHanger().size());
    }

    @Test
    public void addPlanes(){
        this.airport.addPlaneToHanger(plane1);
        this.airport.addPlaneToHanger(plane1);
        assertEquals(2,this.airport.getHanger().size());
    }

    @Test
    public void canReturnPlanesWithNoPlane(){
        this.airport.createFlight(1,Destination.Liverpool);
        this.airport.createFlight(2,Destination.Belfast);
        ArrayList<Flight> noPlane = this.airport.FlightsWithNoPlane();
        assertEquals(2,noPlane.size());
    }

    @Test
    public void canReturnPlanesWithNoPlane2(){
        Flight flight1 = this.airport.createFlight(1,Destination.Liverpool);
        flight1.addPlaneToFlight(plane1);
        this.airport.createFlight(2,Destination.Belfast);
        ArrayList<Flight> noPlane = this.airport.FlightsWithNoPlane();
        assertEquals(1,noPlane.size());
    }

    @Test
    public void ManualAssignPlaneToHanger(){
        Flight flight1 = this.airport.createFlight(1,Destination.Liverpool);
        Flight flight2 = this.airport.createFlight(2,Destination.Germany);
        airport.ManualAssignFlight(flight1,plane1);
        ArrayList<Flight> noPlane = this.airport.FlightsWithNoPlane();
        assertEquals(1,noPlane.size());
    }

    @Test
    public void AutoAssignPlanes(){
        Flight flight1 = this.airport.createFlight(1,Destination.Liverpool);
        Flight flight2 = this.airport.createFlight(2,Destination.Germany);
        Flight flight3 = this.airport.createFlight(2,Destination.Hawaii);
        assertEquals(3,this.airport.FlightsWithNoPlane().size());
        assertEquals(0,this.airport.FlightWithPlanes().size());
        this.airport.addPlaneToHanger(plane1);
        this.airport.addPlaneToHanger(plane2);
        this.airport.addPlaneToHanger(plane3);
        String result = this.airport.autoAssignFights();
        assertEquals(0,this.airport.FlightsWithNoPlane().size());
        assertEquals(3,this.airport.FlightWithPlanes().size());
        assertEquals("OK",result);
    }

    @Test
    public void AutoAssignPlanesNotEnoughPlanes(){
        Flight flight1 = this.airport.createFlight(1,Destination.Liverpool);
        Flight flight2 = this.airport.createFlight(2,Destination.Germany);
        Flight flight3 = this.airport.createFlight(2,Destination.Hawaii);
        assertEquals(3,this.airport.FlightsWithNoPlane().size());
        this.airport.addPlaneToHanger(plane1);
        this.airport.addPlaneToHanger(plane2);
        String result = this.airport.autoAssignFights();
        assertEquals(1,this.airport.FlightsWithNoPlane().size());
        assertEquals(2,this.airport.FlightWithPlanes().size());
        assertEquals("Not Enough Planes, 1 Flight Not Assigned A Plane",result);
    }

    @Test
    public void BookPassengerOntoFlight(){
        Flight flight1 = this.airport.createFlight(1,Destination.Liverpool);
        Flight flight2 = this.airport.createFlight(2,Destination.Germany);
        this.airport.addPlaneToHanger(plane1);
        this.airport.addPlaneToHanger(plane2);
        this.airport.autoAssignFights();
        assertEquals("Passenger Booked",this.airport.BookPassengerOntoFlight(flight1,passenger1));
        assertEquals(1,flight1.getPlane().getPassengers().size());
    }

    @Test
    public void viewPassengerBookedOntoFlight(){
        Flight flight1 = this.airport.createFlight(1,Destination.Liverpool);
        Flight flight2 = this.airport.createFlight(2,Destination.Germany);
        this.airport.addPlaneToHanger(plane1);
        this.airport.addPlaneToHanger(plane2);
        this.airport.autoAssignFights();
        this.airport.BookPassengerOntoFlight(flight1,passenger1);
        this.airport.BookPassengerOntoFlight(flight1,passenger2);
        assertEquals(2,this.airport.returnPassengersOnFlight(flight1).size());
        assertEquals(0,this.airport.returnPassengersOnFlight(flight2).size());
    }

    @Test
    public void SortHangerFunction(){
        this.airport.addPlaneToHanger(plane1);
        this.airport.addPlaneToHanger(plane2);
        this.airport.addPlaneToHanger(plane3);
        this.airport.addPlaneToHanger(plane4);
        this.airport.addPlaneToHanger(plane5);
        airport.sortPlanes();
        assertEquals(5,this.airport.getHanger().size());
    }

    @Test
    public void sortFlightsFunction(){
        flight1= this.airport.createFlight(1,Destination.Liverpool);
        flight2=this.airport.createFlight(2,Destination.Germany);
        flight3=this.airport.createFlight(3,Destination.Hawaii);
        flight4=this.airport.createFlight(4,Destination.Spain);
        flight5=this.airport.createFlight(5,Destination.Belfast);
        airport.sortflights();
        assertEquals(5,this.airport.getFlightList().size());
    }

    @Test
    public void AutoAssignDependingOnJourney(){
        flight1 = this.airport.createFlight(1,Destination.Liverpool);
        flight2 = this.airport.createFlight(2,Destination.Germany);
        flight3 = this.airport.createFlight(3,Destination.Hawaii);
        flight4 = this.airport.createFlight(4,Destination.Spain);
        flight5 = this.airport.createFlight(5,Destination.Belfast);
        this.airport.addPlaneToHanger(plane1);
        this.airport.addPlaneToHanger(plane2);
        this.airport.addPlaneToHanger(plane3);
        this.airport.addPlaneToHanger(plane4);
        this.airport.addPlaneToHanger(plane5);
        this.airport.sortflights();
        this.airport.sortPlanes();
        this.airport.autoAssignFights();
    }






}
