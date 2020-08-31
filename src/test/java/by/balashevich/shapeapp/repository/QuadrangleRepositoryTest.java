package by.balashevich.shapeapp.repository;

import by.balashevich.shapeapp.comparator.QuadrangleComparator;
import by.balashevich.shapeapp.entity.Point;
import by.balashevich.shapeapp.entity.Quadrangle;
import by.balashevich.shapeapp.specification.impl.QuadrangleIdSpecification;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class QuadrangleRepositoryTest {
    QuadrangleRepository quadrangleRepository;
    List<Quadrangle> quadrangleList;
    Quadrangle quadrangleArbitrary;
    Quadrangle quadrangleSquare;
    Quadrangle quadrangleTrapezeH;
    Quadrangle quadrangleTrapezeV;
    Quadrangle quadrangleRhombus;

    @BeforeTest
    public void setUp() {
        quadrangleRepository = QuadrangleRepository.getInstance();
        quadrangleList = new ArrayList<>();
        quadrangleArbitrary = new Quadrangle(1, new Point(2, 4), new Point(7, 6),
                new Point(9, 2), new Point(3, 1));
        quadrangleSquare = new Quadrangle(2, new Point(2, -2), new Point(7, -2),
                new Point(7, -7), new Point(2, -7));
        quadrangleTrapezeH = new Quadrangle(3, new Point(-5, 3), new Point(-2, 3),
                new Point(-1, 1), new Point(-6, 1));
        quadrangleTrapezeV = new Quadrangle(4, new Point(1, 6), new Point(4, 9),
                new Point(4, 1), new Point(1, 3));
        quadrangleRhombus = new Quadrangle(5, new Point(1, 2), new Point(3, 4),
                new Point(5, 2), new Point(3, 0));
    }

    @BeforeMethod
    public void prepareRepository() {
        quadrangleRepository.removeAll();
        quadrangleRepository.add(quadrangleArbitrary);
        quadrangleRepository.add(quadrangleRhombus);
        quadrangleRepository.add(quadrangleSquare);
        quadrangleRepository.add(quadrangleTrapezeH);
        quadrangleRepository.add(quadrangleTrapezeV);
    }

    @Test
    public void addTest() {
        Point pointA = new Point(2, -2);
        Point pointB = new Point(7, -2);
        Point pointC = new Point(7, -7);
        Point pointD = new Point(2, -7);
        Quadrangle quadrangle = new Quadrangle(pointA, pointB, pointC, pointD);
        boolean actual = quadrangleRepository.add(quadrangle);

        assertTrue(actual);
    }

    @Test
    public void addAllTest() {
        Point pointA1 = new Point(2, -2);
        Point pointB1 = new Point(7, -2);
        Point pointC1 = new Point(7, -7);
        Point pointD1 = new Point(2, -7);
        Quadrangle quadrangle1 = new Quadrangle(pointA1, pointB1, pointC1, pointD1);
        Point pointA2 = new Point(2, -2);
        Point pointB2 = new Point(7, -2);
        Point pointC2 = new Point(7, -7);
        Point pointD2 = new Point(2, -7);
        Quadrangle quadrangle2 = new Quadrangle(pointA2, pointB2, pointC2, pointD2);
        List<Quadrangle> quadrangleList = new ArrayList<>();
        quadrangleList.add(quadrangle1);
        quadrangleList.add(quadrangle2);
        boolean actual = quadrangleRepository.addAll(quadrangleList);

        assertTrue(actual);
    }

    @Test
    public void removeTest() {
        boolean actual = quadrangleRepository.remove(quadrangleSquare);

        assertTrue(actual);
    }

    @Test
    public void queryTest() {
        List<Quadrangle> expected = new ArrayList<>();
        expected.add(quadrangleTrapezeH);
        long id = quadrangleTrapezeH.getId();
        List<Quadrangle> actual = quadrangleRepository.query(new QuadrangleIdSpecification(id));

        assertEquals(actual, expected);
    }

    @Test
    public void sortTest() {
        List<Quadrangle> expected = new ArrayList<>();
        expected.add(quadrangleSquare);
        expected.add(quadrangleRhombus);
        expected.add(quadrangleTrapezeH);
        expected.add(quadrangleArbitrary);
        expected.add(quadrangleTrapezeV);
        List<Quadrangle> actual = quadrangleRepository.sort(QuadrangleComparator.A_POINT_Y_COORDINATE.getComparator());

        assertEquals(actual, expected);
    }
}