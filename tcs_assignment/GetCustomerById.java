package tcs_assignment;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class GetCustomerById {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerManager customerManager = new CustomerManager();

        System.out.println("Enter Consumer ID to display customer details:");
        int consumerId = scanner.nextInt();

        customerManager.displayCustomerDetails(consumerId);
        scanner.close();
    }
}




class Customer {
    private int consumerId;
    private String customerName;
    private String mobileNumber;
    private String email;

    public Customer(int consumerId, String customerName, String mobileNumber, String email) {
        this.consumerId = consumerId;
        this.customerName = customerName;
        this.mobileNumber = mobileNumber;
        this.email = email;
    }

    public int getConsumerId() {
        return consumerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return consumerId + " | " + customerName + " | " + mobileNumber + " | " + email;
    }
}

class CustomerManager {
    private List<Customer> customers;

    public CustomerManager() {
        this.customers = new ArrayList<>();
        // Preconfigured customers
        customers.add(new Customer(101, "John Doe", "9876543210", "john@example.com"));
        customers.add(new Customer(102, "Jane Smith", "9123456789", "jane@example.com"));
        customers.add(new Customer(103, "Bob Brown", "9234567890", "bob@example.com"));
    }

    public void displayCustomerDetails(int consumerId) {
        for (Customer customer : customers) {
            if (customer.getConsumerId() == consumerId) {
                System.out.println("Consumer ID | CustomerName | Mobile Number | Email");
                System.out.println("---------------------------------------------------");
                System.out.println(customer);
                return;
            }
        }
        System.out.println("Customer with Consumer ID " + consumerId + " not found.");
    }
}

