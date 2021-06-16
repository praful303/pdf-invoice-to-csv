package challenge.java.coding;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class ApplicationRunner {

	public static void main(String[] args) throws IOException {

		// Reading a text from PDF Invoice
		PDDocument document = PDDocument
				.load(new File(ApplicationRunner.class.getClassLoader().getResource("sampleInvoice.pdf").getFile()));

		PDFTextStripper s = new PDFTextStripper();
		String content = s.getText(document);

		// Reading Table content
		int start = content.indexOf("DESCRIPTION");
		int end = content.indexOf("Terms");
		String table = content.substring(start, end);

		//Writing content to CSV file
		CsvWriterSample simple = new CsvWriterSample();
		List<String> myTableContentList = Arrays.asList(table.split("\n"));
		simple.writeCSV(myTableContentList);
		System.out.println("CSV generated Successfully");
	}

}
