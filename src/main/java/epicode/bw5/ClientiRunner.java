package epicode.bw5;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

import epicode.bw5.entities.Cliente;
import epicode.bw5.entities.TipoCliente;
import epicode.bw5.repositories.ClientiRepository;

@Component
public class ClientiRunner implements CommandLineRunner {
	@Autowired
	ClientiRepository clientiRepo;

	@Override
	public void run(String... args) throws Exception {
		Faker faker = new Faker(new Locale("it"));

		List<Cliente> clientiDB = clientiRepo.findAll();

		if (clientiDB.size() == 0) {
			for (int i = 0; i < 10; i++) {
				try {
					String ragioneSociale = faker.company().name();
					Random random = new Random();
					int randomIndex1 = random.nextInt(TipoCliente.values().length);
					TipoCliente tipoCliente = TipoCliente.values()[randomIndex1];
					String PIVA = String.valueOf(faker.number().randomNumber(10, true));
					long fatturatoAnnuale = faker.number().randomNumber(6, true);

					String email = faker.internet().emailAddress();
					String pec = faker.internet().emailAddress();

					String telefono = String.valueOf(faker.number().randomNumber(10, true));
					String emailContatto = faker.internet().emailAddress();
					String nomeContatto = faker.name().firstName();
					String cognomeContatto = faker.name().lastName();
					String telefonoContatto = String.valueOf(faker.number().randomNumber(10, true));

					Cliente newCliente = new Cliente(ragioneSociale, tipoCliente, PIVA, email, LocalDate.now(),
							LocalDate.now(), fatturatoAnnuale, pec, telefono, emailContatto, nomeContatto,
							cognomeContatto, telefonoContatto);
					clientiRepo.save(newCliente);
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}

	}

}
