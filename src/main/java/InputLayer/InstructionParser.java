package InputLayer;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InstructionParser {
    // takes a string input
    // returns an array list of instruction enums

    public static ArrayList<Instruction> parse(String input){

        ArrayList<Instruction> instructions = new ArrayList<>();
        if (input == null) return null;

        Pattern pattern = Pattern.compile("^[lmrLMR]+$");
        Matcher matcher = pattern.matcher(input);

        if (!matcher.find()){
            throw new IllegalArgumentException("Invalid input.");
        }

        for (char ch : input.toUpperCase().toCharArray()){
            switch (ch) {
                case 'L':
                    instructions.add(Instruction.L);
                    break;
                case 'R':
                    instructions.add(Instruction.R);
                    break;
                case 'M':
                    instructions.add(Instruction.M);
                    break;
                    
            }
        }

        return instructions;
    }
}
