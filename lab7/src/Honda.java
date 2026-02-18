abstract class Bike {
    // Abstract Method: มีแต่ชื่อ ไม่มีรายละเอียดการทำงาน (body)
    abstract void run();
}

class Honda extends Bike {
    // ต้องเขียนรายละเอียดการทำงานของ run() ให้สมบูรณ์
    @Override
    void run() {
        System.out.println("running safely");
    }

    public static void main(String args[]) {
        // สร้าง Object ของ Honda แต่ใช้ตัวแปรประเภท Bike อ้างอิง
        Bike obj = new Honda();
        obj.run();
    }
}