package by.balashevich.shapeapp.specification.impl;

import by.balashevich.shapeapp.entity.Quadrangle;
import by.balashevich.shapeapp.specification.Specification;

public class QuadrangleIdSpecification implements Specification {
    private long quadrangleId;

    public QuadrangleIdSpecification(long quadrangleId) {
        this.quadrangleId = quadrangleId;
    }

    @Override
    public boolean test(Quadrangle quadrangle) {
        return quadrangleId == quadrangle.getId();
    }
}
