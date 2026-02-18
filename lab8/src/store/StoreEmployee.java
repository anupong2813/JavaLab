package store;

public class StoreEmployee extends AbstractStoreEmployee {

    // Constructor: รับค่าและส่งต่อไปให้คลาสแม่
    public StoreEmployee(double numberOfHoursWorked, double hourlyRate, String storeDetails, double basePay, String employeeName) {
        super(numberOfHoursWorked, hourlyRate, storeDetails, basePay, employeeName);
    }

    @Override
    public double calculatePay() {
        // เขียนสูตรคำนวณเงินเดือนตรงนี้ เช่น (ชั่วโมง * เรท) + เงินต้น
        return (getNumberOfHoursWorked() * getHourlyRate()) + getBasePay();
    }

    @Override
    public boolean checkPromotionEligibility() {
        // เขียนเงื่อนไขโปรโมชั่น เช่น ถ้าทำงานเกิน 40 ชม. ได้โปรโมชั่น
        return getNumberOfHoursWorked() > 40;
    }
}