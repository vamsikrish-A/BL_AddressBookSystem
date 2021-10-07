/*
 * @Project : AddressBookSystem using FileIO
 *
 * @created by : Vamsi Krishna A
 * @ 07-10-2021
 */

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class AddressBookSystem {
    static AddressBookService add_Book = new AddressBookService();
    static Scanner input = new Scanner(System.in);
    /*AddressBookSystem controls the all operation in AddressBook  */
    public static void main(String[] args) {
        System.out.println("Welcome to AddressBookSystem.");

        Hashtable<String, ArrayList<AddressBook>> addressBook = new Hashtable<>();
        boolean flag = true;
        int option;
        while (flag) {
            option = UserMenu.menu();
            switch (option) {
                case 1:
                    System.out.println("\n"+"Add a new Address Book");
                    addressBook = add_Book.inserContactDetails();
                    break;
                case 2:
                    System.out.println("\n"+"Enter name of AddressBook that you want to replace:");
                    String addressBookName = input.next();
                    add_Book.updateContact(addressBookName, addressBook);
                    break;
                case 3:
                    System.out.print("\n" + "Enter the name of the Address Book that you want to delete: ");
                    String deleteAddressBookName = input.next();
                    add_Book.deleteContact(deleteAddressBookName, addressBook);

                case 4:
                    System.out.println("\n" +"Display all contacts");
                    add_Book.displayCompanyContacts(addressBook);
                    break;
                default:
                    System.out.println("Something went wrong!!");
            }
        }
    }
}
