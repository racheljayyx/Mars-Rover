package InputLayer;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class InstructionParser {

    public static ArrayList<Instruction> parse(String input){

        ArrayList<Instruction> instructions = new ArrayList<>();
        if (input == null) return null;

        Pattern pattern = Pattern.compile("^[lmrLMR]+$");
        Matcher matcher = pattern.matcher(input);

        if (!matcher.find()){
            throw new IllegalArgumentException("Input must only contain 'L', 'M' or 'R'.");
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
