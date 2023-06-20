package epicode.bw5.services;

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
import epicode.bw5.entities.payloads.AssegnaFatturaPayload;
import epicode.bw5.entities.payloads.ModificaFatturaPayload;
import epicode.bw5.entities.payloads.NuovaFatturaPayload;
import epicode.bw5.exceptions.BadRequestException;
import epicode.bw5.exceptions.NotFoundException;
import epicode.bw5.repositories.FattureRepository;

@Service
public class FattureService {
	@Autowired
	private FattureRepository fattureRepo;
	@Autowired
	private ClientiService clientiService;

	public Page<Fattura> find(int page, int size, String sortBy) {
		if (size < 0)
			size = 10;
		if (size > 100)
			size = 100;
		Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));

		return fattureRepo.findAll(pageable);
	}

	public Fattura findById(UUID id) throws NotFoundException {
		return fattureRepo.findById(id).orElseThrow(() -> new NotFoundException("Fattura non trovata!"));

	}

	public Fattura findByIdAndUpdate(UUID id, ModificaFatturaPayload u) {
		Fattura found = this.findById(id);
		Cliente cliente = clientiService.findById(u.getIdCliente());
		found.setId(id);
		found.setNumero(found.getNumero());
		found.setAnno(u.getAnno());
		found.setData(u.getData());
		found.setImporto(u.getImporto());
		found.setCliente(cliente);
		return fattureRepo.save(found);

	}

	public Fattura assegnaCliente(UUID id, AssegnaFatturaPayload u) {
		Fattura found = this.findById(id);
		Cliente cliente = clientiService.findById(u.getIdCliente());
		found.setId(id);
		found.setNumero(found.getNumero());
		found.setAnno(found.getAnno());
		found.setData(found.getData());
		found.setImporto(found.getImporto());
		found.setCliente(cliente);
		return fattureRepo.save(found);

	}

	public Fattura create(NuovaFatturaPayload u) {

		fattureRepo.findByNumero(u.getNumero()).ifPresent(fattura -> {
			throw new BadRequestException("Numero " + fattura.getNumero() + " already used!");
		});
		Cliente cliente = clientiService.findById(u.getIdCliente());
		Fattura newFattura = new Fattura(u.getNumero(), u.getAnno(), u.getData(), u.getImporto(), cliente);
		return fattureRepo.save(newFattura);
	}

	public void findByIdAndDelete(UUID id) throws NotFoundException {
		Fattura found = this.findById(id);
		fattureRepo.delete(found);

	}

	public List<Fattura> findByNomeCliente(String nomeCliente) {

		Cliente cliente = clientiService.findByRagioneSociale(nomeCliente);
		return cliente.getListaFatture();
	}

}