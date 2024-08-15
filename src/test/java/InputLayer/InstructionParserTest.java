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