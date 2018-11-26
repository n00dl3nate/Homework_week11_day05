public class Flight {

    private Plane plane;
    private int flightNumber;
    private Destination destination;

    public Flight(int flightNumber,Destination destination){
        this.plane = null;
        this.flightNumber = flightNumber;
        this.destination = destination;
    }

    public int getFlightNumber(){
        return this.flightNumber;
    }

    public Plane getPlane() {
        return plane;
    }

    public Destination getDestination(){
        return this.destination;
    }

    public void addPlaneToFlight(Plane aircraft){
        this.plane = aircraft;
    }

    public int getSeatsOnFlight(){
        return this.plane.GetSeatsOnPlane();
    }

}
