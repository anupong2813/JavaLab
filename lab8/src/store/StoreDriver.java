package store;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StoreDriver {
    public static void main(String[] args) throws FileNotFoundException {
        int managerCount = 0;

        // สร้างตัวบันทึกและตัวอ่านไฟล์
        // จากเดิมที่เป็น new File("inputFile.txt") ให้แก้เป็น:
        Scanner sc = new Scanner(new File("lab8/src/store/inputFile.txt"));
        PrintWriter pwd = new PrintWriter(new File("lab8/src/store/outputFile.txt"));

        List<Manager> managerList = new ArrayList<>();

        while (sc.hasNext()) {
            String employeeType = sc.next();
            sc.nextLine(); // เคลียร์บรรทัดหลังอ่าน Manager
            String storeDetails = sc.nextLine();
            String empName = sc.nextLine();
            double basePay = sc.nextDouble();
            double numberOfHoursWorked = sc.nextDouble();
            double hourlyRate = sc.nextDouble();

            if (employeeType.equals("Manager")) {
                double currentSales = sc.nextDouble();
                double totalStoreSales = sc.nextDouble();

                // แก้ไข: ปรับลำดับ Parameter ให้ตรงกับ Constructor ของ Manager ที่เราเขียนไว้ก่อนหน้า
                Manager manager = new Manager(numberOfHoursWorked, hourlyRate, storeDetails, basePay, empName, currentSales, totalStoreSales);

                managerList.add(manager);

                // เคลียร์บรรทัดที่ค้างอยู่หลังจากอ่าน double ตัวสุดท้าย
                if (sc.hasNextLine()) {
                    sc.nextLine();
                }
            }
        }

        System.out.println("**************************************************");
        System.out.println("Number of employees working as MANAGER are: " + managerList.size());
        System.out.println("**************************************************");

        pwd.println("**************************************************");
        pwd.println("Number of employees working as MANAGER are: " + managerList.size());
        pwd.println("**************************************************");

        for (Manager manager : managerList) {
            managerCount++;
            System.out.println(managerCount + ". Manager Details:");
            System.out.println(manager);

            pwd.println(managerCount + ". Manager Details:");
            pwd.println(manager);

            // เรียกใช้ Method คำนวณรายได้ร้านค้า
            double remainingRevenue = manager.calculateRemainingStoreRevenue(manager.getTotalStoreSales());
            String revenueMsg = "Remaining store revenue: $" + String.format("%.2f", remainingRevenue);
            System.out.println(revenueMsg);
            pwd.println(revenueMsg);

            // ส่วนตรวจสอบการได้รับโปรโมชั่น
            System.out.print("Is " + manager.getEmployeeName() + " eligible for promotion? ");
            if (manager.checkPromotionEligibility()) {
                System.out.println("Yes, he/she is.");
                pwd.println("Promotion Eligibility: Yes");
            } else {
                System.out.println("No, he/she needs to work harder.");
                pwd.println("Promotion Eligibility: No");
            }

            System.out.println();
            pwd.println();
        }

        pwd.close();
        sc.close();
        System.out.println("All data has been processed and saved to outputFile.txt");
    }
}