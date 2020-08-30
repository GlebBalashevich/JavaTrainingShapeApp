package by.balashevich.shapeapp.entity;

import by.balashevich.shapeapp.util.IdGenerator;

public abstract class Shape {
    private long id;

    public Shape() {
        this.id = IdGenerator.generateId();
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null || obj.getClass() != getClass()){
            return false;
        }

        Shape shape = (Shape) obj;
        return id == shape.id;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result += 37 * result + Long.valueOf(id).hashCode();

        return result;
    }

    @Override
    public String toString() {
        return String.format("id %d", id);
    }
}
