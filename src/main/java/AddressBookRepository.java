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

}
