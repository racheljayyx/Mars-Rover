package InputLayer;

import org.junit.jupiter.api.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

class InstructionParserTest {

    @Test
    void parseTest_SingleInstruction() {
        String input = "L";
        List<Instruction> expected = new ArrayList<>();
        expected.add(Instruction.L);
        List<Instruction> actual = InstructionParser.parse(input);
        assertEquals(expected, actual);
    }

    @Test
    void parseTest_MultipleInstructions() {
        String input = "LMRMMR";
        List<Instruction> expected = new ArrayList<>();
        expected.add(Instruction.L);
        expected.add(Instruction.M);
        expected.add(Instruction.R);
        expected.add(Instruction.M);
        expected.add(Instruction.M);
        expected.add(Instruction.R);
        List<Instruction> actual = InstructionParser.parse(input);
        assertEquals(expected, actual);
    }

    @Test
    void parseTest_InvalidInstructions() {

        String[] inputs = {"FFEDBE",
                "LM23RF",
                "23._LLW",
                "",
                "l M r R"};

        String exceptionMessage = "Input must only contain 'L', 'M' or 'R'. No other characters including whitespace are allowed. ";

        for( String input : inputs){
            Exception exception = assertThrows(IllegalArgumentException.class, () -> InstructionParser.parse(input));
            assertEquals(exceptionMessage, exception.getMessage());
        }
    }


    @Test
    void parseTest_NullInput() {
        String input = null;
        assertNull(InstructionParser.parse(input));
    }

    @Test
    void parseTest_LowercaseInstructions() {
        String input = "lmrmmr";
        List<Instruction> expected = new ArrayList<>();
        expected.add(Instruction.L);
        expected.add(Instruction.M);
        expected.add(Instruction.R);
        expected.add(Instruction.M);
        expected.add(Instruction.M);
        expected.add(Instruction.R);
        List<Instruction> actual = InstructionParser.parse(input);
        assertEquals(expected, actual);
    }

    @Test
    void parseTest_MixedCaseInstructions() {
        String input = "lmrMMrLL";
        List<Instruction> expected = new ArrayList<>();
        expected.add(Instruction.L);
        expected.add(Instruction.M);
        expected.add(Instruction.R);
        expected.add(Instruction.M);
        expected.add(Instruction.M);
        expected.add(Instruction.R);
        expected.add(Instruction.L);
        expected.add(Instruction.L);
        List<Instruction> actual = InstructionParser.parse(input);
        assertEquals(expected, actual);
    }

}