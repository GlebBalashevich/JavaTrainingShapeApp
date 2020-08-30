package by.balashevich.shapeapp.repository.impl;

import by.balashevich.shapeapp.entity.Quadrangle;
import by.balashevich.shapeapp.repository.Specification;

public class QuadrangleIdSpecification implements Specification {
    private long quadrangleId;

    public QuadrangleIdSpecification (long quadrangleId){
        this.quadrangleId = quadrangleId;
    }

    @Override
    public boolean test(Quadrangle quadrangle) {
        return quadrangleId == quadrangle.getId();
    }
}
