import com.github.javafaker.Faker;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.testng.annotations.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {

    private static final String SAMPLE_CSV_FILE = "/Users/Mac/Desktop/sample4.csv";

    @Test
    public void generate() throws IOException {
        Faker faker = new Faker();
        Support s = new Support();
        ArrayList<SingleRecord> myList = new ArrayList<SingleRecord>();
        for(int i=0;i<100;i++) {
            SingleRecord record = new SingleRecord();
            record = s.createSingleRecord(i+1,faker.finance().creditCard(),faker.name().firstName(),faker.name().lastName(),123+i);
            /*record.setItem(i+1);
            record.setCcard(faker.finance().creditCard());
            record.setName(faker.name().firstName());
            record.setLname(faker.name().lastName());
            record.setCode(123+i);*/
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