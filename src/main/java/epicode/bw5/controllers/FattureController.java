package epicode.bw5.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import epicode.bw5.entities.Fattura;
import epicode.bw5.entities.StatoFattura;
import epicode.bw5.entities.payloads.AssegnaFatturaPayload;
import epicode.bw5.entities.payloads.ModificaFatturaPayload;
import epicode.bw5.entities.payloads.NuovaFatturaPayload;
import epicode.bw5.services.FattureService;

@RestController
@RequestMapping("/fatture")
public class FattureController {
	@Autowired
	FattureService fattureService;

	@GetMapping("")
	@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
	public Page<Fattura> getFatture(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id") String sortBy,
			@RequestParam(required = false) Optional<StatoFattura> stato) {
		return fattureService.find(page, size, sortBy, stato.orElse(null));
	}

	@PostMapping("")
	@PreAuthorize("hasAuthority('ADMIN')")
	@ResponseStatus(HttpStatus.CREATED)
	public Fattura createFattura(@RequestBody NuovaFatturaPayload body) {
		return fattureService.create(body);
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public Fattura getByIdAndUpdate(@PathVariable UUID id, @RequestBody ModificaFatturaPayload body) {
		return fattureService.findByIdAndUpdate(id, body);
	}

	@PutMapping("/{id}/assegna-cliente")
	@PreAuthorize("hasAuthority('ADMIN')")
	public Fattura AssegnaCliente(@PathVariable UUID id, @RequestBody AssegnaFatturaPayload body) {
		return fattureService.assegnaCliente(id, body);
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
	public Fattura getById(@PathVariable UUID id) throws Exception {
		return fattureService.findById(id);
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteFattura(@PathVariable UUID id) {
		fattureService.findByIdAndDelete(id);
	}

	@GetMapping("/{nomeCliente}")
	@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
	public List<Fattura> findByNomeCliente(@PathVariable String nomeCliente) {
		return fattureService.findByNomeCliente(nomeCliente);

	}

}
