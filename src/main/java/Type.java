public enum Type {
    AirbusA220("A220",116),AirbusA350("A350",325),Boeing747("747",410),Boeing737("737",250);

    private final int seats;
    private final String model;


    Type(String model, int seats){
        this.model = model;
        this.seats = seats;
    }

    public int getSeats() {
        return this.seats;
    }

    public String getModel() {
        return this.model;
    }

}

