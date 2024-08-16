package LogicLayer;

import InputLayer.*;

import java.util.HashMap;
import java.util.Map;

public class Rover {
    private static int idCounter = -1;

    private Position roverPosition;
    private int id;

    public Rover(Position roverPosition) {
        this.roverPosition = roverPosition;
        this.id = idCounter++;
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

    public void setId(int id) {
        this.id = id;
    }
}
