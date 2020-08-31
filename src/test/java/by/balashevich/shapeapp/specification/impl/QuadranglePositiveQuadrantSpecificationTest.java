package by.balashevich.shapeapp.specification.impl;

import by.balashevich.shapeapp.entity.Point;
import by.balashevich.shapeapp.entity.Quadrangle;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class QuadranglePositiveQuadrantSpecificationTest {
    QuadranglePositiveQuadrantSpecification quadrantSpecification;

    @BeforeTest
    public void setUp() {
        quadrantSpecification = new QuadranglePositiveQuadrantSpecification();
    }

    @DataProvider(name = "positiveQuadrantSpecificationData")
    public Object[][] createIdSpecificationData() {
        return new Object[][]{
                {new Quadrangle(1, new Point(2, 4), new Point(7, 6),
                        new Point(9, 2), new Point(3, 1)), true},
                {new Quadrangle(3, new Point(-5, -3), new Point(-2, -3),
                        new Point(-1, -7), new Point(-6, -9)), false},
                {new Quadrangle(5, new Point(-2, 2), new Point(3, 4),
                        new Point(5, -4), new Point(-3, 3)), false},
        };
    }

    @Test(dataProvider = "positiveQuadrantSpecificationData")
    public void testMethodTest(Quadrangle quadrangle, boolean expected) {
        boolean actual = quadrantSpecification.test(quadrangle);

        assertEquals(actual, expected);
    }
}