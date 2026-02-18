interface Switchable {
    void turnOn();
    void turnOff();
}

interface WiFiConnectable {
    void connectNetwork(String ssid);
}

class SmartLight implements Switchable {
    public void turnOn() { System.out.println("Light is ON: Brightness 100%"); }
    public void turnOff() { System.out.println("Light is OFF"); }
}

class SmartTV implements Switchable, WiFiConnectable {
    public void turnOn() { System.out.println("TV is ON: Showing Netflix"); }
    public void turnOff() { System.out.println("TV is OFF"); }
    public void connectNetwork(String ssid) {
        System.out.println("TV is connecting to WiFi: " + ssid);
    }
}

class SmartCam implements Switchable, WiFiConnectable {
    public void turnOn() { System.out.println("Camera Recording..."); }
    public void turnOff() { System.out.println("Camera Stopped"); }
    public void connectNetwork(String ssid) {
        System.out.println("Camera connected to WiFi: " + ssid);
    }
}

public class HomeController {
    public static void main(String[] args) {
        // ส่วนของ Polymorphism (ที่มีในรูปก่อนหน้า)
        Switchable[] devices = { new SmartLight(), new SmartTV() };

        for (Switchable device : devices) {
            device.turnOn();
        }

        // ส่วนที่เพิ่มเข้ามาใหม่ตามรูป SmartCam (รูปสุดท้าย)
        SmartCam cam = new SmartCam();
        cam.connectNetwork("Home_WiFi_5G");
        cam.turnOn();
    }
}