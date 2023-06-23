package epicode.bw5.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import epicode.bw5.entities.Cliente;
import epicode.bw5.entities.Comune;
import epicode.bw5.entities.Indirizzo;
import epicode.bw5.entities.payloads.AssegnaIndirizzoPayload;
import epicode.bw5.entities.payloads.ModificaIndirizzoPayload;
import epicode.bw5.exceptions.BadRequestException;
import epicode.bw5.exceptions.NotFoundException;
import epicode.bw5.repositories.IndirizziRepository;

@Service
public class IndirizziService {
	@Autowired
	private IndirizziRepository indirizziRepo;
	@Autowired
	private ClientiService clientiService;
	@Autowired
	private ComuniService comuniService;

	public Page<Indirizzo> find(int page, int size, String sortBy) {
		if (size < 0)
			size = 10;
		if (size > 100)
			size = 100;
		Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));

		return indirizziRepo.findAll(pageable);
	}

	public Indirizzo findById(UUID id) throws NotFoundException {
		return indirizziRepo.findById(id).orElseThrow(() -> new NotFoundException("Indirizzo non trovato!"));

	}

	public Indirizzo findByIdAndUpdate(UUID id, ModificaIndirizzoPayload u) {
		Indirizzo found = this.findById(id);
		Cliente cliente = clientiService.findById(u.getIdCliente());
		Comune comune = comuniService.findByNome(u.getNomeComune());
//		if (cliente.getListaIndirizzi().size() == 2) {
//			throw new BadRequestException("Il cliente non può avere più di 2 indirizzi!");
//		}
		found.setId(id);
		found.setVia(u.getVia());
		found.setCivico(u.getCivico());
		found.setLocalita(u.getLocalita());
		found.setCap(u.getCap());
		found.setComune(comune);
		found.setCliente(cliente);
		return indirizziRepo.save(found);

	}

	public Indirizzo assegnaCliente(UUID id, AssegnaIndirizzoPayload u) {

		Indirizzo found = this.findById(id);
		Cliente cliente = clientiService.findById(u.getIdCliente());
		if (cliente.getListaIndirizzi().size() == 2) {
			throw new BadRequestException("Il cliente non può avere più di 2 indirizzi!");
		}
		found.setId(id);
		found.setVia(found.getVia());
		found.setCivico(found.getCivico());
		found.setLocalita(found.getLocalita());
		found.setCap(found.getCap());
		found.setComune(found.getComune());
		found.setCliente(cliente);
		return indirizziRepo.save(found);

	}

	public Indirizzo create(ModificaIndirizzoPayload u) {

		Cliente cliente = clientiService.findById(u.getIdCliente());
		Comune comune = comuniService.findByNome(u.getNomeComune());
		Indirizzo newIndirizzo = new Indirizzo(u.getVia(), u.getCivico(), u.getLocalita(), u.getCap(), comune, cliente);
		return indirizziRepo.save(newIndirizzo);
	}

	public void findByIdAndDelete(UUID id) throws NotFoundException {
		Indirizzo found = this.findById(id);
		indirizziRepo.delete(found);

	}
}
