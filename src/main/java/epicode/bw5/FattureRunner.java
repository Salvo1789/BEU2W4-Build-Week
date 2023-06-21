package epicode.bw5;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

import epicode.bw5.entities.Cliente;
import epicode.bw5.entities.Fattura;
import epicode.bw5.entities.StatoFattura;
import epicode.bw5.repositories.ClientiRepository;
import epicode.bw5.repositories.FattureRepository;

@Component
public class FattureRunner implements CommandLineRunner {
	@Autowired
	FattureRepository fattureRepo;

	@Autowired
	ClientiRepository clientiRepo;

	@Override
	public void run(String... args) throws Exception {

		Faker faker = new Faker(new Locale("it"));

		List<Cliente> clientiDB = clientiRepo.findAll();
		List<Fattura> fattureDB = fattureRepo.findAll();

		if (fattureDB.size() == 0) {
			for (int i = 0; i < 10; i++) {
				try {
					LocalDate data = faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
					int anno = data.getYear();
					BigDecimal importo = BigDecimal.valueOf(faker.number().randomDouble(2, 100, 1500));

					Random random = new Random();
					int randomIndex = random.nextInt(clientiDB.size());
					int randomIndex2 = random.nextInt(StatoFattura.values().length);
					StatoFattura stato = StatoFattura.values()[randomIndex2];
					Cliente cliente = clientiDB.get(randomIndex);
					Fattura fattura = new Fattura(i + 1, anno, data, importo, cliente);
					fattura.setStato(stato);
					fattureRepo.save(fattura);
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}

	}

}
