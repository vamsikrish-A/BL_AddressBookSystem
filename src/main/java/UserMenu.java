import java.util.Scanner;

public class UserMenu {
    private static Scanner scanner = new Scanner(System.in);
    public static String getCustomerFirstname() {
        System.out.println("Enter the first name: ");
        return scanner.next();
    }
    public static String getCustomerLastname() {
        System.out.println("Enter the last name: ");
        return scanner.next();
    }
    public static String getCustomerEmailAddress() {
        System.out.println("Enter the Email Address: ");
        return scanner.next();
    }

    public static String getCustomerHomeAddress() {
        System.out.println("Enter the Home Address: ");
        return scanner.next();
    }
    public static String getCustomerCityName() {
        System.out.println("Enter the city name: ");
        return scanner.next();
    }
    public static String getCustomerStateName() {
        System.out.println("Enter the State name: ");
        return scanner.next();
    }
    public static String getCustomerMobileNumber() {
        System.out.println("Enter the Mobile Number: ");
        return scanner.next();
    }
    public static String getCustomerPinCode() {
        System.out.println("Enter the pinCode: ");
        return scanner.next();
    }

    public static int menu() {
        Scanner input = new Scanner(System.in);

        System.out.println("Select option: ");
        System.out.println("1. Add a new contact in the address book.");
        System.out.println("2. Edit contact in the address book.");
        System.out.println("3. Delete contact in the address book.");
        System.out.println("4. Display all values from address book.");
        System.out.println("5. Search Address Book based on City or State.");
        System.out.println("6. Quit.");

        int option = input.nextInt();

        return option;
    }
}
