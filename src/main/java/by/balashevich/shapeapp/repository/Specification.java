package by.balashevich.shapeapp.repository;

import by.balashevich.shapeapp.entity.Quadrangle;

import java.util.function.Predicate;

public interface Specification extends Predicate<Quadrangle> {
}
