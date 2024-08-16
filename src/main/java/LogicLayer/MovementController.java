package LogicLayer;

import InputLayer.Instruction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//MovementController is a singleton it contains a map of the instructions to the method using a method reference
public class MovementController {

    private static final MovementController instance = new MovementController();

    private final Map<Instruction, Runnable> movementMap = new HashMap<>();

    private MovementController() {
        movementMap.put(Instruction.L, this::turnLeft);
        movementMap.put(Instruction.R, this::turnRight);
        movementMap.put(Instruction.M, this::moveForward);
    };

    public static MovementController getInstance() {
        return instance;
    }

    public ArrayList<Runnable> convertInstructions(ArrayList<Instruction> instructions){
        // methods takes the list of instructions and converts them to an arraylist of runnables
        ArrayList<Runnable> commands = new ArrayList<>();
        for(Instruction instruction : instructions){
            commands.add(movementMap.get(instruction));
        }

        return commands;
    }


    public void moveForward(){};
    public void turnLeft(){};
    public void turnRight(){};



}
