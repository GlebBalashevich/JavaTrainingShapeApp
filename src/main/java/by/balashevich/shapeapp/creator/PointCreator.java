package by.balashevich.shapeapp.creator;

import by.balashevich.shapeapp.entity.Point;
import by.balashevich.shapeapp.exception.ShapeProjectException;
import by.balashevich.shapeapp.validator.PointValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PointCreator {
    private static Logger logger = LogManager.getLogger();

    public List<Point> createPoints(List<Double> pointsData) throws ShapeProjectException {
        List<Point> pointList = new ArrayList<>();

        if (pointsData != null && !pointsData.isEmpty()) {
            for (int i = 0; i < pointsData.size() - 1; i+= 2) {
                Optional<Point> point = createPoint(pointsData.get(i), pointsData.get(i + 1));
                point.ifPresent(pointList::add);
            }
        } else{
            throw new ShapeProjectException("Incorrect data for points creation");
        }

        return pointList;
    }

    public Optional<Point> createPoint(double coordinateX, double coordinateY) {
        PointValidator validator = new PointValidator();
        Optional<Point> point = Optional.empty();

        if (validator.isPointCoordinatesCorrect(coordinateX, coordinateY)) {
            point = Optional.of(new Point(coordinateX, coordinateY));
        }

        return point;
    }
}
