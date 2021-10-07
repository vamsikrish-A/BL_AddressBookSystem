import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Hashtable;

public class ReadWriteOperations {
    String filepath = "src/main/java/AddressBookData";

    public void writeInAddressBook(Hashtable<String, ArrayList<AddressBook>>addressBook) {
        StringBuffer addBuffer = new StringBuffer();
        addressBook.forEach( (companyName, personInfos ) -> {
            String addDataString = companyName.concat(personInfos.toString().concat("\n"));
            addBuffer.append(addDataString);
        });

        try {
            Files.write(Paths.get(filepath), addBuffer.toString().getBytes(StandardCharsets.UTF_8));

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFromAddressBook() {
        try {
            Files.lines(new File(filepath).toPath()).forEach(System.out::println);
        }catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
