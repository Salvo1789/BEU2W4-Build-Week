package epicode.bw5.controllers;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
			@RequestParam(required = false) Optional<StatoFattura> stato,
			@RequestParam(required = false) Optional<LocalDate> data, @RequestParam(defaultValue = "0") int anno,
			@RequestParam(defaultValue = "0") double importo1, @RequestParam(defaultValue = "1000000") double importo2,
			@RequestParam(defaultValue = "") String nomeCliente) {
		return fattureService.find(page, size, sortBy, stato.orElse(null), data.orElse(null), anno, importo1, importo2,
				nomeCliente);
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

	@PatchMapping("/{id}")
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

}
