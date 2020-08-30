package by.balashevich.shapeapp.service.impl;

import by.balashevich.shapeapp.entity.Point;
import by.balashevich.shapeapp.entity.Quadrangle;
import by.balashevich.shapeapp.entity.QuadrangleType;
import by.balashevich.shapeapp.service.ShapeService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class QuadrangleService implements ShapeService<Quadrangle> {
    private static Logger logger = LogManager.getLogger();

    @Override
    public double calculateArea(Quadrangle quadrangle) {
        double area = 0;

        if (isQuadrangleConvex(quadrangle)) {
            double abSide = calculateSegment(quadrangle.getPointA(), quadrangle.getPointB());
            double bcSide = calculateSegment(quadrangle.getPointB(), quadrangle.getPointC());
            double cdSide = calculateSegment(quadrangle.getPointC(), quadrangle.getPointD());
            double daSide = calculateSegment(quadrangle.getPointD(), quadrangle.getPointA());
            double acDiagonal = calculateSegment(quadrangle.getPointA(), quadrangle.getPointC());

            double abcHalfPerimeter = (abSide + bcSide + acDiagonal) / 2;
            double abcTriangleArea = Math.sqrt(abcHalfPerimeter
                    * (abcHalfPerimeter - abSide) * (abcHalfPerimeter - bcSide) * (abcHalfPerimeter - acDiagonal));
            double acdHalfPerimeter = (acDiagonal + cdSide + daSide) / 2;
            double acdTriangleArea = Math.sqrt(acdHalfPerimeter
                    * (acdHalfPerimeter - acDiagonal) * (acdHalfPerimeter - cdSide) * (acdHalfPerimeter - daSide));

            area = abcTriangleArea + acdTriangleArea;
            logger.log(Level.INFO, "quadrangle {} area is {}", quadrangle.getId(), area);
        } else{
            logger.log(Level.INFO, "quadrangle {} area can t be counted", quadrangle.getId());
        }

        return area;
    }

    @Override
    public double calculatePerimeter(Quadrangle quadrangle) {
        double perimeter = 0;

        perimeter += calculateSegment(quadrangle.getPointA(), quadrangle.getPointB());
        perimeter += calculateSegment(quadrangle.getPointB(), quadrangle.getPointC());
        perimeter += calculateSegment(quadrangle.getPointC(), quadrangle.getPointD());
        perimeter += calculateSegment(quadrangle.getPointD(), quadrangle.getPointA());
        logger.log(Level.INFO, "quadrangle {} perimeter is {}", quadrangle.getId(), perimeter);

        return perimeter;
    }

    public boolean isQuadrangleConvex(Quadrangle quadrangle) {
        boolean isConvex = false;

        double abSide = calculateSegment(quadrangle.getPointA(), quadrangle.getPointB());
        double bcSide = calculateSegment(quadrangle.getPointB(), quadrangle.getPointC());
        double cdSide = calculateSegment(quadrangle.getPointC(), quadrangle.getPointD());
        double daSide = calculateSegment(quadrangle.getPointD(), quadrangle.getPointA());

        if (abSide != cdSide) {
            if (quadrangle.getPointA().getCoordinateY() == quadrangle.getPointB().getCoordinateY()
                    && quadrangle.getPointC().getCoordinateY() == quadrangle.getPointD().getCoordinateY()) {
                isConvex = true;
            }
        }
        if (bcSide != daSide) {
            if (quadrangle.getPointA().getCoordinateX() == quadrangle.getPointD().getCoordinateX()
                    && quadrangle.getPointB().getCoordinateX() == quadrangle.getPointC().getCoordinateX()) {
                isConvex = true;
            }
        }
        logger.log(Level.INFO, "quadrangle {} is convex: {}", quadrangle.getId(), isConvex);

        return isConvex;
    }

    public QuadrangleType determineQuadrangleType(Quadrangle quadrangle) {
        QuadrangleType type = QuadrangleType.UNKNOWN;

        double abSide = calculateSegment(quadrangle.getPointA(), quadrangle.getPointB());
        double bcSide = calculateSegment(quadrangle.getPointB(), quadrangle.getPointC());
        double cdSide = calculateSegment(quadrangle.getPointC(), quadrangle.getPointD());
        double daSide = calculateSegment(quadrangle.getPointD(), quadrangle.getPointA());

        if (abSide == bcSide && bcSide == cdSide && cdSide == daSide) {
            if (quadrangle.getPointA().getCoordinateX() == quadrangle.getPointD().getCoordinateX()
                    && quadrangle.getPointA().getCoordinateY() == quadrangle.getPointB().getCoordinateY()) {
                type = QuadrangleType.SQUARE;
            }
        }
        if (abSide == bcSide && bcSide == cdSide && cdSide == daSide) {
            if (quadrangle.getPointA().getCoordinateY() == quadrangle.getPointC().getCoordinateY()
                    && quadrangle.getPointB().getCoordinateX() == quadrangle.getPointD().getCoordinateX()) {
                type = QuadrangleType.RHOMBUS;
            }
        }
        if (abSide != cdSide) {
            if (quadrangle.getPointA().getCoordinateY() == quadrangle.getPointB().getCoordinateY()
                    && quadrangle.getPointC().getCoordinateY() == quadrangle.getPointD().getCoordinateY()) {
                type = QuadrangleType.TRAPEZE;
            }
        }
        if (bcSide != daSide) {
            if (quadrangle.getPointA().getCoordinateX() == quadrangle.getPointD().getCoordinateX()
                    && quadrangle.getPointB().getCoordinateX() == quadrangle.getPointC().getCoordinateX()) {
                type = QuadrangleType.TRAPEZE;
            }
        }
        logger.log(Level.INFO, "quadrangle {} type is: {}", quadrangle.getId(), type);

        return type;
    }

    private double calculateSegment(Point point1, Point point2) {
        double x1 = point1.getCoordinateX();
        double x2 = point2.getCoordinateX();
        double y1 = point1.getCoordinateY();
        double y2 = point2.getCoordinateY();

        return Math.hypot((x1 - x2), (y1 - y2));
    }
}
