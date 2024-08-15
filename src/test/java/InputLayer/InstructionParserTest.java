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
        String exceptionMessage = "Invalid input. Enter y to try again or n to exit.";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> InstructionParser.parse(inputOne));
        assertEquals(exceptionMessage, exception.getMessage());
    }

    @Test
    void parseTest_EmptyString() {

    }

    @Test
    void parseTest_NullInput() {

    }

    @Test
    void parseTest_WithWhiteSpaces() {

    }

}