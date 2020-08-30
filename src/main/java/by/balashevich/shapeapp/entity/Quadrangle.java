package by.balashevich.shapeapp.entity;

import by.balashevich.shapeapp.observer.Observable;
import by.balashevich.shapeapp.observer.Observer;
import by.balashevich.shapeapp.observer.QuadrangleEvent;
import by.balashevich.shapeapp.observer.impl.QuadrangleObserver;

import java.util.EventObject;

public class Quadrangle extends Shape implements Observable {
    private Point pointA;
    private Point pointB;
    private Point pointC;
    private Point pointD;
    private Observer observer;

    public Quadrangle(Point pointA, Point pointB, Point pointC, Point pointD) {
        super();
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        this.pointD = pointD;
        this.observer = new QuadrangleObserver();
    }

    public Point getPointA() {
        return pointA;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
        notifyObserver();
    }

    public Point getPointB() {
        return pointB;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
        notifyObserver();
    }

    public Point getPointC() {
        return pointC;
    }

    public void setPointC(Point pointC) {
        this.pointC = pointC;
        notifyObserver();
    }

    public Point getPointD() {
        return pointD;
    }

    public void setPointD(Point pointD) {
        this.pointD = pointD;
        notifyObserver();
    }

    @Override
    public void notifyObserver() {
        EventObject eventObject = new QuadrangleEvent(this);
        observer.actionPerformed(eventObject);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Quadrangle quadrangle = (Quadrangle) obj;

        return super.equals(obj)
                && pointA.equals(quadrangle.pointB)
                && pointB.equals(quadrangle.pointB)
                && pointC.equals(quadrangle.pointC)
                && pointD.equals(quadrangle.pointD);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result += super.hashCode();
        result += 37 * result + pointA.hashCode();
        result += 37 * result + pointB.hashCode();
        result += 37 * result + pointC.hashCode();
        result += 37 * result + pointD.hashCode();

        return result;
    }

    @Override
    public String toString() {
        return String.format("Quadrangle %s: A - %s; B - %s; C - %s; D - %s",
                super.toString(), pointA, pointB, pointC, pointD);
    }
}
