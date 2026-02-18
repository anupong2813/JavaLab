package store;

public class Manager extends AbstractStoreEmployee {
    private double bonusRate;
    private double salesDone;
    private double totalStoreSales;

    public Manager(double numberOfHoursWorked, double hourlyRate, String storeDetails, double basePay, String employeeName, double salesDone, double totalStoreSales) {
        super(numberOfHoursWorked, hourlyRate, storeDetails, basePay, employeeName);
        this.bonusRate = 0; // ค่าเริ่มต้น
        this.salesDone = salesDone;
        this.totalStoreSales = totalStoreSales;
    }

    @Override
    public double calculatePay() {
        if (salesDone > 25000) {
            bonusRate = 15.00;
        } else if (salesDone > 5000 && salesDone <= 25000) {
            bonusRate = 10.00;
        } else {
            bonusRate = 1.0;
        }
        // สูตรคำนวณ: (ชั่วโมง * เรท) + เงินต้น + (เงินต้น * โบนัส%)
        return (getNumberOfHoursWorked() * getHourlyRate()) + getBasePay() + (getBasePay() * (bonusRate / 100));
    }

    @Override
    public boolean checkPromotionEligibility() {
        if (calculatePay() > 50000.0) {
            return true;
        } else {
            return false;
        }
    }

    // Getter และ Setter (พิมพ์ให้ครบตามรูปครับ)
    public double getBonusRate() { return bonusRate / 100; }
    public double getSalesDone() { return salesDone; }
    public double getTotalStoreSales() { return totalStoreSales; }

    public void setBonusRate(double bonusRate) { this.bonusRate = bonusRate; }
    public void setSalesDone(double salesDone) { this.salesDone = salesDone; }
    public void setTotalStoreSales(double totalStoreSales) { this.totalStoreSales = totalStoreSales; }

    public double salesPercentByManager() {
        return (salesDone / totalStoreSales) * 100;
    }

    @Override
    public String toString() {
        return super.toString() + "Total Sales in store: $" + totalStoreSales + " \nSales done: $" + salesDone;
    }
}