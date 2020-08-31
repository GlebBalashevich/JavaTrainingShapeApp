package by.balashevich.shapeapp.validator;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class PointValidatorTest {
    PointValidator pointValidator;

    @BeforeTest
    public void setUp() {
        pointValidator = new PointValidator();

    }

    @DataProvider(name = "pointData")
    public Object[][] createPointData() {
        return new Object[][]{
                {"4.0 8.0", true},
                {"d 8.0", false},
                {"-12.6 15.2", true},
                {"4.0;8.0", false},
        };
    }

    @Test(dataProvider = "pointData")
    public void isPointDataCorrectTest(String pointData, boolean expected) {
        boolean actual = pointValidator.isPointDataCorrect(pointData);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "pointCoordinates")
    public Object[][] createPointCoordinates() {
        return new Object[][]{
                {5, 10, true},
                {-5, -10, true},
                {-200, 10, false},
                {200, 10, false},
                {10, 200, false},
                {10, -200, false},
        };
    }

    @Test(dataProvider = "pointCoordinates")
    public void isPointCoordinatesCorrectTest(double coordinateX, double coordinateY, boolean expected) {
        boolean actual = pointValidator.isPointCoordinatesCorrect(coordinateX, coordinateY);
        assertEquals(actual, expected);
    }
}