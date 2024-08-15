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
        String inputOne = "FFEDBE";
        String inputTwo = "LM23RF";
        String inputThree = "23._LLW";
        String inputFour = "";

        String exceptionMessage = "Invalid input. Enter y to try again or n to exit.";

        Exception exceptionOne = assertThrows(IllegalArgumentException.class, () -> InstructionParser.parse(inputOne));
        Exception exceptionTwo = assertThrows(IllegalArgumentException.class, () -> InstructionParser.parse(inputTwo));
        Exception exceptionThree = assertThrows(IllegalArgumentException.class, () -> InstructionParser.parse(inputThree));
        Exception exceptionFour = assertThrows(IllegalArgumentException.class, () -> InstructionParser.parse(inputFour));

        assertEquals(exceptionMessage, exceptionOne.getMessage());
        assertEquals(exceptionMessage, exceptionTwo.getMessage());
        assertEquals(exceptionMessage, exceptionThree.getMessage());
        assertEquals(exceptionMessage, exceptionFour.getMessage());
    }


    @Test
    void parseTest_NullInput() {
        String input = null;
        assertNull(InstructionParser.parse(input));
    }

    @Test
    void parseTest_LowercaseInstructions() {

    }

    @Test
    void parseTest_MixedCaseInstructions() {

    }

}