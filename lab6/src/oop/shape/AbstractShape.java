package oop.shape;
import java.awt.Point;

public abstract class AbstractShape implements Computable, Movable, Resizable {

    protected String id;
    protected String color;
    protected AbstractShape(String id, String color) {
        this.id = id;

        setColor(color);
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getColor() { return color; }
    public void setColor(String color) {

        if (!color.matches("^#[0-9A-Fa-f]{6}")) {

            throw new IllegalArgumentException("Invalid RGB color");
        }
        this.color = color;
    }

    @Override public abstract double getArea();
    @Override public abstract double getPerimeter();
    @Override public abstract void move(Point p);
    @Override public abstract void resize(double s);

}
