package LogicLayer;

import InputLayer.Direction;
import InputLayer.Instruction;
import InputLayer.Position;

import java.util.ArrayList;
import java.util.Map;

//MovementController is a utility class
public final class MovementController {

    public static void moveForward(Rover rover){
        Position position = rover.getRoverPosition();
        switch (position.getFacing()){
            case N -> position.setY(position.getY() + 1);
            case E -> position.setX(position.getX() + 1);
            case S -> position.setY(position.getY() - 1);
            case W -> position.setX(position.getX() - 1);
        }
    };
    public static void turnLeft(Rover rover){
        Position position = rover.getRoverPosition();
        switch (position.getFacing()){
            case N -> position.setFacing(Direction.W);
            case E -> position.setFacing(Direction.N);
            case S -> position.setFacing(Direction.E);
            case W -> position.setFacing(Direction.S);
        }
    };
    public static void turnRight(Rover rover){
        Position position = rover.getRoverPosition();
        switch (position.getFacing()){
            case N -> position.setFacing(Direction.E);
            case E -> position.setFacing(Direction.S);
            case S -> position.setFacing(Direction.W);
            case W -> position.setFacing(Direction.N);
        }
    };



}
