package SeleniumActivity;

import java.io.FileReader;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;

public class Activity13_1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		FileReader file = new FileReader(
				"C:\\Users\\002H57744\\Documents\\IBM FST\\Workspace\\Selenium Activity\\src\\SeleniumActivity\\Activity13_TestData.csv");

		CSVReader reader = new CSVReader(file);

		List<String[]> data = reader.readAll();

		Iterator<String[]> it = data.iterator();

		while (it.hasNext()) {

			String[] row = it.next();
			for (int i = 0; i < row.length; i++)
				System.out.print(row[i]);
			System.out.println();
		}
	}

}
