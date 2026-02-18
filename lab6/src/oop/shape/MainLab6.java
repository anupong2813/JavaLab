import oop.shape.Circle;
import java.awt.*;
import javax.swing.*;

public class MainLab6 {
    public static void main(String[] args) {
        // ใช้ try-catch เพื่อดักจับ Error เรื่องการใส่รหัสสีผิด (จาก Main ตัวแรก)
        try {
            // 1. สร้าง Object วงกลม (ใช้พิกัด 200, 200 เพื่อให้รูปอยู่กลางหน้าต่าง)
            Circle c1 = new Circle("C001", "#FF0000", new Point(200, 200), 100.0);
            // --- ส่วนแสดงผลข้อความใน Console (Main ตัวแรก) ---
            System.out.println("--- Circle Info ---");
            System.out.println("Original Area: " + c1.getArea());
            // ทดสอบการ resize (Main ตัวแรก)
            c1.resize(0.5); // ลองลดขนาดลงครึ่งหนึ่ง
            System.out.println("Resized Radius: " + c1.getRadius());
            System.out.println("New Area: " + c1.getArea());
            // --- ส่วนสร้างหน้าต่างวาดรูป GUI (Main ตัวล่าสุด) ---
            JFrame frame = new JFrame("Circle Preview");
            frame.setSize(400, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new JPanel() {
                @Override
                public void paint(Graphics g) {
                    // ดึงค่าสีจาก c1 มาใช้ (Main ตัวล่าสุด)
                    g.setColor(Color.decode(c1.getColor()));
                    // คำนวณพิกัดสำหรับวาดรูป (Main ตัวล่าสุด)
                    int r = (int) c1.getRadius();
                    int x = c1.getCenter().x - r;
                    int y = c1.getCenter().y - r;
                    // วาดวงกลมแบบระบายสีทึบ (Main ตัวล่าสุด)
                    g.fillOval(x, y, r * 2, r * 2);
                }
            });
            frame.setVisible(true);
        } catch (Exception e) {
            // ถ้าใส่สีผิด เช่น "Red" แทนที่จะเป็น "#FF0000" จะเด้งมาที่นี่ (Main ตัวแรก)
            System.out.println("Error: " + e.getMessage());
        }
    }
}