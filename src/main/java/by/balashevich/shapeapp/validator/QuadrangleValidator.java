package by.balashevich.shapeapp.validator;

import by.balashevich.shapeapp.entity.Point;

public class QuadrangleValidator {
    private static final String DOUBLE_VALUE_REGEX = "\\p{Pd}?\\d+\\.\\d+";
    private static final String POINT_VALUE_REGEX = DOUBLE_VALUE_REGEX + "\\s" + DOUBLE_VALUE_REGEX;
    private static final String QUADRANGLE_DATA_REGEX = "(" + POINT_VALUE_REGEX + "\\;\\s){3}" + POINT_VALUE_REGEX + "\\b";

    public boolean isQuadrangleDataCorrect(String testData) {

        return testData.matches(QUADRANGLE_DATA_REGEX);
    }

    public boolean isQuadrangleExist(Point pointA, Point pointB, Point pointC, Point pointD) {
        boolean isExist = false;

        if (!pointA.equals(pointB) && !pointB.equals(pointC) && !pointC.equals(pointD)) {
            double abcLeftEquationPart = (pointA.getCoordinateX() - pointC.getCoordinateX())
                    / (pointB.getCoordinateX() - pointC.getCoordinateX());
            double abcRightEquationPart = (pointA.getCoordinateY() - pointC.getCoordinateY())
                    / (pointB.getCoordinateY() - pointC.getCoordinateY());
            double acdLeftEquationPart = (pointA.getCoordinateX() - pointD.getCoordinateX())
                    / (pointC.getCoordinateX() - pointD.getCoordinateX());
            double acdRightEquationPart = (pointA.getCoordinateY() - pointD.getCoordinateY())
                    / (pointC.getCoordinateY() - pointD.getCoordinateY());
            if (abcLeftEquationPart != abcRightEquationPart && acdLeftEquationPart != acdRightEquationPart) {
                isExist = true;
            }
        }

        return isExist;
    }
}
