package epicode.bw5.services;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import epicode.bw5.entities.Cliente;
import epicode.bw5.entities.Fattura;
import epicode.bw5.entities.Indirizzo;
import epicode.bw5.entities.payloads.ModificaClientePayload;
import epicode.bw5.exceptions.BadRequestException;
import epicode.bw5.exceptions.NotFoundException;
import epicode.bw5.repositories.ClientiRepository;

@Service
public class ClientiService {
	@Autowired
	private ClientiRepository clientiRepo;

	public Cliente findById(UUID id) throws NotFoundException {
		return clientiRepo.findById(id).orElseThrow(() -> new NotFoundException("Cliente non trovato!"));

	}

	public Page<Cliente> find(int page, int size, String sortBy, long fatturato, LocalDate dataInserimento,
			LocalDate dataUltimoContatto, String nomeCliente) {
		if (size < 0)
			size = 10;
		if (size > 100)
			size = 100;
		if (fatturato < 0)
			fatturato = 0;
		if (fatturato > 1000000)
			fatturato = 1000000;
		Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
		if (fatturato > 0) {
			return clientiRepo.findByFatturatoAnnuale(fatturato, pageable);
		} else if (dataInserimento != null) {
			return clientiRepo.findByDataInserimento(dataInserimento, pageable);
		} else if (dataUltimoContatto != null) {
			return clientiRepo.findByDataUltimoContatto(dataUltimoContatto, pageable);
		} else if (!nomeCliente.equals("")) {
			return clientiRepo.findByRagioneSocialeContaining(nomeCliente, pageable);
		} else {
			return clientiRepo.findAll(pageable);
		}
	}

	public Cliente findByIdAndUpdate(UUID id, ModificaClientePayload u) {

		Cliente found = this.findById(id);
		found.setId(id);
		found.setTipo(u.getTipo());
		found.setEmail(u.getEmail());
		found.setDataInserimento(u.getDataInserimento());
		found.setDataUltimoContatto(u.getDataUltimoContatto());
		found.setFatturatoAnnuale(u.getFatturatoAnnuale());
		found.setPec(u.getPec());
		found.setTelefono(u.getTelefono());
		found.setEmailContatto(u.getEmailContatto());
		found.setNomeContatto(u.getNomeContatto());
		found.setCognomeContatto(u.getCognomeContatto());
		found.setTelefonoContatto(u.getTelefonoContatto());
		found.setListaFatture(found.getListaFatture());
		found.setListaIndirizzi(found.getListaIndirizzi());

		return clientiRepo.save(found);

	}

	public Cliente create(ModificaClientePayload u) {

		clientiRepo.findByEmail(u.getEmail()).ifPresent(cliente -> {
			throw new BadRequestException("Email " + cliente.getEmail() + " already used!");
		});
		clientiRepo.findByEmailContatto(u.getEmailContatto()).ifPresent(cliente -> {
			throw new BadRequestException("Email contatto " + cliente.getEmailContatto() + " already used!");
		});
		Cliente newCliente = new Cliente(u.getRagioneSociale(), u.getTipo(), u.getPartitaIva(), u.getEmail(),
				u.getDataInserimento(), u.getDataUltimoContatto(), u.getFatturatoAnnuale(), u.getPec(), u.getTelefono(),
				u.getEmailContatto(), u.getNomeContatto(), u.getCognomeContatto(), u.getTelefonoContatto());
		return clientiRepo.save(newCliente);
	}

	public void findByIdAndDelete(UUID id) throws NotFoundException {
		Cliente found = this.findById(id);
		clientiRepo.delete(found);

	}

	public List<Indirizzo> getListaIndirizziByIdCliente(UUID idCliente) {
		return this.findById(idCliente).getListaIndirizzi();
	}

	public List<Fattura> getListaFattureByIdCliente(UUID idCliente) {
		return this.findById(idCliente).getListaFatture();
	}

	public Cliente findByRagioneSociale(String ragioneSociale) throws NotFoundException {
		return clientiRepo.findByRagioneSociale(ragioneSociale).orElseThrow(
				() -> new NotFoundException("Nessun cliente con ragione sociale: " + ragioneSociale + " trovato"));
	}

}
