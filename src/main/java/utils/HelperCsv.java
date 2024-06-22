package utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class HelperCsv {
        @DataProvider(name = "users_csv")
        public static Object[][] readUsersFromCsv(String filename) throws IOException, CsvException {
            try (CSVReader scvReader = new CSVReader(new FileReader(filename))) {
                List<String[]> scvData = scvReader.readAll();
                Object[][] csvDataObject = new Object[scvData.size()][2];
                for (int i = 0; i < scvData.size(); i++) {
                    csvDataObject[i] = scvData.get(i);
                }
                return csvDataObject;
            }
        }
    }


