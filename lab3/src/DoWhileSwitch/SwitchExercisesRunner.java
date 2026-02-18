package lab3;

public class SwitchExercisesRunner {
    // เปลี่ยน Main เป็น main
    public static void main(String[] args) {
        System.out.println(isWeekDay(5));
    }

    public static boolean isWeekDay(int dayNumber) {
        switch (dayNumber) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return true;
            default:
                return false;
        }
    }

    public static String determineNameOfDay(int dayNumber) {
        switch (dayNumber) {
            case 0: return "Sunday";
            case 1: return "Monday"; // ในรูปคุณเริ่มที่ case 2 เลยข้ามวันจันทร์ไปครับ
            case 2: return "Tuesday";
            case 3: return "Wednesday";
            case 4: return "Thursday";
            case 5: return "Friday";
            case 6: return "Saturday";
            default: return "Invalid_day";
        }
    }
} // อย่าลืมปิดปีกกา Class