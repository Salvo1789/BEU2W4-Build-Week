package epicode.bw5.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import epicode.bw5.entities.Comune;

public class CSVHelper {
	public static String TYPE = "text/csv";
	static String[] HEADERs = { "Codice Provincia (Storico)(1)", "Progressivo del Comune (2)",
			"Denominazione in italiano" };

	public static boolean hasCSVFormat(MultipartFile file) {

		if (!TYPE.equals(file.getContentType())) {
			return false;
		}

		return true;
	}

	public static List<Comune> csvToComuni(InputStream is) {
		try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				CSVParser csvParser = new CSVParser(fileReader,
						CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

			List<Comune> comuni = new ArrayList<Comune>();

			Iterable<CSVRecord> csvRecords = csvParser.getRecords();

			for (CSVRecord csvRecord : csvRecords) {
				Comune comune = new Comune(csvRecord.get("Codice Provincia (Storico)(1)"),
						csvRecord.get("Progressivo del Comune (2)"), csvRecord.get("Denominazione in italiano"), null);

				comuni.add(comune);
			}

			return comuni;
		} catch (IOException e) {
			throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
		}
	}
}
