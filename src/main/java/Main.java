import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Main {

    private static final String SAMPLE_CSV_FILE = "/Users/Mac/Desktop/sample.csv";

    public static void main(String[] args) throws IOException {
        Faker faker = new Faker();
        Support s = new Support();
        ArrayList<SingleRecord> myList = new ArrayList<SingleRecord>();
        for(int i=0;i<5;i++) {
            SingleRecord record = new SingleRecord();
            record.setItem(i+1);
            record.setCcard(faker.finance().creditCard());
            record.setName(faker.name().firstName());
            record.setLname(faker.name().lastName());
            record.setCode(123+i);
            myList.add(record);
        }

        try (
                BufferedWriter writer = Files.newBufferedWriter(Paths.get(SAMPLE_CSV_FILE));

                CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                        .withHeader("Item", "CCard", "Name", "LName", "Code"));
        ) {
            for(SingleRecord si : myList) {
                csvPrinter.printRecord(si.getItem(), si.getCcard(), si.getName(), si.getLname(), si.getCode());
            }
            csvPrinter.flush();
        }

        //File csvFile = new File("/Users/Mac/Desktop/test2.csv");
        //System.out.println(myList.toString());
    }
}