package LogicLayer;

import InputLayer.*;

public class Rover {
    private int id = 0;
    private Position roverPosition;

    public Rover(Position roverPosition) {
        this.roverPosition = roverPosition;
        this.id +=1;
    }

    public int getId() {
        return id;
    }

    public Position getRoverPosition() {
        return roverPosition;
    }

    public void setRoverPosition(Position roverPosition) {
        this.roverPosition = roverPosition;
    }
}
