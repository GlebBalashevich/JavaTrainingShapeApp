package by.balashevich.shapeapp.creator;

import by.balashevich.shapeapp.entity.Point;
import by.balashevich.shapeapp.exception.ShapeProjectException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.testng.Assert.assertEquals;

public class PointCreatorTest {
    PointCreator pointCreator;

    @BeforeTest
    public void setUp() {
        pointCreator = new PointCreator();
    }

    @Test
    public void createPointsTest() throws ShapeProjectException {
        List<Double> pointsData = new ArrayList<>(Arrays.asList(4.0, 5.0, 6.0, 8.0, 101.0, 12.0, -200.0, 17.0, -3.0, -5.0));
        List<Point> expected = new ArrayList<>(Arrays.asList(new Point(4.0, 5.0), new Point(6.0, 8.0),
                new Point(-3.0, -5.0)));
        List<Point> actual = pointCreator.createPoints(pointsData);

        assertEquals(actual, expected);
    }

    @DataProvider(name = "pointsDataException")
    public Object[][] createPointsData() {
        return new Object[][]{
                {new ArrayList<>()},
                {null},
                {new ArrayList<>(Arrays.asList(6.0, 7.0, 8.0))},
        };
    }

    @Test(dataProvider = "pointsDataException", expectedExceptions = ShapeProjectException.class)
    public void createPointsTestException(List<Double> pointsData) throws ShapeProjectException {
        pointCreator.createPoints(pointsData);
    }

    @DataProvider(name = "pointData")
    public Object[][] createPointData() {
        return new Object[][]{
                {3.0, 4.0, Optional.of(new Point(3.0, 4.0))},
                {-33.0, -44.0, Optional.of(new Point(-33.0, -44.0))},
                {-200.0, -44.0, Optional.empty()},
                {200.0, -44.0, Optional.empty()},
        };
    }

    @Test(dataProvider = "pointData")
    public void createPointTest(double coordinateX, double coordinateY, Optional<Point> expected) {
        Optional<Point> actual = pointCreator.createPoint(coordinateX, coordinateY);

        assertEquals(actual, expected);
    }
}