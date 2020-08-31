package by.balashevich.shapeapp.validator;

import by.balashevich.shapeapp.entity.Point;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class QuadrangleValidatorTest {
    QuadrangleValidator quadrangleValidator;

    @BeforeTest
    public void setUp() {
        quadrangleValidator = new QuadrangleValidator();
    }

    @DataProvider(name = "quadrangleData")
    public Object[][] createQuadrangleData() {
        return new Object[][]{
                {"4.0 8.0; 7.0 9.0; 7.0 3.0; 4.0 3.0", true},
                {"4.0 8.0; 7.0 3.0; 4.0 3.0", false},
                {"4.0ad;8.0 7.0;9.0 7.0;3.0 4.0;3.0", false},
                {"8.0 -3.0; 8.0 -7.0; 8.0 17.0; 3.0 -8.0", true},
        };
    }

    @Test(dataProvider = "quadrangleData")
    public void isQuadrangleDataCorrectTest(String quadrangleTextData, boolean expected) {
        boolean actual = quadrangleValidator.isQuadrangleDataCorrect(quadrangleTextData);

        assertEquals(actual, expected);
    }

    @DataProvider(name = "quadrangleExistData")
    public Object[][] createQuadrangleExistData() {
        return new Object[][]{
                {new Point(4, 8), new Point(7, 8), new Point(7, 3), new Point(4, 3), true},
                {new Point(4, 8), new Point(4, 8), new Point(7, 8), new Point(4, 3), false},
                {new Point(4, 8), new Point(7, 8), new Point(7, 8), new Point(4, 3), false},
                {new Point(4, 8), new Point(7, 8), new Point(3, 8), new Point(4, 3), false},
        };
    }

    @Test(dataProvider = "quadrangleExistData")
    public void isQuadrangleExistTest(Point pointA, Point pointB, Point pointC, Point pointD, boolean expected) {
        boolean actual = quadrangleValidator.isQuadrangleExist(pointA, pointB, pointC, pointD);

        assertEquals(actual, expected);
    }
}