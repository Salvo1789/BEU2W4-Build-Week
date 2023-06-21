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
import epicode.bw5.entities.Provincia;

public class CSVHelper {
	public static String TYPE = "text/csv";
	static String[] HEADERs = { "Codice Provincia (Storico)(1)", "Progressivo del Comune (2)",
			"Denominazione in italiano" };

	static String[] HEADERs2 = { "Sigla", "Provincia", "Regione" };

	public static boolean hasCSVFormat(MultipartFile file) {

		if (!TYPE.equals(file.getContentType())) {
			return false;
		}

		return true;
	}

	public static List<Comune> csvToComuni(InputStream is, List<Provincia> province) {
		try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withDelimiter(';').withTrim());) {

			List<Comune> comuni = new ArrayList<>();

			List<CSVRecord> csvRecords = csvParser.getRecords();

			for (int i = 1; i < csvRecords.size(); i++) {
				CSVRecord csvRecord = csvRecords.get(i);
				String codProvincia = csvRecord.get(0);
				String progressivoComune = csvRecord.get(1);
				String nomeComune = csvRecord.get(2);
				String provincia = csvRecord.get(3);

//              Provincia provincia = province.stream().filter(p -> p.getSigla().equals(codProvincia)).findFirst()
//                      .orElse(null);

				Comune comune = new Comune(codProvincia, progressivoComune, nomeComune,
						province.stream().filter(p -> p.getNome().contains(provincia)).findFirst().orElse(null));
				comuni.add(comune);
			}

			return comuni;
		} catch (IOException e) {
			throw new RuntimeException("Failed to parse CSV file: " + e.getMessage());
		}
	}

	public static List<Provincia> csvToProvince(InputStream is) {
		try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withDelimiter(';').withTrim());) {

			List<Provincia> province = new ArrayList<>();

			List<CSVRecord> csvRecords = csvParser.getRecords();

			for (int i = 1; i < csvRecords.size(); i++) {
				CSVRecord csvRecord = csvRecords.get(i);
				Provincia provincia = new Provincia(csvRecord.get(0), csvRecord.get(1), csvRecord.get(2));
				province.add(provincia);
			}

			return province;
		} catch (IOException e) {
			throw new RuntimeException("Fail to parse CSV file: " + e.getMessage());
		}
	}
}
