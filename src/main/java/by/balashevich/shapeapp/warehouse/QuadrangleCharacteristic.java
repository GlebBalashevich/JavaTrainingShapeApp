package by.balashevich.shapeapp.warehouse;

import by.balashevich.shapeapp.entity.QuadrangleType;

public class QuadrangleCharacteristic {
    private double area;
    private double perimeter;
    private QuadrangleType type;
    private boolean isConvex;

    public QuadrangleCharacteristic() {
    }

    public QuadrangleCharacteristic(double area, double perimeter, QuadrangleType type, boolean isConvex) {
        this.area = area;
        this.perimeter = perimeter;
        this.type = type;
        this.isConvex = isConvex;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public QuadrangleType getType() {
        return type;
    }

    public void setType(QuadrangleType type) {
        this.type = type;
    }

    public boolean isConvex() {
        return isConvex;
    }

    public void setConvex(boolean convex) {
        isConvex = convex;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        QuadrangleCharacteristic parameters = (QuadrangleCharacteristic) obj;

        return area == parameters.area
                && perimeter == parameters.perimeter
                && type == parameters.type
                && isConvex == parameters.isConvex;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result += 37 * result + Double.valueOf(area).hashCode();
        result += 37 * result + Double.valueOf(perimeter).hashCode();
        result += type.hashCode();
        result += 37 * result + (isConvex ? 1 : 0);

        return result;
    }

    @Override
    public String toString() {
        return String.format("Quadrangle characteristic: area %.2f; perimeter %.2f; type %s; isConvex %s",
                area, perimeter, type.name(), isConvex);
    }
}
