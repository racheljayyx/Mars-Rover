package LogicLayer;

import InputLayer.Instruction;
import InputLayer.InstructionParser;
import static LogicLayer.MovementController.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class MissionControl {

    private final Plateau plateau = Plateau.getInstance();
    private Map<Rover, String> roverInstructonMap = new HashMap<>();

    public MissionControl(Map<Rover, String> roverInstructonMap) {
        this.roverInstructonMap = roverInstructonMap;
    }

    public void runInstructions(Rover rover){

        String instructionsForRover = roverInstructonMap.get(rover);
        int roverXCoord = rover.getRoverPosition().getX();
        int roverYCoord = rover.getRoverPosition().getY();
        ArrayList<Instruction> instructions = InstructionParser.parse(instructionsForRover);

        if (instructions == null) throw new AssertionError();
        for(Instruction instruction : instructions){
            if (roverXCoord >= plateau.getPlateauSize().x_dimension()){
                rover.getRoverPosition().setX(roverXCoord%plateau.getPlateauSize().x_dimension());
            } else if (roverYCoord >= plateau.getPlateauSize().y_dimension()) {
                rover.getRoverPosition().setY(roverYCoord%plateau.getPlateauSize().y_dimension());
            }
            switch (instruction){
                case L -> turnLeft(rover);
                case R -> turnRight(rover);
                case M -> moveForward(rover);
            }
        }
    }

}
