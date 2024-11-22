package garmentmanagementsystem;
import java.util.ArrayList;
import java.util.Scanner;

class Garment {
    private int id;
    private String name;
    private String size;
    private double price;

    public Garment(int id, String name, String size, double price) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public void display() {
        System.out.println(id + " | " + name + " | " + size + " | " + price);
    }
}

class GarmentManagement {
    private ArrayList<Garment> garments = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addGarment() {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Size: ");
        String size = scanner.nextLine();
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        garments.add(new Garment(id, name, size, price));
        System.out.println("Garment added successfully.");
    }

    public void displayGarments() {
        if (garments.isEmpty()) {
            System.out.println("No garments available.");
            return;
        }
        System.out.println("ID | Name | Size | Price");
        for (Garment garment : garments) {
            garment.display();
        }
    }

    public void removeGarment() {
        System.out.print("Enter the ID of the garment to remove: ");
        int id = scanner.nextInt();
        garments.removeIf(garment -> garment.getId() == id);
        System.out.println("Garment removed successfully.");
    }

    public void searchGarment() {
        System.out.print("Enter the name of the garment to search: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        boolean found = false;
        for (Garment garment : garments) {
            if (garment.getName().equalsIgnoreCase(name)) {
                garment.display();
                found = true;
            }
        }
        if (!found) System.out.println("Garment not found.");
    }

    public void manage() {
        while (true) {
            System.out.println("1. Add Garment");
            System.out.println("2. Display Garments");
            System.out.println("3. Remove Garment");
            System.out.println("4. Search Garment");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> addGarment();
                case 2 -> displayGarments();
                case 3 -> removeGarment();
                case 4 -> searchGarment();
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}

public class GarmentManagementSystem {
    public static void main(String[] args) {
        GarmentManagement gm = new GarmentManagement();
        gm.manage();
    }
}
