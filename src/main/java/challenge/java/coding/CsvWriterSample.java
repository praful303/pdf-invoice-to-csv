package challenge.java.coding;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;

public class CsvWriterSample {
	
	public void writeCSV(List<String> tableContent) throws IOException {
		
		List<String[]> myList = new ArrayList<String[]>();

		String header = tableContent.stream().findFirst().orElse("noheaders");
		String[] headers = header.trim().split(" ");
		myList.add(headers);
		if (!header.equalsIgnoreCase("noheaders") && tableContent.size() > 1) {
			List<String> recordList = tableContent.subList(1, tableContent.size());
			for (String record : recordList) {
				String[] row = record.trim().split(" ");
				myList.add(row);
			}
		}
		try (CSVWriter writer = new CSVWriter(new FileWriter("sample.csv"))) {
			writer.writeAll(myList);
		}

	}
}