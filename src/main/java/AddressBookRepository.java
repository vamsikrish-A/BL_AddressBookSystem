import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBookRepository implements AddressBookServiceInterface {
    Scanner input = new Scanner(System.in);
    Hashtable<String, ArrayList<AddressBook>> addressBook = new Hashtable<>();
    AddressBook addBook = null;
    ArrayList<AddressBook> aBook = new ArrayList<>();

    @Override
    public Hashtable<String, ArrayList<AddressBook>> insertContactDetails() {
        return null;
    }
/* here Overriding interface methods to insert.
* addressBookName will the key value here, rest all to arraylist<AddressBook>.
* ArrayList value maps the addressBookName key .
* checking the Duplicate values   */
    public Hashtable<String, ArrayList<AddressBook>> inserContactDetails() {
        boolean found = false;

        addBook = new AddressBook();
        System.out.println("Enter AddressBook name: ");
        String addressBookName = input.next();
        System.out.println("Enter firstName: ");
        addBook.setFirst_name(input.next());
        System.out.println("Enter Lastname: ");
        addBook.setLast_name(input.next());
        System.out.println("Enter Address : ");
        addBook.setAddress(input.next());
        System.out.println("Enter city : ");
        addBook.setAddress(input.next());
        System.out.println("Enter State : ");
        addBook.setState(input.next());
        System.out.println("Enter Zip : ");
        addBook.setZip(input.nextInt());
        System.out.println("Enter phone Number: ");
        addBook.setPhone_number(input.next());
        System.out.println("Enter Email : ");
        addBook.setEmail(input.next());

        if (addressBook.containsKey(addressBookName)) {
            ArrayList<AddressBook> value = addressBook.get(addressBookName);
            for (int i = 0; i < value.size(); i++) {
                List<String> names = value.stream().map(person -> person.getFirst_name()).collect(Collectors.toList());
                for (int k = 0; k < names.size(); k++) {
                    if (names.get(i).equals(addBook.getFirst_name())) {
                        found = true;
                        break;
                    }
                }
            }
            if (found == true)
                System.out.println("\n Duplicate Firstname in AddressBook");
            else {
                value.add(addBook);
                addressBook.put(addressBookName, value);
            }
        } else {
            aBook = new ArrayList<>();
            aBook.add(addBook);
            addressBook.put(addressBookName,aBook);
        }
        return addressBook;
    }
/*Overriding interface method to display contact.*/
    @Override
    public void displayCompanyContacts(Hashtable<String, ArrayList<AddressBook>> addressBook) {
        addressBook.keySet().forEach(entry -> {
            System.out.println(entry+"-->"+addressBook.get(entry)+"\n");
        });

    }
    /* editing addressBook */

    @Override
    public void editContactDetails(String addressBookName, Hashtable<String, ArrayList<AddressBook>> addressBook) {
        System.out.println("\nEnter the first name you want to edit the details for : ");
        String fName = input.next();

        ArrayList<AddressBook> value = addressBook.get(addressBookName);
        for (int j = 0; j < value.size(); j++) {
            if (value.get(j).getFirst_name().equals(fName)) {
                System.out.println("Choose your edit option: ");
                System.out.println("1. Last Name");
                System.out.println("2. Address");
                System.out.println("3. City");
                System.out.println("4. State");
                System.out.println("5. Zip");
                System.out.println("6. Phone Number");
                System.out.println("7. Email");
                int editOption = input.nextInt();

                switch (editOption) {
                    case 1 :
                        System.out.println("Enter new lastName: ");
                        value.get(j).setLast_name(input.next());
                        break;
                    case 2:
                        System.out.println("Enter new Address: ");
                        value.get(j).setAddress(input.next());
                        break;
                    case 3:
                        System.out.println("Enter new City: ");
                        value.get(j).setCity(input.next());
                        break;
                    case 4:
                        System.out.println("Enter new State: ");
                        value.get(j).setState(input.next());
                        break;
                    case 5:
                        System.out.println("Enter new Zip: ");
                        value.get(j).setZip(input.nextInt());
                        break;
                    case 6:
                        System.out.println("Enter new Phone Number: ");
                        value.get(j).setPhone_number(input.next());
                        break;
                    case 7:
                        System.out.println("Enter new Email: ");
                        value.get(j).setEmail(input.next());
                        break;
                }
                System.out.println("\n updated successfully! \n");
                break;
            }
            else
                System.out.println("\n No FirstName Found!! \n");
        }
    }
/* updating a contact using editContact*/
    @Override
    public void updateContact(String addressBookName, Hashtable<String, ArrayList<AddressBook>> addressBook) {
        boolean flag = findContact(addressBookName, addressBook);
        if (flag == true) {
            editContactDetails(addressBookName, addressBook);
        } else {
            System.out.println("\n no such AddressBook found.");
        }
    }
/* Finding a contact*/
    @Override
    public boolean findContact(String addressBookName, Hashtable<String, ArrayList<AddressBook>> addressBook) {
        for (int i = 0; i < addressBook.size(); i++) {
            if (addressBook.containsKey(addressBookName))
                return true;
        }
        return false;

    }
/* deletes a contact*/
    @Override
    public void deleteContact(String addressBookName, Hashtable<String, ArrayList<AddressBook>> addressBook) {
        boolean found = false;
        boolean flag = findContact(addressBookName, addressBook);

        if (flag == true) {
            System.out.println("\n Enter the first name want to delete: ");
            String fName = input.next();

            ArrayList<AddressBook> value = addressBook.get(addressBookName);
            for (int i = 0; i < value.size(); i++) {
                if (value.get(i).getFirst_name().equals(fName)) {
                    value.remove(i);
                    found = true;
                    break;
                }
            }
            if (found == true) {
                System.out.println("\n Contact deleted successfully. \n");
            } else
                System.out.println("\n No Such contact found.\n");
        } else
            System.out.println("\n No such AddressBook found. \n");
    }
}
