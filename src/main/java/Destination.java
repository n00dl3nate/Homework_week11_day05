public enum Destination {
    Spain(200),Hawaii(800),Germany(600),Liverpool(50),Belfast(50);

    private final int distance;

    Destination(int distance){
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }
}
