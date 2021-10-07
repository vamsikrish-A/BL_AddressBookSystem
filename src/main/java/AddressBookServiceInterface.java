import java.util.ArrayList;
import java.util.Hashtable;
/*
using interface we achieve Abstraction , so that we can have
multiple inheritance by using same methods in different class
*/
public interface AddressBookServiceInterface {
    abstract Hashtable<String, ArrayList<AddressBook>> insertContactDetails();

    Hashtable<String, ArrayList<AddressBook>> inserContactDetails();

    abstract void displayCompanyContacts(Hashtable<String, ArrayList<AddressBook>>addressBook);
    abstract void editContactDetails(String replacedContact, Hashtable<String, ArrayList<AddressBook>>addressBook);
    abstract void updateContact(String addressBookName, Hashtable<String ,ArrayList<AddressBook>>addressBook);
    abstract boolean findContact(String addressBookName, Hashtable<String ,ArrayList<AddressBook>>addressBook);
    abstract void deleteContact(String addressBookName, Hashtable<String ,ArrayList<AddressBook>>addressBook);
}
