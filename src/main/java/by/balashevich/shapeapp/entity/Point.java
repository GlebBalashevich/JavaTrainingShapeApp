package by.balashevich.shapeapp.entity;

public class Point {
    private double coordinateX;
    private double coordinateY;

    public Point(double coordinateX, double coordinateY) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public double getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(double coordinateX) {
        this.coordinateX = coordinateX;
    }

    public double getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(double coordinateY) {
        this.coordinateY = coordinateY;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Point point = (Point) obj;

        return coordinateX == point.coordinateX
                && coordinateY == point.coordinateY;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result += 37 * result + Double.valueOf(coordinateX).hashCode();
        result += 37 * result + Double.valueOf(coordinateY).hashCode();

        return result;
    }

    @Override
    public String toString() {
        return String.format("(%.1f;%.1f)", coordinateX, coordinateY);
    }
}
