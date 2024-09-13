package tcs_assignment;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class BillProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BillManager billManager = new BillManager();

        while (true) {
            System.out.println("Enter 1 to Add Bill, 2 to Update Bill, 3 to Delete Bill, 4 to Display Bills, 0 to Exit:");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Enter Consumer Number:");
                    int consumerNumber = scanner.nextInt();
                    System.out.println("Enter Due Amount:");
                    double dueAmount = scanner.nextDouble();
                    System.out.println("Enter Payable Amount:");
                    double payableAmount = scanner.nextDouble();
                    billManager.addBill(consumerNumber, dueAmount, payableAmount);
                    break;

                case 2:
                    System.out.println("Enter Consumer Number:");
                    int updateConsumerNumber = scanner.nextInt();
                    System.out.println("Enter new Due Amount:");
                    double newDueAmount = scanner.nextDouble();
                    System.out.println("Enter new Payable Amount:");
                    double newPayableAmount = scanner.nextDouble();
                    billManager.updateBill(updateConsumerNumber, newDueAmount, newPayableAmount);
                    break;

                case 3:
                    System.out.println("Enter Consumer Number:");
                    int deleteConsumerNumber = scanner.nextInt();
                    billManager.deleteBill(deleteConsumerNumber);
                    break;

                case 4:
                    billManager.displayBills();
                    break;

                case 0:
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
                    break;
            }
        }
    }
}


class Bill {
    private int consumerNumber;
    private double dueAmount;
    private double payableAmount;

    public Bill(int consumerNumber, double dueAmount, double payableAmount) {
        this.consumerNumber = consumerNumber;
        this.dueAmount = dueAmount;
        this.payableAmount = payableAmount;
    }

    public int getConsumerNumber() {
        return consumerNumber;
    }

    public double getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(double dueAmount) {
        this.dueAmount = dueAmount;
    }

    public double getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(double payableAmount) {
        this.payableAmount = payableAmount;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "consumerNumber=" + consumerNumber +
                ", dueAmount=" + dueAmount +
                ", payableAmount=" + payableAmount +
                '}';
    }
}

class BillManager {
    private List<Bill> bills = new ArrayList<>();

    public void addBill(int consumerNumber, double dueAmount, double payableAmount) {
        Bill bill = new Bill(consumerNumber, dueAmount, payableAmount);
        bills.add(bill);
        System.out.println("Bill details are added successfully");
    }

    public void updateBill(int consumerNumber, double newDueAmount, double newPayableAmount) {
        for (Bill bill : bills) {
            if (bill.getConsumerNumber() == consumerNumber) {
                bill.setDueAmount(newDueAmount);
                bill.setPayableAmount(newPayableAmount);
                System.out.println("Bill details are updated successfully");
                return;
            }
        }
        System.out.println("Bill not found");
    }

    public void deleteBill(int consumerNumber) {
        bills.removeIf(bill -> bill.getConsumerNumber() == consumerNumber);
        System.out.println("Bill details are deleted");
    }

    public void displayBills() {
        if (bills.isEmpty()) {
            System.out.println("No bills found");
        } else {
            for (Bill bill : bills) {
                System.out.println(bill);
            }
        }
    }
}


