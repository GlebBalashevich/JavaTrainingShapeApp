package by.balashevich.shapeapp.creator.impl;

import by.balashevich.shapeapp.entity.Point;
import by.balashevich.shapeapp.entity.Quadrangle;
import by.balashevich.shapeapp.exception.ShapeProjectException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.testng.Assert.assertEquals;

public class QuadrangleCreatorTest {
    QuadrangleCreator quadrangleCreator;

    @BeforeTest
    public void setUp() {
        quadrangleCreator = new QuadrangleCreator();
    }

    @Test
    public void createShapesTest() throws ShapeProjectException {
        List<List<Double>> shapesData = new ArrayList<>();
        List<Double> quadranglePointsData1 = new ArrayList<>(Arrays.asList(4.0, 8.0, 7.0, 9.0, 7.0, 3.0, 4.0, 3.0));
        List<Double> quadranglePointsData2 = new ArrayList<>(Arrays.asList(3.5, 4.9, 5.5, 4.9, 3.5, -2.0, 5.5, -2.0));
        List<Double> quadranglePointsData3 = new ArrayList<>(Arrays.asList(10.0, 10.0, 15.0, 15.0, 20.0, 10.0, 15.0, 5.0));
        List<Double> quadranglePointsData4 = new ArrayList<>(Arrays.asList(8.0, -3.0, 8.0, -7.0, 8.0, 17.0, 3.0, -8.0));
        shapesData.add(quadranglePointsData1);
        shapesData.add(quadranglePointsData2);
        shapesData.add(quadranglePointsData3);
        shapesData.add(quadranglePointsData4);
        Quadrangle quadrangle1 = new Quadrangle(1, new Point(4.0, 8.0), new Point(7.0, 9.0),
                new Point(7.0, 3.0), new Point(4.0, 3.0));
        Quadrangle quadrangle2 = new Quadrangle(2, new Point(3.5, 4.9), new Point(5.5, 4.9),
                new Point(3.5, -2.0), new Point(5.5, -2.0));
        Quadrangle quadrangle3 = new Quadrangle(3, new Point(10.0, 10.0), new Point(15.0, 15.0),
                new Point(20.0, 10.0), new Point(15.0, 5.0));
        List<Quadrangle> expected = new ArrayList<>();
        expected.add(quadrangle1);
        expected.add(quadrangle2);
        expected.add(quadrangle3);
        List<Quadrangle> actual = quadrangleCreator.createShapes(shapesData);

        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ShapeProjectException.class)
    public void createShapesTestException() throws ShapeProjectException {
        quadrangleCreator.createShapes(null);
    }

    @DataProvider(name = "shapeData")
    public Object[][] createShapeData() {
        return new Object[][]{
                {new ArrayList<>(Arrays.asList(-3.0, 3.0, 3.0, 2.0, 4.0, -2.0, -2.0, -2.0)), Optional.of(new Quadrangle(1, new Point(-3.0, 3.0), new Point(3.0, 2.0),
                        new Point(4.0, -2.0), new Point(-2.0, -2.0)))},
                {new ArrayList<>(Arrays.asList(-3.0, 3.0, 3.0, 3.0, 7.0, 3.0, -2.0, -2.0)), Optional.empty()},
                {new ArrayList<>(), Optional.empty()},
                {new ArrayList<>(Arrays.asList(-3.0, 3.0, 3.0, 2.0, 4.0, -2.0, -2.0, -2.0, 9.0, 8.0)), Optional.empty()}
        };
    }

    @Test(dataProvider = "shapeData")
    public void createShapeTest(List<Double> shapePointsData, Optional<Quadrangle> expected) {
        Optional<Quadrangle> actual = quadrangleCreator.createShape(shapePointsData);

        assertEquals(actual, expected);
    }
}