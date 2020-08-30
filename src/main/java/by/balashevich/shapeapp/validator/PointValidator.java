package by.balashevich.shapeapp.validator;

public class PointValidator {
    private static final String DOUBLE_VALUE = "\\p{Pd}?\\d+\\.\\d+";
    private static final String POINT_VALUE = DOUBLE_VALUE + "\\s" + DOUBLE_VALUE;
    private static final int MAX_FLATNESS_VALUE = 100;
    private static final int MIN_FLATNESS_VALUE = -100;

    public boolean isPointDataCorrect(String testData) {

        return testData.matches(POINT_VALUE);
    }

    public boolean isPointCoordinatesCorrect(double coordinateX, double coordinateY){

        return (coordinateX >= MIN_FLATNESS_VALUE && coordinateX <= MAX_FLATNESS_VALUE)
                && (coordinateY >= MIN_FLATNESS_VALUE && coordinateY <= MAX_FLATNESS_VALUE);
    }
}
