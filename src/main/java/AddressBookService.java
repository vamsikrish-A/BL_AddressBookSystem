import java.util.ArrayList;
import java.util.Hashtable;
/*
* implements interface methods*/
public class AddressBookService implements AddressBookServiceInterface {
    AddressBookRepository addressBookRepository = new AddressBookRepository();
    @Override
    public Hashtable<String, ArrayList<AddressBook>> insertContactDetails() {
        return addressBookRepository.insertContactDetails();
    }

    @Override
    public Hashtable<String, ArrayList<AddressBook>> inserContactDetails() {
        return addressBookRepository.inserContactDetails();
    }

    public void displayCompanyContacts(Hashtable<String, ArrayList<AddressBook>> addressBook) {
        addressBookRepository.displayCompanyContacts(addressBook);
    }

    @Override
    public void editContactDetails(String replacedContact, Hashtable<String, ArrayList<AddressBook>> addressBook) {
        addressBookRepository.editContactDetails(replacedContact, addressBook);
    }

    @Override
    public void deleteContact(String deletedName, Hashtable<String, ArrayList<AddressBook>> addressBook) {
        addressBookRepository.deleteContact(deletedName, addressBook);
    }

    @Override
    public boolean findContact(String addressBookName, Hashtable<String, ArrayList<AddressBook>> addressBook) {
        return addressBookRepository.findContact(addressBookName,addressBook);
    }

    @Override
    public void updateContact(String addressBookName, Hashtable<String, ArrayList<AddressBook>> addressBook) {
        addressBookRepository.updateContact(addressBookName,addressBook);
    }
}
