package tcs_assignment;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Raise_complaint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ComplaintManager complaintManager = new ComplaintManager();

        while (true) {
            System.out.println("Enter 1 to Register Complaint, 2 to Delete Complaint, 3 to Display Complaints, 0 to Exit:");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    System.out.println("Enter Complaint Type:");
                    String complaintType = scanner.nextLine();
                    System.out.println("Enter Category:");
                    String category = scanner.nextLine();
                    System.out.println("Enter Landmark:");
                    String landmark = scanner.nextLine();
                    System.out.println("Enter Customer Name:");
                    String customerName = scanner.nextLine();
                    System.out.println("Enter Problem:");
                    String problem = scanner.nextLine();
                    System.out.println("Enter Consumer Number:");
                    int consumerNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Enter Address:");
                    String address = scanner.nextLine();
                    System.out.println("Enter Mobile Number:");
                    String mobileNumber = scanner.nextLine();

                    complaintManager.registerComplaint(complaintType, category, landmark, customerName, problem, consumerNumber, address, mobileNumber);
                    break;

                case 2:
                    System.out.println("Enter Complaint ID:");
                    int complaintId = scanner.nextInt();
                    complaintManager.deleteComplaint(complaintId);
                    break;

                case 3:
                    complaintManager.displayComplaints();
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


class Complaint {
    private static int complaintCounter = 1; // Auto-incrementing complaint ID
    private int complaintId;
    private String complaintType;
    private String category;
    private String landmark;
    private String customerName;
    private String problem;
    private int consumerNumber;
    private String address;
    private String mobileNumber;

    public Complaint(String complaintType, String category, String landmark, String customerName, String problem, int consumerNumber, String address, String mobileNumber) {
        this.complaintId = complaintCounter++;
        this.complaintType = complaintType;
        this.category = category;
        this.landmark = landmark;
        this.customerName = customerName;
        this.problem = problem;
        this.consumerNumber = consumerNumber;
        this.address = address;
        this.mobileNumber = mobileNumber;
    }

    public int getComplaintId() {
        return complaintId;
    }

    @Override
    public String toString() {
        return "Complaint{" +
                "complaintId=" + complaintId +
                ", complaintType='" + complaintType + '\'' +
                ", category='" + category + '\'' +
                ", landmark='" + landmark + '\'' +
                ", customerName='" + customerName + '\'' +
                ", problem='" + problem + '\'' +
                ", consumerNumber=" + consumerNumber +
                ", address='" + address + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                '}';
    }
}

class ComplaintManager {
    private List<Complaint> complaints = new ArrayList<>();

    public void registerComplaint(String complaintType, String category, String landmark, String customerName, String problem, int consumerNumber, String address, String mobileNumber) {
        Complaint complaint = new Complaint(complaintType, category, landmark, customerName, problem, consumerNumber, address, mobileNumber);
        complaints.add(complaint);
        System.out.println("Successfully registered Complaint");
    }

    public void deleteComplaint(int complaintId) {
        boolean removed = complaints.removeIf(complaint -> complaint.getComplaintId() == complaintId);
        if (removed) {
            System.out.println("Complaint details are deleted");
        } else {
            System.out.println("Complaint not found");
        }
    }

    public void displayComplaints() {
        if (complaints.isEmpty()) {
            System.out.println("No complaints found");
        } else {
            for (Complaint complaint : complaints) {
                System.out.println(complaint);
            }
        }
    }
}
