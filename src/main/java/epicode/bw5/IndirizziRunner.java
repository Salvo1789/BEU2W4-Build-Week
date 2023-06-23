package epicode.bw5;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

import epicode.bw5.entities.Cliente;
import epicode.bw5.entities.Comune;
import epicode.bw5.entities.Indirizzo;
import epicode.bw5.repositories.ClientiRepository;
import epicode.bw5.repositories.ComuniRepository;
import epicode.bw5.repositories.IndirizziRepository;

@Component
public class IndirizziRunner implements CommandLineRunner {

	@Autowired
	IndirizziRepository indirizziRepo;

	@Autowired
	ClientiRepository clientiRepo;

	@Autowired
	ComuniRepository comuniRepo;

	@Override
	public void run(String... args) throws Exception {

		Faker faker = new Faker(new Locale("it"));

		List<Cliente> clientiDB = clientiRepo.findAll();
		List<Indirizzo> indirizziDB = indirizziRepo.findAll();
		List<Comune> comuniDB = comuniRepo.findAll();

		if (indirizziDB.size() == 0) {
			for (int i = 0; i < 10; i++) {
				try {
					// Genera un indice casuale per selezionare un cliente dalla lista
					int randomIndex = faker.random().nextInt(clientiDB.size());
					Cliente cliente = clientiDB.get(randomIndex);

//					// Conta il numero di volte che il cliente è stato utilizzato
//					int count = 0;
//					for (Indirizzo indirizzo : indirizziDB) {
//						if (indirizzo.getCliente() == cliente) {
//							count++;
//						}
//					}

					// Verifica se il cliente è stato utilizzato meno di 2 volte
					if (cliente.getListaIndirizzi().size() < 2) {
						String via = faker.address().fullAddress();
						String civico = String.valueOf(faker.number().randomNumber(3, true));
						String localita = faker.address().streetName();
						int cap = faker.random().nextInt(10000, 99999);
						int randomIndex2 = faker.random().nextInt(comuniDB.size());
						Comune comune = comuniDB.get(randomIndex2);

						Indirizzo indirizzo = new Indirizzo(via, civico, localita, cap, comune, cliente);
						indirizziRepo.save(indirizzo);
					}
				} catch (Exception e) {
					System.out.println(e);
				}
			}

		}

	}
}
