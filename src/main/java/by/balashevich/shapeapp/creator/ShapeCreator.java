package by.balashevich.shapeapp.creator;

import by.balashevich.shapeapp.entity.Shape;
import by.balashevich.shapeapp.exception.ShapeProjectException;

import java.util.List;
import java.util.Optional;

public interface ShapeCreator<T extends Shape> {
    List<T> createShapes(List<List<Double>> shapesData) throws ShapeProjectException;

    Optional<T> createShape(List<Double> shapeData);
}
