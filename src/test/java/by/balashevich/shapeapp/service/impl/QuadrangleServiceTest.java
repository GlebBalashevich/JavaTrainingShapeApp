package by.balashevich.shapeapp.service.impl;

import by.balashevich.shapeapp.entity.Point;
import by.balashevich.shapeapp.entity.Quadrangle;
import by.balashevich.shapeapp.entity.QuadrangleType;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class QuadrangleServiceTest {
    QuadrangleService quadrangleService;

    @BeforeTest
    public void setUp() {
        quadrangleService = new QuadrangleService();
    }

    @DataProvider(name = "quadrangleConvexData")
    public Object[][] createQuadrangleConvexData() {
        return new Object[][]{
                {new Quadrangle(new Point(-3.0, 3.0), new Point(3.0, 2.0),
                        new Point(4.0, -2.0), new Point(-2.0, -2.0)), true},
                {new Quadrangle(new Point(1.0, 2.0), new Point(4.0, 5.0),
                        new Point(7.0, 2.0), new Point(4.0, 3.0)), false},
                {new Quadrangle(new Point(2.0, 4.0), new Point(5.0, 4.0),
                        new Point(5.0, 1.0), new Point(2.0, 1.0)), true},
                {new Quadrangle(new Point(1.0, 3.0), new Point(4.0, 2.0),
                        new Point(7.0, 4.0), new Point(4.0, 0.0)), false},
        };
    }

    @Test(dataProvider = "quadrangleConvexData")
    public void isQuadrangleConvexTest(Quadrangle quadrangle, boolean expected) {
        boolean actual = quadrangleService.isQuadrangleConvex(quadrangle);

        assertEquals(actual, expected);
    }

    @Test
    public void calculateAreaTest() {
        Point pointA = new Point(2, -2);
        Point pointB = new Point(7, -2);
        Point pointC = new Point(7, -7);
        Point pointD = new Point(2, -7);
        Quadrangle quadrangle = new Quadrangle(pointA, pointB, pointC, pointD);
        double actual = quadrangleService.calculateArea(quadrangle);

        assertEquals(actual, 25, 0.001);
    }

    @Test
    public void calculatePerimeterTest() {
        Point pointA = new Point(2, 4);
        Point pointB = new Point(7, 6);
        Point pointC = new Point(9, 2);
        Point pointD = new Point(3, 1);
        Quadrangle quadrangle = new Quadrangle(pointA, pointB, pointC, pointD);
        double actual = quadrangleService.calculatePerimeter(quadrangle);

        assertEquals(actual, 19.102, 0.001);
    }

    @DataProvider(name = "quadrangleTypeData")
    public Object[][] createQuadrangleTypeData() {
        Point pointAArbitrary = new Point(2, 4);
        Point pointBArbitrary = new Point(7, 6);
        Point pointCArbitrary = new Point(9, 2);
        Point pointDArbitrary = new Point(3, 1);
        Point pointASquare = new Point(2, -2);
        Point pointBSquare = new Point(7, -2);
        Point pointCSquare = new Point(7, -7);
        Point pointDSquare = new Point(2, -7);
        Point pointATrapezeH = new Point(-5, 3);
        Point pointBTrapezeH = new Point(-2, 3);
        Point pointCTrapezeH = new Point(-1, 1);
        Point pointDTrapezeH = new Point(-6, 1);
        Point pointATrapezeV = new Point(1, 6);
        Point pointBTrapezeV = new Point(4, 9);
        Point pointCTrapezeV = new Point(4, 1);
        Point pointDTrapezeV = new Point(1, 3);
        Point pointARhombus = new Point(1, 2);
        Point pointBRhombus = new Point(3, 4);
        Point pointCRhombus = new Point(5, 2);
        Point pointDRhombus = new Point(3, 0);
        return new Object[][]{
                {new Quadrangle(pointAArbitrary, pointBArbitrary, pointCArbitrary, pointDArbitrary), QuadrangleType.ARBITRARY},
                {new Quadrangle(pointASquare, pointBSquare, pointCSquare, pointDSquare), QuadrangleType.SQUARE},
                {new Quadrangle(pointATrapezeH, pointBTrapezeH, pointCTrapezeH, pointDTrapezeH), QuadrangleType.TRAPEZE},
                {new Quadrangle(pointATrapezeV, pointBTrapezeV, pointCTrapezeV, pointDTrapezeV), QuadrangleType.TRAPEZE},
                {new Quadrangle(pointARhombus, pointBRhombus, pointCRhombus, pointDRhombus), QuadrangleType.RHOMBUS},
        };
    }

    @Test(dataProvider = "quadrangleTypeData")
    public void determineQuadrangleTypeTest(Quadrangle quadrangle, QuadrangleType expected) {
        QuadrangleType actual = quadrangleService.determineQuadrangleType(quadrangle);

        assertEquals(actual, expected);
    }
}