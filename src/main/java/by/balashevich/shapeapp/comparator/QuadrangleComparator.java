package by.balashevich.shapeapp.comparator;

import by.balashevich.shapeapp.entity.Quadrangle;

import java.util.Comparator;

public enum QuadrangleComparator{
    ID((Quadrangle q1, Quadrangle q2) -> Long.compare(q1.getId(), q2.getId())),
    A_POINT_X_COORDINATE((Quadrangle q1, Quadrangle q2) -> Double.compare(q1.getPointA().getCoordinateX(),
            q2.getPointA().getCoordinateX())),
    A_POINT_Y_COORDINATE((Quadrangle q1, Quadrangle q2) -> Double.compare(q1.getPointA().getCoordinateY(),
            q2.getPointA().getCoordinateY())),
    B_POINT_X_COORDINATE((Quadrangle q1, Quadrangle q2) -> Double.compare(q1.getPointB().getCoordinateX(),
            q2.getPointB().getCoordinateX())),
    B_POINT_Y_COORDINATE((Quadrangle q1, Quadrangle q2) -> Double.compare(q1.getPointB().getCoordinateY(),
            q2.getPointB().getCoordinateY()));

    private Comparator<Quadrangle> comparator;

    QuadrangleComparator(Comparator<Quadrangle> comparator){
        this.comparator = comparator;
    }

    public Comparator<Quadrangle> getComparator(){
        return comparator;
    }
}
