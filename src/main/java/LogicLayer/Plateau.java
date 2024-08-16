package LogicLayer;

import InputLayer.PlateauSize;
import InputLayer.PlateauSizeParser;

public class Plateau {
    private PlateauSize plateauSize;

    private static final Plateau instance = new Plateau();

    private Plateau() {
    };

    public static Plateau getInstance() {
        return instance;
    }

    public void setPlateauSize(String input){
        plateauSize = PlateauSizeParser.parse(input);
    }


    public PlateauSize getPlateauSize() {
        return plateauSize;
    }
}
