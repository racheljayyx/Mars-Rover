package InputLayer;

public class PlateauSizeParser {
    // takes a string
    // returns a PlateauSize object

    public static PlateauSize parse(String input){
        int x_dimension;
        int y_dimension;

        if (input == null) return null;
        String[] splitStr = input.split(" ");


       if (splitStr.length != 2) {
            throw new IllegalArgumentException("Input must contain two integers separated by a whitespace.");
        }

        try{
            x_dimension = Integer.parseInt(splitStr[0]);
            y_dimension = Integer.parseInt(splitStr[1]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Input must contain two integers separated by a whitespace.");
        }

        if (x_dimension <= 0 || y_dimension <= 0 ){
            throw new IllegalArgumentException("Input must contain two integers separated by a whitespace.");
        }

        return new PlateauSize(x_dimension, y_dimension);

    }
}
