package InputLayer;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

class PlateauSizeParserTest {

    @Test
    void parseTest_ValidInput() {
        String[] inputs = {
                "5 12",
                "3 6",
                "4 9",
        };

        PlateauSize[] expected = {
                new PlateauSize(5, 12),
                new PlateauSize(3,6),
                new PlateauSize(4, 9)
        };


        for (int i = 0; i < inputs.length; i++) {
            assertEquals(expected[i], PlateauSizeParser.parse(inputs[i]));

        }


    }


    @Test
    void parseTest_InvalidInput() {
        String[] inputs = {
                "5",
                "3 six",
                "-24 5",
                "4 5 6 7",
                "3,4"
        };

        String exceptionMessage = "Input must contain two integers separated by a whitespace.";


        for (String input : inputs) {
            Exception exception = assertThrows(IllegalArgumentException.class, () -> PlateauSizeParser.parse(input));
            assertEquals(exceptionMessage, exception.getMessage());

        }

    }

    @Test
    void parseTest_NullInput() {
        String input = null;
        assertNull(PlateauSizeParser.parse(input));
    }

}