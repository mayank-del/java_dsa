package tcs_assignment;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

class CustomerProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerManager customerManager = new CustomerManager();

        while (true) {
            System.out.println("Enter 1 to Add Customer, 2 to Update Customer, 3 to Delete Customer, 4 to Select Customers, 0 to Exit:");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    System.out.println("Enter Consumer ID:");
                    int consumerId = scanner.nextInt();
                    System.out.println("Enter Bill Number:");
                    int number8111 = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.println("Enter Title:");
                    String title = scanner.nextLine();
                    System.out.println("Enter Customer Name:");
                    String customerName = scanner.nextLine();
                    System.out.println("Enter Email:");
                    String email = scanner.nextLine();
                    System.out.println("Enter Mobile Number:");
                    String mobileNumber = scanner.nextLine();
                    System.out.println("Enter Password:");
                    String password = scanner.nextLine();
                    System.out.println("Confirm Password:");
                    String confirmPassword = scanner.nextLine();

                    if (!password.equals(confirmPassword)) {
                        System.out.println("Passwords do not match. Registration failed.");
                    } else {
                        customerManager.addCustomer(consumerId, number8111, title, customerName, email, mobileNumber, password);
                    }
                    break;
                case 2:
                    System.out.println("Enter Consumer ID:");
                    int updateConsumerId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.println("Enter new Email:");
                    String newEmail = scanner.nextLine();
                    customerManager.updateCustomer(updateConsumerId, newEmail);
                    break;
                case 3:
                    System.out.println("Enter Consumer ID:");
                    int deleteConsumerId = scanner.nextInt();
                    customerManager.deleteCustomer(deleteConsumerId);
                    break;
                case 4:
                    customerManager.selectCustomers();
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


class Customer {
    private int consumerId;
    private int number8111;
    private String title;
    private String customerName;
    private String email;
    private String mobileNumber;
    private String userId;
    private String password;

    public Customer(int consumerId, int number8111, String title, String customerName, String email, String mobileNumber, String password) {
        this.consumerId = consumerId;
        this.number8111 = number8111;
        this.title = title;
        this.customerName = customerName;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.userId = UUID.randomUUID().toString(); // Random User ID
        this.password = password;
    }

    public int getConsumerId() {
        return consumerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "consumerId=" + consumerId +
                ", number8111=" + number8111 +
                ", title='" + title + '\'' +
                ", customerName='" + customerName + '\'' +
                ", email='" + email + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

class CustomerManager {
    private List<Customer> customers = new ArrayList<>();

    public void addCustomer(int consumerId, int number8111, String title, String customerName, String email, String mobileNumber, String password) {
        Customer customer = new Customer(consumerId, number8111, title, customerName, email, mobileNumber, password);
        customers.add(customer);
        System.out.println("Customer Registration is successful");
    }

    public void updateCustomer(int consumerId, String newEmail) {
        for (Customer customer : customers) {
            if (customer.getConsumerId() == consumerId) {
                customer.setEmail(newEmail);
                System.out.println("Customer details are updated successfully");
                return;
            }
        }
        System.out.println("Customer not found");
    }

    public void deleteCustomer(int consumerId) {
        customers.removeIf(customer -> customer.getConsumerId() == consumerId);
        System.out.println("Customer details are deleted");
    }

    public void selectCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers found");
        } else {
            for (Customer customer : customers) {
                System.out.println(customer);
            }
        }
    }
}

