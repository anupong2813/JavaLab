package oop.shape;
import java.awt.*;

public class Circle extends AbstractShape {
    private Point center;
    private double radius;

    public Circle(String id, String color, Point center, double radius) {
        super(id, color);
        this.center = center;
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }

    @Override
    public double getPerimeter() {
        return radius * 2 * Math.PI;
    }

    @Override
    public void move(Point p) {
        // เลื่อนจุดศูนย์กลางตามพิกัด p ที่ส่งเข้ามา
        center.translate(p.x, p.y);
    }

    @Override
    public void resize(double s) {
        radius *= s;
    }

    // Getter สำหรับดึงค่ารัศมี
    public double getRadius() {
        return radius;
    }

    // --- ส่วนที่เพิ่มเข้าไปเพื่อให้ Run ได้ ---
    // Getter สำหรับดึงค่าจุดศูนย์กลาง (ที่ Main.java เรียกใช้)
    public Point getCenter() {
        return center;
    }
    // ------------------------------------

    @Override
    public String toString() {
        return "Circle{" +
                "id='" + id + '\'' +
                ", color='" + color + '\'' +
                ", radius=" + radius +
                ", center=" + center +
                '}';
    }
}