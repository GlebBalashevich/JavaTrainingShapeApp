package by.balashevich.shapeapp.parser;

import by.balashevich.shapeapp.exception.ShapeProjectException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class EntityParserTest {
    EntityParser entityParser;

    @BeforeTest
    public void setUp() {
        entityParser = new EntityParser();
    }

    @Test
    public void parseQuadranglesTest() {
        List<String> quadranglesData = new ArrayList<>();
        quadranglesData.add("7.7");
        quadranglesData.add("5.0 9.0; 6.0 7.0; 2.0 3.0; 9.0 2.0");
        quadranglesData.add("3.54.9; 5.5 4.9;3.5-2.0; 5.5 -2.0");
        quadranglesData.add("10.0,10.0; 15.0,15.0; 20.0,10.0; 15.0,5.0");
        quadranglesData.add("8.0 -3.0; 8.0 -7.0; 8.0 17.0; 3.0 -8.0");
        List<List<Double>> expected = new ArrayList<>();
        List<Double> quadrangleData1 = new ArrayList<>(Arrays.asList(5.0, 9.0, 6.0, 7.0, 2.0, 3.0, 9.0, 2.0));
        List<Double> quadrangleData2 = new ArrayList<>(Arrays.asList(8.0, -3.0, 8.0, -7.0, 8.0, 17.0, 3.0, -8.0));
        expected.add(quadrangleData1);
        expected.add(quadrangleData2);
        List<List<Double>> actual = entityParser.parseQuadrangles(quadranglesData);

        assertEquals(actual, expected);
    }

    @DataProvider(name = "quadrangleData")
    public Object[][] createQuadrangleData() {
        return new Object[][]{
                {"1.0 2.0; 3.0 4.0; 5.0 6.0; 7.0 8.0", new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0))},
                {"1.0 2.0; 3.0 4.0;", new ArrayList<>()},
                {"-1.0 -2.0; -3.0 -4.0; -5.0 -6.0; -7.0 -8.0", new ArrayList<>(Arrays.asList(-1.0, -2.0, -3.0, -4.0, -5.0, -6.0, -7.0, -8.0))},
                {"-1.0a -2.0b; -3.0c -4.0d; -5.0 -6.0; -7.0 -8.0", new ArrayList<>()}
        };
    }

    @Test(dataProvider = "quadrangleData")
    public void parseQuadrangleTest(String quadrangleTextData, List<Double> expected) {
        List<Double> actual = entityParser.parseQuadrangle(quadrangleTextData);

        assertEquals(actual, expected);
    }

    @DataProvider(name = "pointData")
    public Object[][] createPointData() {
        return new Object[][]{
                {"4.0 7.0", new ArrayList<>(Arrays.asList(4.0, 7.0))},
                {"-4.0 167.0", new ArrayList<>(Arrays.asList(-4.0, 167.0))},
                {"0.0 0.0", new ArrayList<>(Arrays.asList(0.0, 0.0))},
        };
    }

    @Test(dataProvider = "pointData")
    public void parsePointTest(String pointTextData, List<Double> expected) throws ShapeProjectException {
        List<Double> actual = entityParser.parsePoint(pointTextData);

        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ShapeProjectException.class)
    public void parsePointTestException() throws ShapeProjectException {
        entityParser.parsePoint("4.0");
    }
}