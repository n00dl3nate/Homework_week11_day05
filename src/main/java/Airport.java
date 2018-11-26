import java.util.ArrayList;
import java.util.Collections;

public class Airport {

    private ArrayList<Plane> hanger;
    private ArrayList<Flight> flightList;
    private String airportCode;

    public Airport(String airportCode){
        this.airportCode = airportCode;
        this.hanger = new ArrayList<>();
        this.flightList = new ArrayList<>();
    }

    public ArrayList<Plane> getHanger() {
        return hanger;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void addPlaneToHanger(Plane plane){
        this.hanger.add(plane);
    }

    public void removerPlane(int index) {
        this.hanger.remove(index);
    }

    public void addFlight(Flight flight){
        this.flightList.add(flight);
    }

    public Plane removePlane(Plane plane){
        for (int i = 0; i <this.hanger.size(); i++) {
           if (this.hanger.get(i) == plane){
               return this.hanger.remove(i);
           }
        }
        return null;
    }

    public Flight createFlight(int flightNumber,Destination destination){
        Flight flight = new Flight(flightNumber,destination);
        this.addFlight(flight);
        return flight;
    }

    public ArrayList FlightsWithNoPlane(){
        ArrayList<Flight> NoPlane = new ArrayList<>();
        for (int i = 0; i < this.flightList.size() ; i++) {
            if(flightList.get(i).getPlane() == null){
                NoPlane.add(flightList.get(i));
            }
        }
        return NoPlane;
    }

    public ArrayList FlightWithPlanes(){
        ArrayList<Flight> GotPlane = new ArrayList<>();
        for (int i = 0; i < this.flightList.size() ; i++) {
            if(this.flightList.get(i).getPlane() != null){
                GotPlane.add(flightList.get(i));
            }
        }
        return GotPlane;
    }


    public void ManualAssignFlight(Flight flight, Plane plane) {
        for (int i = 0; i < flightList.size() ; i++) {
            if(flightList.get(i) == flight){
                flightList.get(i).addPlaneToFlight(plane);
            }
        }
    }

    public String autoAssignFights() {
        if (this.flightList.size() <= this.hanger.size()) {
            for (int i = 0; i < flightList.size(); i++) {
                Plane plane = this.hanger.get(i);
                this.flightList.get(i).addPlaneToFlight(plane);
            }
            return "OK";
        }
        else {
            for (int i = 0; i < hanger.size(); i++) {
                Plane plane = this.hanger.get(i);
                this.flightList.get(i).addPlaneToFlight(plane);
            }
            String num = Integer.toString(FlightsWithNoPlane().size());
            return "Not Enough Planes, " + num + " Flight Not Assigned A Plane" ;
        }

    }


    public String BookPassengerOntoFlight(Flight flight,Passenger passenger) {
        if (flight.getPlane() != null && flight.getPlane().getPassengers().size() < flight.getSeatsOnFlight()){
            if (passenger.getMoney() >= 25) {
                int newAmount = passenger.getMoney() - 25;
                passenger.setMoney(newAmount);
                flight.getPlane().addPassenger(passenger);
                return "Passenger Booked";
            }
            else {
                return "passenger Doesn't Have Enough Money";
            }
        }
        else if(flight.getSeatsOnFlight() == flight.getPlane().getPassengers().size()){
            return "No Seats On This Flight";
        }
        else{
            return "Error";
        }
    }

    public void sortPlanes(){
        for (int x = 0; x < this.hanger.size() ; x++) {
            for (int i = 0; i < this.hanger.size()-1 ; i++) {
                if(this.hanger.get(i).getType().getSeats() >= this.hanger.get(i+1).getType().getSeats()){
                    Plane plane = this.hanger.remove(i+1);
                    this.hanger.add(i,plane);
                }

            }
        }
    }

    public int getDistance(int index){
        return this.flightList.get(index).getDestination().getDistance();
    }

    public void sortflights(){
        for (int i = 0; i < this.flightList.size() ; i++) {
            for (int j = 0; j < this.flightList.size()-1 ; j++) {
                if(getDistance(j) >= getDistance(j+1)){
                    Flight flight = this.flightList.remove(j+1);
                    this.flightList.add(j,flight);
                }
            }
        }
    }

    public ArrayList<Flight> getFlightList() {
        return flightList;
    }

    public ArrayList returnPassengersOnFlight(Flight flight){
        return flight.getPlane().getPassengers();
    }









}
