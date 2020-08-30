package by.balashevich.shapeapp.repository.impl;

import by.balashevich.shapeapp.entity.Quadrangle;
import by.balashevich.shapeapp.repository.Specification;

public class QuadranglePositiveQuadrantSpecification implements Specification {

    @Override
    public boolean test(Quadrangle quadrangle) {

        return quadrangle.getPointA().getCoordinateX() >= 0 && quadrangle.getPointA().getCoordinateY() >= 0
                && quadrangle.getPointB().getCoordinateX() >= 0 && quadrangle.getPointB().getCoordinateY() >= 0
                && quadrangle.getPointC().getCoordinateX() >= 0 && quadrangle.getPointC().getCoordinateY() >= 0
                && quadrangle.getPointD().getCoordinateX() >= 0 && quadrangle.getPointD().getCoordinateY() >= 0;
    }
}
