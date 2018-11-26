import java.util.ArrayList;

public class Plane {

    private String airline;
    private ArrayList<Passenger> passengers;
    private Type type;

    public Plane(String airline,Type type){
        this.airline = airline;
        this.passengers = new ArrayList<>();
        this.type = type;
    }


    public String getAirline() {
        return airline;
    }


    public Type getType() {
        return type;
    }

    public ArrayList<Passenger> getPassengers() {
        return this.passengers;
    }


    public void addPassenger(Passenger passenger1) {
        this.passengers.add(passenger1);
    }

    public Passenger removePassenger(Passenger passenger) {
        for (int i = 0; i < this.passengers.size() ; i++){
            if (this.passengers.get(i) == passenger){
                this.passengers.remove(i);
                return passenger;
            }
        }
        return null;
    }

    public int GetSeatsOnPlane(){
        return this.getType().getSeats();
    }


}
