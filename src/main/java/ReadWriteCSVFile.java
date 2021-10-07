import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;


public class ReadWriteCSVFile {
    String filePath = "src/main/java";

    public void writeCSVFile(Hashtable<String , ArrayList<AddressBook>>addressBook) {
        addressBook.keySet().stream().forEach(companyName -> {
            File file = new File(filePath + companyName + ".csv");
            try {
                FileWriter outputfile = new FileWriter(file);
                CSVWriter writer = new CSVWriter(outputfile);

                //Add header to csv
                String[] header = { "FirstName", "LastName", "Address", "City", "State", "Zip", "PhoneNumber", "Email" };
                writer.writeNext(header);

                //Add data to csv
                addressBook.get(companyName).stream().forEach(personInfos -> {
                    String[] person1 = {personInfos.getFirst_name(), personInfos.getLast_name(), personInfos.getAddress(),
                            personInfos.getCity(), personInfos.getState(), String.valueOf(personInfos.getZip()),
                            personInfos.getPhone_number(), personInfos.getEmail()};
                    writer.writeNext(person1);
                });
                //close writer connection
                writer.close();
            }catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void readCSVFile() {
        Scanner input = new Scanner(System.in);
        System.out.println("\n reading Data from .csv file.");
        System.out.println("Enter name you want to ead details from : ");
        String companyName = input.next();

        String filePathRead = "src/AddressBookCSVop/" + companyName +".csv";
        try {
            FileReader fileReader = new FileReader(filePathRead);
            CSVReader csvReader = new CSVReader(fileReader);
            String [] nextRecord;

            //Reading data line by line.
            while ((nextRecord = csvReader.readNext()) != null) {
                for (String  cell : nextRecord) {
                    System.out.print(cell + "\t");
                }
                System.out.println();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
