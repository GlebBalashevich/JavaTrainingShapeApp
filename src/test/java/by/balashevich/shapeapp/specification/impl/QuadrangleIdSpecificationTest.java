package by.balashevich.shapeapp.specification.impl;

import by.balashevich.shapeapp.entity.Point;
import by.balashevich.shapeapp.entity.Quadrangle;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class QuadrangleIdSpecificationTest {
    QuadrangleIdSpecification quadrangleIdSpecification;

    @DataProvider(name = "idSpecificationData")
    public Object[][] createIdSpecificationData() {
        return new Object[][]{
                {1, new Quadrangle(1, new Point(2, 4), new Point(7, 6),
                        new Point(9, 2), new Point(3, 1)), true},
                {3, new Quadrangle(3, new Point(-5, 3), new Point(-2, 3),
                        new Point(-1, 1), new Point(-6, 1)), true},
                {145, new Quadrangle(5, new Point(1, 2), new Point(3, 4),
                        new Point(5, 2), new Point(3, 0)), false},
        };
    }

    @Test(dataProvider = "idSpecificationData")
    public void testMethodTest(long id, Quadrangle quadrangle, boolean expected) {
        quadrangleIdSpecification = new QuadrangleIdSpecification(id);
        boolean actual = quadrangleIdSpecification.test(quadrangle);

        assertEquals(actual, expected);
    }
}